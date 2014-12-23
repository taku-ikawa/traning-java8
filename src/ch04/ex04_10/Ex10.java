package ch04.ex04_10;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class Ex10 extends Application {

	private String tmpUrl = "";

	@Override
	public void start(Stage stage) throws Exception {

		System.setProperty("http.proxyHost", "proxy.ricoh.co.jp");
        System.setProperty("http.proxyPort", "8080");
        System.setProperty("https.proxyHost", "proxy.ricoh.co.jp");
        System.setProperty("https.prozyPort", "8080");

		TextField textField = new TextField();
		Button button = new Button("戻る");

		WebView webView = new WebView();
		WebEngine engine = webView.getEngine();

		textField.setOnAction(event -> {
			System.out.println(textField.getText());
			tmpUrl = textField.getText();
			engine.load(textField.getText());
		});

		button.setOnAction(event -> {
			engine.load(tmpUrl);
		});

		GridPane pane = new GridPane();
		pane.add(textField, 0, 0, 10, 1);
		pane.add(button, 10, 0, 1, 1);
		pane.add(webView, 0, 1, 10, 1);

		stage.setScene(new Scene(pane, 1000, 600));
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
