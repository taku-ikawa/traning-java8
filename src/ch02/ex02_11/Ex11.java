package ch02.ex02_11;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Ex11 {

	public static void main(String[] args) {
		ArrayList<String> list1 = new ArrayList<String>();
		list1.add("a1");
		list1.add("b1");
		list1.add("c1");
		ArrayList<String> list2 = new ArrayList<String>();
		list1.add("a2");
		list1.add("b2");
		list1.add("c2");
		ArrayList<String> list3 = new ArrayList<String>();
		list1.add("a3");
		list1.add("b3");
		list1.add("c3");

		Stream<ArrayList<String>> stream = Stream.of(list1, list2, list3);

		ArrayList<String> result = stream.collect(
				ArrayList<String>::new,
				(x, y) -> x.addAll(y),
				(total1, total2) -> total1.addAll(total2)
				);

		System.out.println(result);
	}

}
