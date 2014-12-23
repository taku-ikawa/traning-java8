package ch04.ex04_09;

import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.Circle;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Ex09 extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		Circle circle = new Circle(30);
		circle.setFill(Color.BLUEVIOLET);

		MoveTo moveTo = new MoveTo();
		moveTo.setX(200);
		moveTo.setY(300);

		ArcTo arcTo = new ArcTo();
		arcTo.setX(800);
		arcTo.setY(300);
		arcTo.setRadiusX(300);
		arcTo.setRadiusY(200);

		ArcTo arcTo2 = new ArcTo();
		arcTo2.setX(200);
		arcTo2.setY(300);
		arcTo2.setRadiusX(300);
		arcTo2.setRadiusY(200);

		Path path = new Path();
		path.getElements().addAll(moveTo, arcTo, arcTo2);

		PathTransition orbit = new PathTransition();
		orbit.setDuration(Duration.millis(3000));
		orbit.setPath(path);
		orbit.setNode(circle);

		orbit.setCycleCount(Animation.INDEFINITE);
		orbit.play();

		Group group = new Group();
		group.getChildren().add(path);
		group.getChildren().add(circle);

		stage.setScene(new Scene(group, 1000, 600));
		stage.setTitle(".....");
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
