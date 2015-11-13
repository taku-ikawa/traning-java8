package ch08.ex07;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PeopleSort {

	public static void sortNullsFirstNaturalOrder(List<People> peopleList) {
		Collections.sort(
				peopleList,
				Comparator.comparing(People::getMiddleName,
						Comparator.nullsFirst(Comparator.naturalOrder())));
	}

	public static void sortNullsFirstReversOrder(List<People> peopleList) {
		Collections.sort(
				peopleList,
				Comparator.comparing(People::getMiddleName,
						Comparator.nullsFirst(Comparator.reverseOrder())));
	}

}
