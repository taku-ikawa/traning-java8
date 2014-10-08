package ch02.ex02_05;

import java.util.stream.Stream;

public class Ex05 {

	public static void main(String[] args) {

		long a = 25214903917L;
		int c = 11;
		long m = (long) Math.pow(2, 48);

		long seed = 0;

		Stream<Long> stream = Stream.iterate(0L, n -> ((a * n) + c) % m).limit(100);

		stream.forEach(System.out::println);
	}

}
