package ch05.ex05_05;

import java.time.LocalDate;

import org.junit.Test;

public class PeriodPrinterText {

	@Test
	public void test() {
		PeriodPrinter.printPeriod(LocalDate.of(1982, 9, 17));
	}

}
