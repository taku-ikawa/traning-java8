package ch02.ex02_13;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex13 {
	public static void main(String[] args) throws IOException {
		String contents = new String(
				Files.readAllBytes(Paths.get("alice.txt")),
				StandardCharsets.UTF_8);
		Stream<String> parallelWords = Stream.of(contents.split("[\\P{L}]+"))
				.parallel();

		Map<Object, Long> map = parallelWords
				.parallel()
				.filter(s -> s.length() < 12)
				.collect(
						Collectors.groupingBy(s -> s.length(),
								Collectors.counting()));
		System.out.println(map);
	}

}
