package ch05.ex05_05;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PeriodPrinter {

	public static long printPeriod(LocalDate localDate) {
		long days = localDate.until(LocalDate.now(), ChronoUnit.DAYS);
		System.out.println(days);
		return days;
	}

}
