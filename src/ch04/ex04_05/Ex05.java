package ch04.ex04_05;

import java.util.function.BiFunction;
import java.util.function.Function;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Ex05 extends Application{

	private static final int BUTTON_WIDTH = 60;
	private static final int SCENE_WIDTH = 300;
	private static final int GAUGE_WIDTH = 300-(BUTTON_WIDTH*2);

	@Override
	public void start(Stage stage) throws Exception {
		BorderPane stackPane = new BorderPane();
		Scene scene = new Scene(stackPane, SCENE_WIDTH, 40);

		Rectangle guage = new Rectangle();
		guage.setHeight(20);

		Rectangle rectangle2 = new Rectangle();
		rectangle2.setStroke(Color.DODGERBLUE);
		rectangle2.setFill(null);
		rectangle2.setHeight(20);
		rectangle2.setWidth(GAUGE_WIDTH);

		Button smaller = new Button("Smaller");
		smaller.setMaxHeight(20);
		smaller.setPrefWidth(BUTTON_WIDTH);
		Button larger = new Button("Larger");
		larger.setMaxHeight(20);
		larger.setPrefWidth(BUTTON_WIDTH);

		GridPane gp = new GridPane();
		gp.add(smaller, 0, 0, 1, 1);
		gp.add(guage, 1, 0, 2, 1);
		gp.add(rectangle2, 1, 0, 2, 1);
		gp.add(larger, 3, 0, 1, 1);

		Slider slider = new Slider();
		slider.setMax(GAUGE_WIDTH);
		slider.valueProperty().addListener(property -> {
			guage.setWidth(slider.getValue());
		});

		smaller.disableProperty().bind(Bindings.lessThanOrEqual(guage.widthProperty(), 0));
		//larger.disableProperty().bind(Bindings.greaterThanOrEqual(guage.widthProperty(), GAUGE_WIDTH));

		larger.disableProperty().bind(observe(t -> t.intValue() >= GAUGE_WIDTH, guage.widthProperty()));

		stackPane.setTop(gp);
		stackPane.setBottom(slider);

		stage.setScene(scene);
		stage.setTitle(".....");
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

	public static <T, R> ObservableValue<R> observe(Function<T, R> f, ObservableValue<T> t) {
		return new ObservableValue<R>() {
			@Override
			public void addListener(InvalidationListener arg0) {
				t.addListener(arg0);
			}
			@Override
			public void removeListener(InvalidationListener arg0) {
				t.removeListener(arg0);
			}
			@Override
			public void addListener(ChangeListener arg0) {
				t.addListener(arg0);
			}
			@Override
			public void removeListener(ChangeListener arg0) {
				t.removeListener(arg0);
			};
			@Override
			public R getValue() {
				T tValue = t.getValue();
				R r = f.apply(tValue);
				return r;
			}
		};
	}

	public static <T, U, R> ObservableValue<R> observe(BiFunction<T, U, R> f, ObservableValue<T> t, ObservableValue<U> u) {
		return new ObservableValue<R>() {
			@Override
			public void addListener(InvalidationListener arg0) {
				t.addListener(arg0);
			}
			@Override
			public void removeListener(InvalidationListener arg0) {
				t.removeListener(arg0);
			}
			@Override
			public void addListener(ChangeListener arg0) {
				t.addListener(arg0);
			}
			@Override
			public void removeListener(ChangeListener arg0) {
				t.removeListener(arg0);
			};
			@Override
			public R getValue() {
				T tValue = t.getValue();
				U uValue = u.getValue();
				R r = f.apply(tValue, uValue);
				return r;
			}
		};
	}


}
