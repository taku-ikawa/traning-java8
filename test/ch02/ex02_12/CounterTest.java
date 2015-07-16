package ch02.ex02_12;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
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

		AtomicInteger[] counter = new Counter().count(parallelWords);
		System.out.println(Arrays.toString(counter));
	}

}
