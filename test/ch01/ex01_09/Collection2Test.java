package ch01.ex01_09;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Predicate;

import org.junit.Test;

public class Collection2Test {

	public static class ArrayList2<T> extends ArrayList<T> implements Collection2<T> {}

	@Test
	public void test() {
		Collection2<String> list = new ArrayList2<String>();
		list.add("Apple");
		list.add("apple");
		list.add("orange");

		Consumer<String> action = str -> System.out.println(str);
		Predicate<String> filter = str -> {
			str = str.toLowerCase();
			return str.startsWith("a");
		};

		list.forEachIf(action, filter);

		// Q：どのような場面でforEachIfメソッドを活用できるか？
		// A：特定の条件を満たす要素に対して処理を行いたいケース。
	}

}
