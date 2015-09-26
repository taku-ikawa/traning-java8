package ch05.ex05_04;

import org.junit.Test;

public class CalenderPrinterTest {

	@Test
	public void test() {
		String[] args = {"3", "2013"};
		CalenderPrinter.main(args);
	}
	
	@Test
	public void test2() {
		String[] args = {"8", "2015"};
		CalenderPrinter.main(args);
	}

}
