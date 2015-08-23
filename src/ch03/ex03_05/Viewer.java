package ch03.ex03_05;

import java.io.File;
import java.io.FileInputStream;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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

				// 画像の表示
				new KeyFrame(new Duration(1), event -> imageView.setImage(image)),

				// 枠の表示
				new KeyFrame(new Duration(3000), event -> imageView.setImage(ColorTransformer.transform(image, (x, y, color) -> {
					int wakuWidth = 10;
					int width = (int)image.getWidth();
					int height = (int)image.getHeight();
					if((x < wakuWidth) || ((width-wakuWidth) <= x) || (y < wakuWidth) || ((height-wakuWidth) <= y)) {
						return Color.DARKGRAY;
					}
					return color;
				})))
				);
		timeline.play();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
