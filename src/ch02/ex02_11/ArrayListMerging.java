package ch02.ex02_11;

import java.util.ArrayList;
import java.util.stream.Stream;

public class ArrayListMerging {

	/**
	 * Stream<ArrayList<T>>内のすべての要素を、１つのArrayList<T>へまとめる
	 * @param stream
	 * @return
	 */
	public static <T> ArrayList<T> mergeStreamArrayList(Stream<ArrayList<T>> stream) {
		return stream.reduce(
				new ArrayList<T>(),
				(x, y) -> {
					x.addAll(y);
					return x;
				}
//				(total1, total2) -> {
//					total1.addAll(total2);
//					return total1;
//				}
			);
	}

}
