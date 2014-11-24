package ch02.ex02_11;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Ex11 {

	public static <T> ArrayList<T> mergerrayList(ArrayList<T>... list) {

		Stream<ArrayList<T>> stream = Stream.of(list);
		return stream.reduce(
				new ArrayList<T>(),
				(x, y) -> {x.addAll(y); return x;},
				(total1, total2) -> {total1.addAll(total2); return total1;}
				);
	}


}
