package ch04.ex04_08;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Ex08 extends Application{

	@Override
	public void start(Stage stage) throws Exception {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("dialog.fxml"));

			TextField username = (TextField) root.lookup("#username");
			PasswordField password = (PasswordField) root.lookup("#password");

			stage.setScene(new Scene(root, 1000, 150));
			stage.setTitle(".....");
			stage.show();
		}catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
