package ch03.ex03_13;

import java.util.function.UnaryOperator;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public interface ColorTransformer {
	Color apply(int x, int y, Color colorAtXY);

	public static ColorTransformer applyFrame(Image image, int frameWidth, Color frameColor) {
		return (x, y, color) -> {
			int width = (int)image.getWidth();
			int height = (int)image.getHeight();
			if((x < frameWidth) || ((width-frameWidth) <= x) || (y < frameWidth) || ((height-frameWidth) <= y)) {
				return frameColor;
			}
			return color;
		};
	}

	public static ColorTransformer transformColor(UnaryOperator<Color> f) {
		return (x, y, color) -> f.apply(color);
	}

	public static ColorTransformer compose(ColorTransformer f1, ColorTransformer f2) {
		return (x, y, color) -> f2.apply(x, y, f1.apply(x, y, color));
	}

}
