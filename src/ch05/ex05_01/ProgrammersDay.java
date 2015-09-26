package ch05.ex05_01;

import java.time.LocalDate;
import java.time.Period;
import java.time.Year;


public class ProgrammersDay {

	public LocalDate calculateProgrammersDay(int year) {
		if(year > Year.MAX_VALUE || year < Year.MIN_VALUE) {
			throw new IllegalArgumentException("year:"+year);
		}
		return LocalDate.of(year, 1, 1).plus(Period.ofDays(255));
	}

	// plusDaysを使用するケース
	public LocalDate calculateProgrammersDay2(int year) {
		if(year > Year.MAX_VALUE || year < Year.MIN_VALUE) {
			throw new IllegalArgumentException("year:"+year);
		}
		return LocalDate.of(year, 1, 1).plusDays(255);
	}
}
