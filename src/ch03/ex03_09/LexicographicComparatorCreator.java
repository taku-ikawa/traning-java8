package ch03.ex03_09;

import java.lang.reflect.Field;
import java.util.Comparator;
import java.util.Objects;

public class LexicographicComparatorCreator {

	// 講義時メモ
	// このクラスがComoaratorを継承しろということ

	/**
	 * @param fieldNames
	 * @return
	 * @throws NullPointerException fieldNamesがnullのケース
	 * @throws IllegalArgumentException fieldNamesに指定した値が不正であるケース
	 */
	public static Comparator<Object> lexicographicComparator(String... fieldNames) {
		Objects.requireNonNull(fieldNames, "fieldNames is null");
		if(fieldNames.length == 0) {
			throw new IllegalArgumentException("fileNames length is 0");
		}

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

					if(!value1.equals(value2)) {
						// 2つのオブジェクトのフィールドの値が異なれば、その差を返す？
						// よくわからなかったので1を返す
						return 1;
					}
				} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
					// フィールドを特定できなければ-1を返す
					return -1;
				}
			}
			// すべてのフィールドが同じであれば0を返す
			return 0;
		};
	}
}
