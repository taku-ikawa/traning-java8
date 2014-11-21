package ch03.ex03_08;

import java.util.function.UnaryOperator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Ex05 extends Application{

	public static Image transform(Image in, UnaryOperator<Color> f) {
		int width = (int)in.getWidth();
		int height = (int)in.getWidth();
		WritableImage out = new WritableImage(width, height);
		for(int x =0; x < width; x++) {
			for(int y = 0; y < height; y++) {
				out.getPixelWriter().setColor(x, y, f.apply(in.getPixelReader().getColor(x, y)));
			}
		}
		return out;
	}

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		ImageView imageView = new ImageView();
		Image image = new Image(getClass().getResourceAsStream("test.jpg"));
		imageView.setImage(image);

		StackPane root = new StackPane();
		root.getChildren().add(imageView);

		Scene scene = new Scene(root, 300, 250);

		stage.setTitle("Hello World!");
		stage.setScene(scene);
		stage.show();

	}

}
