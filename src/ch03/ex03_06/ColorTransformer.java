package ch03.ex03_06;

import java.util.Objects;
import java.util.function.BiFunction;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public interface ColorTransformer {
	
	// 講義時メモ
	// IntStreamで

//	Color apply(int x, int y, Color colorAtXY);
//
//	/**
//	 * ImageをColorTransformerに従ってカスタマイズされたImageに変換します
//	 *
//	 * @param in
//	 * @param f
//	 * @return
//	 * @throws NullPointerException 各引数がnullのケース
//	 */
//	public static Image transform(Image in, ColorTransformer f) {
//		Objects.requireNonNull(in, "in is null");
//		Objects.requireNonNull(f, "f is null");
//
//		int width = (int)in.getWidth();
//		int height = (int)in.getHeight();
//		WritableImage out = new WritableImage(width, height);
//		for(int x =0; x < width; x++) {
//			for(int y = 0; y < height; y++) {
//				out.getPixelWriter().setColor(x, y, f.apply(x, y, in.getPixelReader().getColor(x, y)));
//			}
//		}
//		return out;
//	}

	/**
	 * ImageをBiFunctionに従ってカスタマイズされたImageに変換します
	 *
	 * @param in
	 * @param f
	 * @param tag
	 * @return
	 * @throws NullPointerException 各引数がnullのケース
	 */
	public static <T> Image transform(Image in, BiFunction<Color, T, Color> f, T tag) {
		Objects.requireNonNull(in, "in is null");
		Objects.requireNonNull(f, "f is null");
		Objects.requireNonNull(tag, "tag is null");

		int wakuWidth = 10;

		int width = (int)in.getWidth();
		int height = (int)in.getHeight();
		WritableImage out = new WritableImage(width, height);
		for(int x =0; x < width; x++) {
			for(int y = 0; y < height; y++) {
				out.getPixelWriter().setColor(x, y, f.apply(in.getPixelReader().getColor(x, y), tag));
			}
		}
		return out;
	}
}
