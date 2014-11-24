package ch02.ex02_05;

import java.util.stream.Stream;

public class Ex05 {

	public static Stream<Long> createRunfomStream(long a, int c, long m, long seed) {
		return Stream.iterate(seed, n -> ((a * n) + c) % m);
	}

}
