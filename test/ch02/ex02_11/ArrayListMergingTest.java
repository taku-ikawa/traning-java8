package ch02.ex02_11;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.stream.Stream;

import org.junit.Test;

public class ArrayListMergingTest {

	@Test
	public void test() {
		ArrayList<String> list1 = new ArrayList<String>();
		list1.add("a1");
		list1.add("b1");
		list1.add("c1");
		ArrayList<String> list2 = new ArrayList<String>();
		list1.add("a2");
		list1.add("b2");
		list1.add("c2");
		ArrayList<String> list3 = new ArrayList<String>();
		list1.add("a3");
		list1.add("b3");
		list1.add("c3");
		Stream<ArrayList<String>> stream = Stream.of(list1, list2, list3);
		ArrayList<String> list = ArrayListMerging.mergeStreamArrayList(stream);
		assertTrue(9 == list.size());
		assertEquals("a1", list.get(0));
		assertEquals("c3", list.get(list.size()-1));
	}

}
