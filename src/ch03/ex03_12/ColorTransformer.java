package ch03.ex03_12;

import java.util.Objects;
import java.util.function.UnaryOperator;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public interface ColorTransformer {

	Color apply(int x, int y, Color colorAtXY);

	/**
	 * ImageをColorTransformerに従ってカスタマイズされたImageに変換します
	 *
	 * @param in
	 * @param f
	 * @return
	 * @throws NullPointerException 各引数がnullのケース
	 */
	public static Image transform(Image in, ColorTransformer f) {
		Objects.requireNonNull(in, "in is null");
		Objects.requireNonNull(f, "f is null");

		int width = (int)in.getWidth();
		int height = (int)in.getHeight();
		WritableImage out = new WritableImage(width, height);
		for(int x =0; x < width; x++) {
			for(int y = 0; y < height; y++) {
				out.getPixelWriter().setColor(x, y, f.apply(x, y, in.getPixelReader().getColor(x, y)));
			}
		}
		return out;
	}

//	/**
//	 * ImageをBiFunctionに従ってカスタマイズされたImageに変換します
//	 *
//	 * @param in
//	 * @param f
//	 * @param tag
//	 * @return
//	 * @throws NullPointerException 各引数がnullのケース
//	 */
//	public static <T> Image transform(Image in, BiFunction<Color, T, Color> f, T tag) {
//		Objects.requireNonNull(in, "in is null");
//		Objects.requireNonNull(f, "f is null");
//		Objects.requireNonNull(tag, "tag is null");
//
//		int wakuWidth = 10;
//
//		int width = (int)in.getWidth();
//		int height = (int)in.getHeight();
//		WritableImage out = new WritableImage(width, height);
//		for(int x =0; x < width; x++) {
//			for(int y = 0; y < height; y++) {
//				out.getPixelWriter().setColor(x, y, f.apply(in.getPixelReader().getColor(x, y), tag));
//			}
//		}
//		return out;
//	}

	/**
	 * Imageに対しフレームを設ける
	 *
	 * @param image
	 * @param frameWidth
	 * @param frameColor
	 * @throws NullPointerException ImageもしくはColorがnullのケース
	 * @throws IllegalArgumentException frameWidthの値が不正のケース
	 */
	public static ColorTransformer applyFrame(Image image, int frameWidth, Color frameColor) {
		Objects.requireNonNull(image, "image is null");
		Objects.requireNonNull(frameColor, "frameColor is null");
		if(frameWidth < 0 || frameWidth > (int)image.getWidth() || frameWidth > (int)image.getHeight()) {
			throw new IllegalArgumentException("frameWidth:"+frameWidth);
		}

		return (x, y, color) -> {
			int width = (int)image.getWidth();
			int height = (int)image.getHeight();
			if((x < frameWidth) || ((width-frameWidth) <= x) || (y < frameWidth) || ((height-frameWidth) <= y)) {
				return frameColor;
			}
			return color;
		};
	}

	/**
	 * x座標とy座標を無視するColorTransformerへUnaryOperatorを変換する
	 * @param f
	 * @return
	 * @throws NullPointerException fがnullのケース
	 */
	public static ColorTransformer transformColor(UnaryOperator<Color> f) {
		Objects.requireNonNull(f, "f is null");
		return (x, y, color) -> f.apply(color);
	}

	/**
	 * 2つのColorTransformerオブジェクトを合成する
	 * @param f1
	 * @param f2
	 * @return
	 * @throws NullPointerException f1f2がnullのケース
	 */
	public static ColorTransformer compose(ColorTransformer f1, ColorTransformer f2) {
		Objects.requireNonNull(f1, "f1 is null");
		Objects.requireNonNull(f2, "f2 is null");
		return (x, y, color) -> f2.apply(x, y, f1.apply(x, y, color));
	}

}
