package ch08.ex06;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;

import org.junit.BeforeClass;
import org.junit.Test;

public class Point2DSortTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void test_point2d_01() {
		Point2D point2D_a = new Point2D(1, 1);
		Point2D point2D_b = new Point2D(2, 2);

		List<Point2D> point2DList = new ArrayList<Point2D>();
		point2DList.add(point2D_a);
		point2DList.add(point2D_b);

		Point2DSort.sortPoint2D(point2DList);

		assertEquals(point2D_a, point2DList.get(0));
	}

	@Test
	public void test_point2d_02() {
		Point2D point2D_a = new Point2D(2, 2);
		Point2D point2D_b = new Point2D(1, 1);

		List<Point2D> point2DList = new ArrayList<Point2D>();
		point2DList.add(point2D_a);
		point2DList.add(point2D_b);

		Point2DSort.sortPoint2D(point2DList);

		assertEquals(point2D_a, point2DList.get(1));
	}

	@Test
	public void test_point2d_03() {
		Point2D point2D_a = new Point2D(1, 1);
		Point2D point2D_b = new Point2D(1, 1);

		List<Point2D> point2DList = new ArrayList<Point2D>();
		point2DList.add(point2D_a);
		point2DList.add(point2D_b);

		Point2DSort.sortPoint2D(point2DList);

		assertEquals(point2D_a, point2DList.get(0));
	}

	@Test
	public void test_point2d_04() {
		Point2D point2D_a = new Point2D(2, 1);
		Point2D point2D_b = new Point2D(1, 2);

		List<Point2D> point2DList = new ArrayList<Point2D>();
		point2DList.add(point2D_a);
		point2DList.add(point2D_b);

		Point2DSort.sortPoint2D(point2DList);

		assertEquals(point2D_a, point2DList.get(1));
	}

	@Test
	public void test_point2d_05() {
		Point2D point2D_a = new Point2D(1, 2);
		Point2D point2D_b = new Point2D(1, 1);

		List<Point2D> point2DList = new ArrayList<Point2D>();
		point2DList.add(point2D_a);
		point2DList.add(point2D_b);

		Point2DSort.sortPoint2D(point2DList);

		assertEquals(point2D_a, point2DList.get(1));
	}
	
	
	@Test
	public void test_rectangle2d_06() {
		Rectangle2D rectangle2D_a = new Rectangle2D(0, 0, 1, 1);
		Rectangle2D rectangle2D_b = new Rectangle2D(0, 0, 2, 2);

		List<Rectangle2D> rectangle2DList = new ArrayList<Rectangle2D>();
		rectangle2DList.add(rectangle2D_a);
		rectangle2DList.add(rectangle2D_b);

		Point2DSort.sortRectangle2D(rectangle2DList);

		assertEquals(rectangle2D_a, rectangle2DList.get(0));
	}
	
	@Test
	public void test_rectangle2d_07() {
		Rectangle2D rectangle2D_a = new Rectangle2D(0, 0, 2, 2);
		Rectangle2D rectangle2D_b = new Rectangle2D(0, 0, 1, 1);

		List<Rectangle2D> rectangle2DList = new ArrayList<Rectangle2D>();
		rectangle2DList.add(rectangle2D_a);
		rectangle2DList.add(rectangle2D_b);

		Point2DSort.sortRectangle2D(rectangle2DList);

		assertEquals(rectangle2D_a, rectangle2DList.get(1));
	}
	
	@Test
	public void test_rectangle2d_08() {
		Rectangle2D rectangle2D_a = new Rectangle2D(0, 0, 1, 1);
		Rectangle2D rectangle2D_b = new Rectangle2D(0, 0, 1, 1);

		List<Rectangle2D> rectangle2DList = new ArrayList<Rectangle2D>();
		rectangle2DList.add(rectangle2D_a);
		rectangle2DList.add(rectangle2D_b);

		Point2DSort.sortRectangle2D(rectangle2DList);

		assertEquals(rectangle2D_a, rectangle2DList.get(0));
	}
	
	@Test
	public void test_rectangle2d_09() {
		Rectangle2D rectangle2D_a = new Rectangle2D(0, 0, 2, 1);
		Rectangle2D rectangle2D_b = new Rectangle2D(0, 0, 1, 2);

		List<Rectangle2D> rectangle2DList = new ArrayList<Rectangle2D>();
		rectangle2DList.add(rectangle2D_a);
		rectangle2DList.add(rectangle2D_b);

		Point2DSort.sortRectangle2D(rectangle2DList);

		assertEquals(rectangle2D_a, rectangle2DList.get(1));
	}
	
	@Test
	public void test_rectangle2d_10() {
		Rectangle2D rectangle2D_a = new Rectangle2D(0, 0, 1, 2);
		Rectangle2D rectangle2D_b = new Rectangle2D(0, 0, 1, 1);

		List<Rectangle2D> rectangle2DList = new ArrayList<Rectangle2D>();
		rectangle2DList.add(rectangle2D_a);
		rectangle2DList.add(rectangle2D_b);

		Point2DSort.sortRectangle2D(rectangle2DList);

		assertEquals(rectangle2D_a, rectangle2DList.get(1));
	}


}
