package ch03.ex03_07;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class Ex07Test {

	@Test
	public void test() {
		List<String> list = Arrays.asList("a", " a", "ef");
		Collections.sort(list, Ex07.createComparator(true, true, false));
		assertEquals(" a", list.get(0));


	}

}
