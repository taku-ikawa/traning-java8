package ch02.ex02_13;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Counter {

	/**
	 * Stream<String> stream内のmaxLengthより短い単語をすべてカウントし結果を返す
	 * @param stream
	 * @return
	 */
	public Map<Integer, Long> count(Stream<String> stream, int maxLength) {
		Map<Integer, Long> map = stream
				.parallel()
				.filter(s -> s.length() < maxLength)
				.collect(
						Collectors.groupingBy(s -> s.length(),
								Collectors.counting()));
		return map;
	}

}
