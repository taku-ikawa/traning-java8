package ch08.ex07;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public class PeopleSortTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void test_01() {
		People obama = new People("Barack", "Hussein", "Obama");
		People abe = new People("Shinzo", "", "Abe");

		List<People> peopleList = new ArrayList<People>();
		peopleList.add(obama);
		peopleList.add(abe);

		PeopleSort.sortNullsFirstNaturalOrder(peopleList);

		assertEquals(obama, peopleList.get(1));
	}

	@Test
	public void test_02() {
		People obama = new People("Barack", "Hussein", "Obama");
		People abe = new People("Shinzo", "", "Abe");

		List<People> peopleList = new ArrayList<People>();
		peopleList.add(obama);
		peopleList.add(abe);

		PeopleSort.sortNullsFirstReversOrder(peopleList);

		assertEquals(obama, peopleList.get(0));
	}

}