package ch02.ex02_07;

import java.util.stream.Stream;

public class Ex07 {

	public static void main(String[] args) {
		isFinite(Stream.generate(Math::random));
	}

	public static <T> boolean isFinite(Stream<T> stream) {
		System.out.println(stream.count());
		// 処理が終了しない...
		return true;
	}

	// 無限順次ストリームかどうかを判定する方法はわかりませんでした

}
