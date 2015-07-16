package ch02.ex02_05;

import java.util.stream.Stream;

import org.junit.Test;

public class LinearCongruentialGeneratorTest {

	@Test
	public void test() {
		long a = 25214903917L;
		int c = 11;
		long m = (long) Math.pow(2, 48);
		long seed = 0;

		Stream<Long> stream = LinearCongruentialGenerator.createRunfomStream(a, c, m, seed);
		stream.limit(10).forEach(System.out::println);
	}

}
