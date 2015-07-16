package ch02.ex02_12;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Counter {

	/**
	 * Stream<String> stream内のmaxLengthより短い単語をすべてカウントし結果を返す
	 * @param stream
	 * @return
	 */
	public AtomicInteger[] count(Stream<String> stream, int maxLength) {
		AtomicInteger[] counter = new AtomicInteger[maxLength];
		stream.parallel().forEach(s -> {
			if (s.length() < maxLength) {
				if (counter[s.length()] == null) {
					counter[s.length()] = new AtomicInteger();
				}
				counter[s.length()].getAndIncrement();
			}
		});
		return counter;
	}
}
