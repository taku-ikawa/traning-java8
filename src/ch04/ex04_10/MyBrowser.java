package ch04.ex04_10;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
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
	private String tmpURL;
	private final Object backedLock = new Object();
	private boolean backed = false;

	@Override
	public void start(Stage stage) throws Exception {

		System.setProperty("proxySet", "true");
		System.setProperty("http.proxyHost", "proxy.ricoh.co.jp");
		System.setProperty("http.proxyPort", "8080");
		System.setProperty("https.proxyHost", "proxy.ricoh.co.jp");
		System.setProperty("https.prozyPort", "8080");
		Authenticator.setDefault(new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("p000480075", "dummy"
						.toCharArray());
			}
		});

		// URL入力欄
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

		// 戻るボタン
		button.setOnAction(event -> {
			if (previousUrlList.size() == 0) {
				return;
			}
			String previousUrl = previousUrlList.get(previousUrlList.size() - 1);
			previousUrlList.remove(previousUrlList.size() - 1);
			System.out.println("back:" + previousUrl);
			currentUrl = previousUrl;
			synchronized(backedLock) {
				backed = true;
			}
			engine.load(previousUrl);
		});

		// ページの遷移をURL入力欄に反映させる
		Worker<Void> loadWorker = engine.getLoadWorker();
		loadWorker.stateProperty().addListener(
				new ChangeListener<Worker.State>() {
					@Override
					public void changed(
							ObservableValue<? extends Worker.State> ov,
							Worker.State old, Worker.State next) {
						if (next == Worker.State.SUCCEEDED || next == Worker.State.FAILED || next == Worker.State.CANCELLED) {
							// 戻るボタントリガーでの更新の場合はなにもしない
							synchronized(backedLock) {
								if(backed) {
									backed = false;
									System.out.println("backed!!!!!!!");
									return;
								}
							}
						}
						if (next == Worker.State.SUCCEEDED) {
							// 更新されたURLを取得
							String updateUrl = engine.getLocation();
							// 更新前のURLをリストに追加
							System.out.println("SUCCEED:"+updateUrl);
							System.out.println("add:"+currentUrl);
							previousUrlList.add(currentUrl);
							// currentを更新
							currentUrl = updateUrl;
							// URL欄に反映
							textField.setText(updateUrl);
						}
					}
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
