package ch01.q;

import java.util.stream.Stream;

public class Q2 {

	public static void main(String args[]) {
		Stream<Double> stream = Stream.iterate(0.0, n -> n+1).limit(1000);

		//①
		stream = stream.parallel();
		stream.forEach(System.out::println);

		//②
		//stream.forEach(System.out::println);

		//③
		//stream.forEachOrdered(System.out::println);

	}

}
