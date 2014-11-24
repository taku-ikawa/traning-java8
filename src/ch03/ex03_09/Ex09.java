package ch03.ex03_09;

import java.lang.reflect.Field;
import java.util.Comparator;

public class Ex09 {

	public static Comparator<Object> lexicographicComparator(String... fieldNames) {
		return (obj1, obj2) -> {

			Class<? extends Object> clazz1 = obj1.getClass();
			Class<? extends Object> clazz2 = obj2.getClass();

			for(String fieldName: fieldNames) {
				try {
					Field f1 = clazz1.getDeclaredField(fieldName);
					f1.setAccessible(true);
					Object value1 = f1.get(obj1);
					Field f2 = clazz2.getDeclaredField(fieldName);
					f2.setAccessible(true);
					Object value2 = f2.get(obj2);

					if(value1.equals(value2)) {
						return 0;
					}
				} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
			}
			return -1;
		};
	}
}
