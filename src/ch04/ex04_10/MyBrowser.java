package ch04.ex04_10;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class MyBrowser extends Application {

	private String currentUrl = "";
	private List<String> previousUrlList = new ArrayList<String>();

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

			String currentTmp = currentUrl;
			currentUrl = textField.getText();
			previousUrlList.add(currentTmp);

			engine.load(textField.getText());
		});

		button.setOnAction(event -> {
			if(previousUrlList.size() == 0) {
				return;
			}
			String previousUrl = previousUrlList.get(previousUrlList.size()-1);
			previousUrlList.remove(previousUrlList.size()-1);
			System.out.println("back:"+previousUrl);
			currentUrl = previousUrl;
			engine.load(previousUrl);
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
