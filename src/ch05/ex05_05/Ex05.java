package ch05.ex05_05;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Ex05 {
	
	public static void printPeriod(LocalDate localDate) {
		long days = localDate.until(LocalDate.now(), ChronoUnit.DAYS);
		System.out.println(days);
	}

}
