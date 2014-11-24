package ch02.ex02_08;

import static org.junit.Assert.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class ZipTest {

	@Test
	public void test() {
		Stream<String> stream = Zip.zip(Stream.of("a", "b"), Stream.of("x", "y", "z"));
		List<String> strList = stream.collect(Collectors.toList());
		assertEquals("a", strList.get(0));
		assertEquals("x", strList.get(1));
		assertEquals("b", strList.get(2));
		assertEquals("y", strList.get(3));
		assertTrue(4==strList.size());
	}

}
