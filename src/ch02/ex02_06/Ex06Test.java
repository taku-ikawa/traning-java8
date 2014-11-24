package ch02.ex02_06;

import static org.junit.Assert.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class Ex06Test {

	@Test
	public void test() {
		String str = "java8";
		Stream<Character> stream = Ex06.characterStream(str);

		List<Character> charList = stream.collect(Collectors.toList());

		assertTrue(charList.get(0) == 'j');
		assertTrue(charList.get(1) == 'a');
		assertTrue(charList.get(2) == 'v');
		assertTrue(charList.get(3) == 'a');
		assertTrue(charList.get(4) == '8');
	}

}
