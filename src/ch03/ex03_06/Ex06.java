package ch03.ex03_06;

import java.io.File;
import java.io.FileInputStream;
import java.util.function.BiFunction;

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

public class Ex06 extends Application{

	public static <T> Image transform(Image in, BiFunction<Color, T, Color> f, T tag) {
		int wakuWidth = 10;

		int width = (int)in.getWidth();
		int height = (int)in.getHeight();
		WritableImage out = new WritableImage(width, height);
		for(int x =0; x < width; x++) {
			for(int y = 0; y < height; y++) {
				if((x < wakuWidth) || ((width-wakuWidth) <= x) || (y < wakuWidth) || ((height-wakuWidth) <= y)) {
					out.getPixelWriter().setColor(x, y, Color.DARKGREY);
				}else {
					out.getPixelWriter().setColor(x, y, f.apply(in.getPixelReader().getColor(x, y), tag));
				}
			}
		}
		return out;
	}

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
				new KeyFrame(new Duration(3000), event -> imageView.setImage(transform(image,
						(c, factor) -> c.deriveColor(0, 1, factor, 1), //factor分だけcを明るくする
						3.0))) //ファクター3.0を使用する
				);
		timeline.play();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
