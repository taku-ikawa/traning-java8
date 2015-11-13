package ch09.ex08;

import static org.junit.Assert.*;

import org.junit.Test;

public class PointTest {

	@Test
	public void test() {
		Point p = new Point(Integer.MAX_VALUE, Integer.MAX_VALUE);
		int diff = p.compareTo(new Point(-1, 1));
		assertEquals(1, diff); // オーバーフローしなければOK
	}

}
