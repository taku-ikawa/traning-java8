package ch01.ex01_09;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Ex09 {

	public static void main(String[] args) {
		Collection2<String> list = new ArrayListEx<String>();
		list.add("Peter");
		list.add("Paul");
		list.add("Mary");

		Consumer<String> action = System.out::println;
		Predicate<String> filter = str -> str.startsWith("P");

		list.forEachIf(action, filter);
	}

	public static class ArrayListEx<T> extends ArrayList<T> implements Collection2<T> {}

	// Q：どのような場面でforEachIfメソッドを活用できるか？
	// A：特定の条件を満たす要素に対して処理を行いたいケース。

}
