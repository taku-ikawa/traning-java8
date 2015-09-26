package ch03.ex03_15;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.UnaryOperator;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

// 講義時メモ
// PixcelWriterはパラレルだとNGなのに無視している

public class LatentImage {

	private Image in;
	private List<ColorTransformer> pendingColorTransformerOperatins = new ArrayList<ColorTransformer>();

	private LatentImage(Image in) {
		this.in = in;
	}

	/**
	 * ColorTransformerで定義される遅延操作をLatentImageに変換する
	 * @param f
	 * @return
	 * @throws NullPointerException fがnullのケース
	 */
	LatentImage transform(UnaryOperator<Color> f) {
		Objects.requireNonNull(f, "f is null");
		pendingColorTransformerOperatins.add(ColorTransformer.transformColor(f));
		return this;
	}

	/**
	 * ColorTransformerで定義される遅延操作をLatentImageに変換する
	 * @param f
	 * @return
	 * @throws NullPointerException fがnullのケース
	 */
	LatentImage transform(ColorTransformer f) {
		Objects.requireNonNull(f, "f is null");
		pendingColorTransformerOperatins.add(f);
		return this;
	}

	/**
	 * LatentImageを生成する
	 * @param in
	 * @return
	 * @throws NullPointerException inがnullのケース
	 */
	static LatentImage from(Image in) {
		Objects.requireNonNull(in, "in is null");
		return new LatentImage(in);
	}

//	/**
//	 * LatentImageとして蓄積された遅延操作を実行して結果をImageとして返す
//	 * @return
//	 */
//	Image toImage() {
//		int width = (int)in.getWidth();
//		int height = (int)in.getHeight();
//		WritableImage out = new WritableImage(width, height);
//		for(int x =0; x < width; x++) {
//			for(int y = 0; y < height; y++) {
//				Color c = in.getPixelReader().getColor(x, y);
//				for(ColorTransformer f : pendingColorTransformerOperatins) {
//					c = f.apply(x, y, c);
//				}
//				out.getPixelWriter().setColor(x, y, c);
//			}
//		}
//		return out;
//	}

	Image toImage() {
		int n = Runtime.getRuntime().availableProcessors();
		System.out.println("processors:"+n);
		int width = (int)in.getWidth();
		int height = (int)in.getHeight();
		WritableImage out = new WritableImage(width, height);

		try {
			ExecutorService pool = Executors.newCachedThreadPool();
			for(int i =0; i < n; i++) {
				int fromY = i * height / n;
				int toY = (i +1) * height / n;
				pool.submit(() -> {
					for(int x = 0; x < width; x++) {
						for(int y = fromY; y < toY; y++) {
							Color c = in.getPixelReader().getColor(x, y);
							for(ColorTransformer f : pendingColorTransformerOperatins) {
								c = f.apply(x, y, c);
							}
							out.getPixelWriter().setColor(x, y, c);
						}
					}
				});
			}
			pool.shutdown();
			pool.awaitTermination(1, TimeUnit.HOURS);
		}catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		return out;
	}

}
