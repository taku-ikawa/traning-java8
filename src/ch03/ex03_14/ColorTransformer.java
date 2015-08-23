package ch03.ex03_14;

import javafx.scene.image.PixelReader;
import javafx.scene.paint.Color;

public interface ColorTransformer {

	Color apply(int x, int y, PixelReader pixelReader);

}
