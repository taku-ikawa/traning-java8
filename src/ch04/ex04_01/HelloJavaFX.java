package ch04.ex04_01;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class HelloJavaFX extends Application{

	@Override
	public void start(Stage stage) throws Exception {
		String inicialString = "Hello, JavaFX!";
		Label label = new Label(inicialString);
		label.setFont(new Font(100));
		TextField textField =  new TextField(inicialString);

		label.textProperty().bind(textField.textProperty());

		BorderPane borderPane = new BorderPane();
		borderPane.setTop(label);
		borderPane.setBottom(textField);

		stage.setScene(new Scene(borderPane, 1000, 150));
		stage.setTitle(".....");
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
