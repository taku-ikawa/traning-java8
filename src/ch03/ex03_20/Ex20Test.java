package ch03.ex03_20;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Ex20Test {

	@Test
	public void test() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(0);
		list.add(1);
		list.add(2);

		List<String> l = Ex20.map(list, (Integer i) -> {
			return i.toString();
		});
		assertEquals("0", l.get(0));
		assertEquals("1", l.get(1));
		assertEquals("2", l.get(2));
	}

}
