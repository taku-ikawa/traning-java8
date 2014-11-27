package ch04.ex04_01;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Ex01 extends Application{

	@Override
	public void start(Stage stage) throws Exception {
		Label message = new Label("aaaaaaaaaaa");
		message.setFont(new Font(100));
		TextField textField =  new TextField();


		StackPane borderPane = new StackPane();
		borderPane.getChildren().add(message);
		borderPane.getChildren().add(textField);

		stage.setScene(new Scene(borderPane, 600, 300));
		stage.setTitle(".....");
		stage.show();
	}

	public class MyTextField {
		private StringProperty text = new SimpleStringProperty("");
		public final StringProperty textProperty() {
			return text;
		}
		public final void setText(String newValue) {
			text.set(newValue);
		}
		public final String getText() {
			return text.get();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
