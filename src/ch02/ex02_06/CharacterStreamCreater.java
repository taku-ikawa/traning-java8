package ch02.ex02_06;

import java.util.stream.Stream;

public class CharacterStreamCreater {

	/**
	 * 指定されたStringをStream<Character>に変換する
	 * @param s
	 * @return
	 */
	public static Stream<Character> characterStream(String s) {
		return Stream.iterate(0, n -> n+1).limit(s.length()).map(s::charAt);
	}

}
