package ch08.ex06;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;

public class Point2DSort {

	public static void sortPoint2D(List<Point2D> point2DList) {
		Collections.sort(point2DList,
				Comparator.comparingDouble((Point2D p) -> p.getX())
						.thenComparing((Point2D p) -> p.getY()));
	}

	public static void sortRectangle2D(List<Rectangle2D> rectangle2D) {
		Collections.sort(rectangle2D,
				Comparator.comparingDouble((Rectangle2D r) -> r.getWidth())
						.thenComparing((Rectangle2D r) -> r.getHeight()));
	}

}
