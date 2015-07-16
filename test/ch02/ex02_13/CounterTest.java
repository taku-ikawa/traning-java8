package ch02.ex02_13;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.Test;

public class CounterTest {

	@Test
	public void test() throws IOException {
		String contents = new String(
				Files.readAllBytes(Paths.get("alice.txt")),
				StandardCharsets.UTF_8);
		Stream<String> parallelWords = Stream.of(contents.split("[\\P{L}]+"))
				.parallel();

		Map<Integer, Long> map = new Counter().count(parallelWords, 12);
		System.out.println(map);
	}

}
