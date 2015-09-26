package ch05.ex05_02;

import java.time.LocalDate;

import org.junit.Test;

public class LocalDateUseSample {

	@Test
	public void test() {
		LocalDate localDate = LocalDate.of(2000, 2, 29).plusYears(1);
		System.out.println(localDate);
		// 2001-02-28
	}

	@Test
	public void test2() {
		LocalDate localDate = LocalDate.of(2000, 2, 29).plusYears(4);
		System.out.println(localDate);
		// 2004-02-29
	}

	@Test
	public void test3() {
		LocalDate localDate = LocalDate.of(2000, 2, 29).plusYears(1).plusYears(1).plusYears(1).plusYears(1);
		System.out.println(localDate);
		// 2004-02-28
	}

}
