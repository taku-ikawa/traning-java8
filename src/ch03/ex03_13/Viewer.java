package ch03.ex03_13;

import java.io.File;
import java.io.FileInputStream;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Viewer extends Application{

	@Override
	public void start(Stage stage) throws Exception {
		ImageView imageView = new ImageView();
		StackPane root = new StackPane();
		root.getChildren().add(imageView);
		Scene scene = new Scene(root, 200, 150);
		stage.setTitle("富良野");
		stage.setScene(scene);
		stage.show();

		Image image = new Image(new FileInputStream(new File("furano.jpg")));

		Timeline timeline = new Timeline(
				new KeyFrame(new Duration(1), event -> imageView.setImage(image)),
				new KeyFrame(new Duration(1500), event -> imageView.setImage(
						LatentImage.from(image)
						.transform((i) -> {
							// ぼかし
							int width = (int)i.getWidth();
							int height = (int)i.getHeight();
							WritableImage out = new WritableImage(width, height);
							for(int x =0; x < width; x++) {
								for(int y = 0; y < height; y++) {
									Color c = boyake(x, y, i);
									out.getPixelWriter().setColor(x, y, c);
								}
							}
							return out;
						})
						.transform((i) -> {
							// エッジ
							int width = (int)i.getWidth();
							int height = (int)i.getHeight();
							WritableImage out = new WritableImage(width, height);
							for(int x =0; x < width; x++) {
								for(int y = 0; y < height; y++) {
									Color c = edge(x, y, i);
									out.getPixelWriter().setColor(x, y, c);
								}
							}
							return out;
						})
						.toImage()))
				);
		timeline.play();
	}

	private Color boyake(int x, int y, Image image) {
		// 四隅
		if(x == 0 && y == 0) {
			Color c_base = image.getPixelReader().getColor(x, y);
			Color c2 = image.getPixelReader().getColor(x, y+1);
			Color c3 = image.getPixelReader().getColor(x+1, y);
			Color c4 = image.getPixelReader().getColor(x+1, y+1);
			return average(c_base.getOpacity(), c_base, c2, c3, c4);
		}
		if(x == 0 && y == (int)image.getHeight()-1) {
			Color c_base = image.getPixelReader().getColor(x, y);
			Color c2 = image.getPixelReader().getColor(x, y-1);
			Color c3 = image.getPixelReader().getColor(x+1, y);
			Color c4 = image.getPixelReader().getColor(x+1, y-1);
			return average(c_base.getOpacity(), c_base, c2, c3, c4);
		}
		if(x == (int)image.getWidth()-1 && y == 0) {
			Color c_base = image.getPixelReader().getColor(x, y);
			Color c2 = image.getPixelReader().getColor(x, y+1);
			Color c3 = image.getPixelReader().getColor(x-1, y);
			Color c4 = image.getPixelReader().getColor(x-1, y+1);
			return average(c_base.getOpacity(), c_base, c2, c3, c4);
		}
		if(x == (int)image.getWidth()-1 && y == (int)image.getHeight()-1) {
			Color c_base = image.getPixelReader().getColor(x, y);
			Color c2 = image.getPixelReader().getColor(x, y-1);
			Color c3 = image.getPixelReader().getColor(x-1, y);
			Color c4 = image.getPixelReader().getColor(x-11, y-1);
			return average(c_base.getOpacity(), c_base, c2, c3, c4);
		}
		//淵
		if(x == 0 && y != 0 && y != (int)image.getHeight()-1) {
			Color c_base = image.getPixelReader().getColor(x, y);
			Color c2 = image.getPixelReader().getColor(x, y-1);
			Color c3 = image.getPixelReader().getColor(x, y+1);
			Color c4 = image.getPixelReader().getColor(x+1, y);
			Color c5 = image.getPixelReader().getColor(x+1, y-1);
			Color c6 = image.getPixelReader().getColor(x+1, y+1);
			return average(c_base.getOpacity(), c_base, c2, c3, c4, c5, c6);
		}
		if(x == (int)image.getWidth()-1 && y != 0 && y != (int)image.getHeight()-1) {
			Color c_base = image.getPixelReader().getColor(x, y);
			Color c2 = image.getPixelReader().getColor(x, y-1);
			Color c3 = image.getPixelReader().getColor(x, y+1);
			Color c4 = image.getPixelReader().getColor(x-1, y);
			Color c5 = image.getPixelReader().getColor(x-1, y-1);
			Color c6 = image.getPixelReader().getColor(x-1, y+1);
			return average(c_base.getOpacity(), c_base, c2, c3, c4, c5, c6);
		}
		if(x != 0 && x != (int)image.getWidth()-1 && y == 0) {
			Color c_base = image.getPixelReader().getColor(x, y);
			Color c2 = image.getPixelReader().getColor(x-1, y);
			Color c3 = image.getPixelReader().getColor(x+1, y);
			Color c4 = image.getPixelReader().getColor(x, y+1);
			Color c5 = image.getPixelReader().getColor(x-1, y+1);
			Color c6 = image.getPixelReader().getColor(x+1, y+1);
			return average(c_base.getOpacity(), c_base, c2, c3, c4, c5, c6);
		}
		if(x != 0 && x != (int)image.getWidth()-1 && y == (int)image.getHeight()-1) {
			Color c_base = image.getPixelReader().getColor(x, y);
			Color c2 = image.getPixelReader().getColor(x-1, y);
			Color c3 = image.getPixelReader().getColor(x+1, y);
			Color c4 = image.getPixelReader().getColor(x, y-1);
			Color c5 = image.getPixelReader().getColor(x-1, y-1);
			Color c6 = image.getPixelReader().getColor(x+1, y-1);
			return average(c_base.getOpacity(), c_base, c2, c3, c4, c5, c6);
		}
		// その他
		Color c_base = image.getPixelReader().getColor(x, y);
		Color c2 = image.getPixelReader().getColor(x-1, y);
		Color c3 = image.getPixelReader().getColor(x+1, y);
		Color c4 = image.getPixelReader().getColor(x, y-1);
		Color c5 = image.getPixelReader().getColor(x-1, y-1);
		Color c6 = image.getPixelReader().getColor(x+1, y-1);
		Color c7 = image.getPixelReader().getColor(x, y+1);
		Color c8 = image.getPixelReader().getColor(x-1, y+1);
		Color c9 = image.getPixelReader().getColor(x+1, y+1);
		return average(c_base.getOpacity(), c_base, c2, c3, c4, c5, c6, c7, c8, c9);
	}

	private Color average(double opacity, Color... colors) {
		double red = 0;
		double green = 0;
		double blue = 0;
		for(Color c : colors) {
			red = red + c.getRed();
			green = green + c.getGreen();
			blue = blue +c.getBlue();
		}
		red = red/colors.length;
		green = green/colors.length;
		blue = blue/colors.length;
		return new Color(red, green, blue, opacity);
	}

	private Color edge(int x, int y, Image image) {
		// 四隅
		if(x == 0 && y == 0) {
			return image.getPixelReader().getColor(x, y);
		}
		if(x == 0 && y == (int)image.getHeight()-1) {
			return image.getPixelReader().getColor(x, y);
		}
		if(x == (int)image.getWidth()-1 && y == 0) {
			return image.getPixelReader().getColor(x, y);
		}
		if(x == (int)image.getWidth()-1 && y == (int)image.getHeight()-1) {
			return image.getPixelReader().getColor(x, y);
		}
		//淵
		if(x == 0 && y != 0 && y != (int)image.getHeight()-1) {
			Color c_base = image.getPixelReader().getColor(x, y);
			Color c2 = image.getPixelReader().getColor(x, y-1);
			Color c3 = image.getPixelReader().getColor(x, y+1);
			Color c4 = image.getPixelReader().getColor(x+1, y);
			return calculateEdge(c_base.getOpacity(), c_base, c_base, c2, c3, c4);
		}
		if(x == (int)image.getWidth()-1 && y != 0 && y != (int)image.getHeight()-1) {
			Color c_base = image.getPixelReader().getColor(x, y);
			Color c2 = image.getPixelReader().getColor(x, y-1);
			Color c3 = image.getPixelReader().getColor(x, y+1);
			Color c4 = image.getPixelReader().getColor(x-1, y);
			return calculateEdge(c_base.getOpacity(), c_base, c_base, c2, c3, c4);
		}
		if(x != 0 && x != (int)image.getWidth()-1 && y == 0) {
			Color c_base = image.getPixelReader().getColor(x, y);
			Color c2 = image.getPixelReader().getColor(x-1, y);
			Color c3 = image.getPixelReader().getColor(x+1, y);
			Color c4 = image.getPixelReader().getColor(x, y+1);
			return calculateEdge(c_base.getOpacity(), c_base, c_base, c2, c3, c4);
		}
		if(x != 0 && x != (int)image.getWidth()-1 && y == (int)image.getHeight()-1) {
			Color c_base = image.getPixelReader().getColor(x, y);
			Color c2 = image.getPixelReader().getColor(x-1, y);
			Color c3 = image.getPixelReader().getColor(x+1, y);
			Color c4 = image.getPixelReader().getColor(x, y-1);
			return calculateEdge(c_base.getOpacity(), c_base, c_base, c2, c3, c4);
		}
		// その他
		Color c_base = image.getPixelReader().getColor(x, y);
		Color c2 = image.getPixelReader().getColor(x-1, y);
		Color c3 = image.getPixelReader().getColor(x+1, y);
		Color c4 = image.getPixelReader().getColor(x, y-1);
		Color c5 = image.getPixelReader().getColor(x, y+1);
		return calculateEdge(c_base.getOpacity(), c_base, c2, c3, c4, c5);
	}

	private Color calculateEdge(double opacity, Color c, Color... others) {
		double red = c.getRed()*4;
		double green = c.getGreen()*4;
		double blue = c.getBlue()*4;
		for(Color other : others) {
			red = red - other.getRed();
			green = green - other.getGreen();
			blue = blue - other.getBlue();
		}
		if(red < 0) {
			red = 0;
		}else if(red > 1){
			red = 1;
		}
		if(green < 0) {
			green = 0;
		}else if(green > 1){
			green = 1;
		}
		if(blue < 0) {
			blue = 0;
		}else if(blue > 1){
			blue = 1;
		}
		
		return new Color(red, green, blue, opacity);
	}


	public static void main(String[] args) {
		launch(args);
	}
}
