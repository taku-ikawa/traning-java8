package ch03.ex03_09;

import static org.junit.Assert.*;

import java.util.Comparator;

import org.junit.Test;

public class LexicographicComparatorCreatorTest {

	@Test
	public void test1() {
		Comparator<Object> c = LexicographicComparatorCreator.lexicographicComparator("sampleField");
		assertEquals(0, c.compare(new SampleClass(10), new SampleClass(10)));
	}

	@Test
	public void test2() {
		Comparator<Object> c = LexicographicComparatorCreator.lexicographicComparator("sampleField");
		assertEquals(1, c.compare(new SampleClass(10), new SampleClass(20)));
	}
	
	@Test
	public void test3() {
		Comparator<Object> c = LexicographicComparatorCreator.lexicographicComparator("hogehoge");
		assertEquals(-1, c.compare(new SampleClass(10), new SampleClass(10)));
	}

	class SampleClass {
		private int sampleField;
		public SampleClass(int f) {
			sampleField = f;
		}
	}

}
