package ch03.ex03_08;

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
}
