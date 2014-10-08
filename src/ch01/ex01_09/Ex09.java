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

		Consumer<String> consumer = System.out::println;
		Predicate<String> predicate = str -> str.startsWith("P");

		list.forEachIf(consumer, predicate);
	}

	public static class ArrayListEx<T> extends ArrayList<T> implements Collection2<T> {}

}
