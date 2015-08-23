package ch03.ex03_14;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

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

	/**
	 * LatentImageとして蓄積された遅延操作を実行して結果をImageとして返す
	 * @return
	 */
	Image toImage() {
		int width = (int)in.getWidth();
		int height = (int)in.getHeight();
		WritableImage out = new WritableImage(width, height);
		for(int x =0; x < width; x++) {
			for(int y = 0; y < height; y++) {
				Color c = in.getPixelReader().getColor(x, y);
				for(ColorTransformer f : pendingColorTransformerOperatins) {
					c = f.apply(x, y, in.getPixelReader());
				}
				out.getPixelWriter().setColor(x, y, c);
			}
		}
		return out;
	}

}
