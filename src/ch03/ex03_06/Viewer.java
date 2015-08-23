package ch03.ex03_06;

import java.io.File;
import java.io.FileInputStream;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
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
				new KeyFrame(new Duration(3000), event -> imageView.setImage(ColorTransformer.transform(image,
						(c, factor) -> c.deriveColor(0, 1, factor, 1), //factor分だけcを明るくする
						3.0))) //ファクター3.0を使用する
				);
		timeline.play();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
