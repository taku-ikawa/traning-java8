package ch02.ex02_04;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamOfTest {

	public static void main(String[] args) {
		int[] values = {1, 4, 9, 16};

		// Stream.of(values) は Stream<int[]> 型
		Stream<int[]> stream = Stream.of(values);
		System.out.println("---Stream.of(values)---");
		stream.forEach(System.out::println);

		IntStream intStream = IntStream.of(values);
		System.out.println("---IntStream.of(values)---");
		intStream.forEach(System.out::println);
	}

}
