package ch02.ex02_10;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Average {

	public static void main(String[] args) {

		// reduceで合計を計算した後にstreamに対してcountすると、以下のようなExceptionが発生してしまうためcountで割ることができない
		// Exception in thread "main" java.lang.IllegalStateException: stream has already been operated upon or closed

		Stream<Double> stream = Stream.iterate(0.0, n -> n+1).limit(10);
		double avg = stream.collect(Collectors.averagingDouble(i -> i));
		System.out.println(avg);
	}
}
