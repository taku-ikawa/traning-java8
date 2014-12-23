package ch05.ex05_01;

import java.time.LocalDate;
import java.time.Period;


public class Ex01 {

	public static void main(String[] args) {
		//LocalDate programmersDay = LocalDate.of(2014, 1, 1).plusDays(255);
		LocalDate programmersDay = LocalDate.of(2014, 1, 1).plus(Period.ofDays(255));
		System.out.println(programmersDay);
	}

}
