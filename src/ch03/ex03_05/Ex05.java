package ch03.ex03_05;

import java.io.File;
import java.io.FileInputStream;
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
		int height = (int)in.getHeight();
		System.out.println(width);
		System.out.println(height);
		WritableImage out = new WritableImage(width, height);
		for(int x =0; x < width; x++) {
			for(int y = 0; y < height; y++) {
				System.out.println("x:"+x+" y:"+y);
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
		Image image = new Image(new FileInputStream(new File("furano.jpg")));
		imageView.setImage(image);

		image = transform(image, Color::brighter);

		StackPane root = new StackPane();
		root.getChildren().add(imageView);

		Scene scene = new Scene(root, 200, 150);

		stage.setTitle("富良野");
		stage.setScene(scene);
		stage.show();

		//Thread.sleep(1000);


		//imageView.setImage(image);
		//stage.show();
	}

}
