package ch09.ex09;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class LabeledPointTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void test_01() {
		LabeledPoint lp_01 = new LabeledPoint("label_01", 1, 1);
		LabeledPoint lp_02 = new LabeledPoint("label_01", 1, 1);
		assertTrue(lp_01.equals(lp_02));
	}
	
	@Test
	public void test_02() {
		LabeledPoint lp_01 = new LabeledPoint("label_01", 1, 1);
		LabeledPoint lp_02 = new LabeledPoint("label_02", 2, 2);
		assertFalse(lp_01.equals(lp_02));
	}
	
	@Test
	public void test_03() {
		LabeledPoint lp_01 = new LabeledPoint(null, 1, 1);
		LabeledPoint lp_02 = new LabeledPoint(null, 1, 1);
		assertTrue(lp_01.equals(lp_02));
	}
	
	@Test
	public void test_04() {
		LabeledPoint lp_01 = new LabeledPoint(null, 1, 1);
		LabeledPoint lp_02 = new LabeledPoint("label_02", 1, 1);
		assertFalse(lp_01.equals(lp_02));
	}

}
