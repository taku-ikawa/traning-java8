package ch02.ex02_08;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Zip {

	public static void main(String[] args) {
		Stream<String> stream = zip(Stream.of("a", "b"), Stream.of("x", "y", "z"));
		stream.forEach(System.out::println);
	}

	public static<T> Stream<T> zip(Stream<T> first, Stream<T> second) {
		List<T> firstList = first.collect(Collectors.toList());
		List<T> secondList = second.collect(Collectors.toList());
		List<T> resultList = new ArrayList<T>();

		int i = 0;
		while(true) {
			if(firstList.size() <= i  || secondList.size() <= i) {
				break;
			}
			resultList.add(firstList.get(i));
			resultList.add(secondList.get(i));
			i++;
		}
		return resultList.stream();
	}

}
