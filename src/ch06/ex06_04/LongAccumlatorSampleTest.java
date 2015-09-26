package ch06.ex06_04;

import static org.junit.Assert.*;

import org.junit.Test;

public class LongAccumlatorSampleTest {

	@Test
	public void test() {
		LongAccumlatorSample s = new LongAccumlatorSample();

		long[] testArray = {3, 1, 7, 5};
		assertEquals(7, s.getMaxValue(testArray));
		assertEquals(1, s.getMinValue(testArray));
	}

}
