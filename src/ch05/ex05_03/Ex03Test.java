package ch05.ex05_03;

import java.time.LocalDate;

import org.junit.Test;

public class Ex03Test {

	@Test
	public void test() {
		Ex03 ex03 = new Ex03();
		LocalDate today = LocalDate.now();
		today.with(ex03.next(w -> w.getDayOfWeek().getValue() < 6));
	}

}
