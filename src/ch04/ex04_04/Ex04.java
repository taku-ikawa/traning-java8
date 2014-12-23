package ch04.ex04_04;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Ex04 extends Application{

	@Override
	public void start(Stage stage) throws Exception {
		StackPane stackPane = new StackPane();
		Scene scene = new Scene(stackPane, 1000, 400);

		Circle circle = new Circle();
		circle.centerXProperty().bind(Bindings.divide(scene.widthProperty(), 2));
		circle.radiusProperty().bind(Bindings.divide(scene.heightProperty(), 2));

		stackPane.getChildren().add(circle);

		stage.setScene(scene);
		stage.setTitle(".....");
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
