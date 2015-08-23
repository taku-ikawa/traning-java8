package ch03.ex03_07;

import java.util.Comparator;

public class MyComparatorCreator {

	/**
	 * @param order true:正順 false:逆順
	 * @param caseSensitive true:大文字小文字を区別する false:区別しない
	 * @param excludeBlank true:空白を除外する false:空白を除外しない
	 * @return
	 */
	public static Comparator<String> createComparator(boolean order, boolean caseSensitive, boolean excludeBlank) {
		return (s1, s2) -> {
			if(excludeBlank) {
				s1 = s1.trim();
				s2 = s2.trim();
			}
			if(!order) {
				String tmp;
				tmp = s1;
				s1 = s2;
				s2 = tmp;
			}
			if(caseSensitive) {
				return s1.compareTo(s2);
			}else {
				return s1.compareToIgnoreCase(s2);
			}
		};
	}

}
