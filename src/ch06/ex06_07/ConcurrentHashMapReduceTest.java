package ch06.ex06_07;

import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapReduceTest {

	public static void main(String[] args) {
		ConcurrentHashMap<String, Long> map = new ConcurrentHashMap<String, Long>();
		map.put("key1", 1L);
		map.put("key2", 2L);
		map.put("key3", 3L);

		long parallelismThreshold = 1;
		Entry<String, Long> entry = map.reduceEntries(parallelismThreshold, (x, y) -> {
			return (x.getValue() > y.getValue()) ? x : y;
		});

		System.out.println("maxValueKey:"+entry.getKey());
	}

}
