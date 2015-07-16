package ch02.ex02_05;

import java.util.stream.Stream;

public class LinearCongruentialGenerator {

	/**
	 * 線形合成生成機
	 * @param a
	 * @param c
	 * @param m
	 * @param seed
	 * @return
	 */
	public static Stream<Long> createRunfomStream(long a, int c, long m, long seed) {
		return Stream.iterate(seed, n -> ((a * n) + c) % m);
	}

}
