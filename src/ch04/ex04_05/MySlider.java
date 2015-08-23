package ch04.ex04_05;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MySlider extends Application{

	private static final int BUTTON_WIDTH = 60;
	private static final int SCENE_WIDTH = 300;
	private static final int GAUGE_WIDTH = 300-(BUTTON_WIDTH*2);

	@Override
	public void start(Stage stage) throws Exception {
		BorderPane stackPane = new BorderPane();
		Scene scene = new Scene(stackPane, SCENE_WIDTH, 40);

		Label labelMin = new Label("min");
		labelMin.setFont(new Font(20));
		Label labelMax = new Label("max");
		labelMax.setFont(new Font(20));
		
		BorderPane bp = new BorderPane();
		bp.setLeft(labelMin);
		bp.setRight(labelMax);

		Slider slider = new Slider();
		slider.setMax(GAUGE_WIDTH);		
		labelMin.disableProperty().bind(Observer.observe(t -> t.intValue() > 0, slider.valueProperty()));
		labelMax.disableProperty().bind(Observer.observe(t -> t.intValue() < GAUGE_WIDTH, slider.valueProperty()));
		
		stackPane.setTop(bp);
		stackPane.setBottom(slider);

		stage.setScene(scene);
		stage.setTitle(".....");
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
