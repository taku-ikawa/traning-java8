package ch02.ex02_12;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Ex12 {
	public static void main(String[] args) throws IOException {
		String contents = new String(
				Files.readAllBytes(Paths.get("alice.txt")),
				StandardCharsets.UTF_8);
		Stream<String> parallelWords = Stream.of(contents.split("[\\P{L}]+"))
				.parallel();

		// 誤りの例
		//int[] shortWords = new int[12];
		//parallelWords.parallel().forEach(s -> {
		//	if (s.length() < 12)
		//		shortWords[s.length()]++;
		//});

		AtomicInteger[] counter = new AtomicInteger[12];
		parallelWords.parallel().forEach(s -> {
			if (s.length() < 12) {
				if (counter[s.length()] == null) {
					counter[s.length()] = new AtomicInteger();
				}
				counter[s.length()].getAndIncrement();
			}
		});
		System.out.println(Arrays.toString(counter));
	}
}
