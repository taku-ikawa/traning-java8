package ch02.ex02_06;

import java.util.stream.Stream;

public class Ex06 {

	public static void main(String[] args) {
		String str = "java8kensyu";
		Stream<Character> stream = characterStream(str);
		stream.forEach(System.out::println);
	}

	public static Stream<Character> characterStream(String s) {
		return Stream.iterate(0, n -> n+1).limit(s.length()).map(c -> s.charAt(c));
	}

}
