package ch05.ex05_06;

import java.time.DayOfWeek;
import java.time.LocalDate;

import org.junit.Test;

public class Ex06Text {

	@Test
	public void test() {
		for(int year = 1900; year < 2000; year++) {
			for(int month = 1; month <= 12; month++) {
				LocalDate localDate = LocalDate.of(year, month, 13);
				DayOfWeek dayOfWeek = localDate.getDayOfWeek();
				if(dayOfWeek == DayOfWeek.FRIDAY) {
					System.out.println(localDate);
				}
			}
		}
	}
}
