package ch03.ex03_05;

import java.util.Objects;

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
}
