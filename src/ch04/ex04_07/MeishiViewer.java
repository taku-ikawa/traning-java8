package ch04.ex04_07;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MeishiViewer extends Application{

	@Override
	public void start(Stage stage) throws Exception {
		// デフォルト値はどこかから取ってこれることとする。
		Meishi meishi = new Meishi();
		meishi.setName("井川 拓");
		meishi.setShozoku("画像システム開発本部コントローラ開発センター第１開発室第３グループ");
		meishi.setTel("28384");

		Label meishiLabel = new Label("名刺");
		meishiLabel.setFont(new Font(20));

		Label nameTitle = new Label("名前：");
		Label shozokuTitle = new Label("所属：");
		Label telTitle = new Label("内線：");

		Label name = new Label(meishi.getName());
		Label shozoku = new Label(meishi.getShozoku());
		Label tel = new Label(meishi.getTel());

		TextField textFieldName =  new TextField();
		textFieldName.setVisible(false);
		TextField textFieldShozoku =  new TextField(meishi.getShozoku());
		textFieldShozoku.setVisible(false);
		TextField textFieldTel =  new TextField(meishi.getTel());
		textFieldTel.setVisible(false);

		Button button  = new Button("修正");
		button.setFont(new Font(20));
		button.setOnAction(event -> {
			name.textProperty().bind(textFieldName.textProperty());
			shozoku.textProperty().bind(textFieldShozoku.textProperty());
			tel.textProperty().bind(textFieldTel.textProperty());

			textFieldName.setText(meishi.getName());
			textFieldName.setVisible(true);
			textFieldShozoku.setText(meishi.getShozoku());
			textFieldShozoku.setVisible(true);
			textFieldTel.setText(meishi.getTel());
			textFieldTel.setVisible(true);
		});
		button.setMaxHeight(Double.MAX_VALUE);
		button.setMaxWidth(Double.MAX_VALUE);

		GridPane gridPane = new GridPane();

		// ここでコントロールの境界を設定する
		gridPane.setHgap(10);
		gridPane.setVgap(16);

		gridPane.setGridLinesVisible(true);

		gridPane.add(meishiLabel, 1, 0);

		gridPane.add(nameTitle, 1, 1);
		gridPane.add(name, 2, 1);
		gridPane.add(shozokuTitle, 1, 2);
		gridPane.add(shozoku, 2, 2);
		gridPane.add(telTitle, 1, 3);
		gridPane.add(tel, 2, 3);

		gridPane.add(button, 1 ,4);

		gridPane.add(textFieldName, 2, 5);
		gridPane.add(textFieldShozoku, 2, 6);
		gridPane.add(textFieldTel, 2, 7);

		stage.setScene(new Scene(gridPane, 1000, 400));
		stage.setTitle(".....");
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
