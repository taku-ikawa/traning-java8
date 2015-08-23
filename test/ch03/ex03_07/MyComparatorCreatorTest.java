package ch03.ex03_07;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class MyComparatorCreatorTest {


	/**
	 * @param order true:正順 false:逆順
	 * @param caseSensitive true:大文字小文字を区別する false:区別しない
	 * @param excludeBlank true:空白を除外する false:空白を除外しない
	 * @return
	 */

	@Test
	public void test1() {
		// 正順、逆順のテスト
		List<String> list = Arrays.asList("a", "b");
		Collections.sort(list, MyComparatorCreator.createComparator(true, false, false));
		System.out.println(list.toString());
		assertEquals("a", list.get(0));
	}

	@Test
	public void test2() {
		// 正順、逆順のテスト
		List<String> list = Arrays.asList("a", "b");
		Collections.sort(list, MyComparatorCreator.createComparator(false, false, false));
		System.out.println(list.toString());
		assertEquals("b", list.get(0));
	}

	@Test
	public void test3() {
		// 大文字、小文字のテスト
		List<String> list = Arrays.asList("a", "A");
		Collections.sort(list, MyComparatorCreator.createComparator(true, false, false));
		System.out.println(list.toString());
		assertEquals("a", list.get(0));
	}

	@Test
	public void test4() {
		// 大文字、小文字のテスト
		List<String> list = Arrays.asList("a", "A");
		Collections.sort(list, MyComparatorCreator.createComparator(true, true, false));
		System.out.println(list.toString());
		assertEquals("A", list.get(0));
	}

	@Test
	public void test5() {
		// 空白のテスト
		List<String> list = Arrays.asList("a", " b");
		Collections.sort(list, MyComparatorCreator.createComparator(true, false, false));
		System.out.println(list.toString());
		assertEquals(" b", list.get(0));
	}

	@Test
	public void test6() {
		// 空白のテスト
		List<String> list = Arrays.asList("a", " b");
		Collections.sort(list, MyComparatorCreator.createComparator(true, false, true));
		System.out.println(list.toString());
		assertEquals("a", list.get(0));
	}


	@Test
	public void test7() {
		// 組み合わせテスト
		List<String> list = Arrays.asList("c", "b", " B", "A");
		Collections.sort(list, MyComparatorCreator.createComparator(true, true, true));
		System.out.println(list.toString());
		assertEquals("A", list.get(0));
	}

	@Test
	public void test8() {
		// 組み合わせテスト
		List<String> list = Arrays.asList("a", "b");
		Collections.sort(list, MyComparatorCreator.createComparator(false, true, true));
		System.out.println(list.toString());
		assertEquals("b", list.get(0));
	}

	@Test
	public void test9() {
		// 組み合わせテスト
		List<String> list = Arrays.asList("b", "B");
		Collections.sort(list, MyComparatorCreator.createComparator(true, false, true));
		System.out.println(list.toString());
		assertEquals("b", list.get(0));
	}

	@Test
	public void test10() {
		// 組み合わせテスト
		List<String> list = Arrays.asList("A", " B");
		Collections.sort(list, MyComparatorCreator.createComparator(true, true, false));
		System.out.println(list.toString());
		assertEquals(" B", list.get(0));
	}

}
