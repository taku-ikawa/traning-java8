package ch03.ex03_13;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class LatentImage {

	private Image in;
	private List<ColorTransformer> pendingColorTransformerOperatins = new ArrayList<ColorTransformer>();

	private LatentImage(Image in) {
		this.in = in;
	}

	LatentImage transform(UnaryOperator<Color> f) {
		pendingColorTransformerOperatins.add(ColorTransformer.transformColor(f));
		return this;
	}

	LatentImage transform(ColorTransformer f) {
		pendingColorTransformerOperatins.add(f);
		return this;
	}

	static LatentImage from(Image in) {
		return new LatentImage(in);
	}

	Image toImage() {
		int width = (int)in.getWidth();
		int height = (int)in.getHeight();
		WritableImage out = new WritableImage(width, height);
		
		Color[][] tmp = new Color[width][height];
		
		for(int x =0; x < width; x++) {
			for(int y = 0; y < height; y++) {
				tmp[x][y] = in.getPixelReader().getColor(x, y);
			}
		}
		
		for(ColorTransformer f : pendingColorTransformerOperatins) {
			for(int x =0; x < width; x++) {
				for(int y = 0; y < height; y++) {
					tmp[x][y] = f.apply(x, y, tmp[x][y]);
				}
			}
		}
		
		for(int x =0; x < width; x++) {
			for(int y = 0; y < height; y++) {
				out.getPixelWriter().setColor(x, y, tmp[x][y]);
			}
		}
		
		return out;
	}




}
