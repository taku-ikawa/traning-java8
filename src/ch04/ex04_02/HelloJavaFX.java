package ch04.ex04_02;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class HelloJavaFX extends Application{

	@Override
	public void start(Stage stage) throws Exception {
		String inicialString = "Hello, JavaFX!";
		Label label = new Label(inicialString);
		label.setFont(new Font(100));
		TextField textField =  new TextField(inicialString);
		Greeting greeting = new Greeting();

		label.textProperty().bind(textField.textProperty());

		GridPane gridPane = new GridPane();
		gridPane.setHgap(10);
		gridPane.setVgap(16);

		Label greetLabel = new Label();
		greetLabel.setFont(new Font(20));
		gridPane.add(greetLabel, 2 ,3, 2, 1);

		Button button  = new Button("プロパティ生成");
		button.setFont(new Font(20));
		button.setOnAction(event -> {
			greeting.textProperty().bind(textField.textProperty());
			greetLabel.setText("プロパティ生成してテキストフィールドをバインド : "+greeting.getText());
		});
		button.setMaxHeight(Double.MAX_VALUE);
		button.setMaxWidth(Double.MAX_VALUE);

		gridPane.add(label, 2, 0, 2, 1);
		gridPane.add(textField, 2, 1, 2, 1);
		gridPane.add(button, 2 ,2, 1, 1);

		stage.setScene(new Scene(gridPane, 1000, 400));
		stage.setTitle(".....");
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
