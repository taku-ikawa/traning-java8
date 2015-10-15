package ch05.ex05_03;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class MyTemporalAdjusterTest {

	@Test
	public void test() {
		// 火曜日を指定。翌日を返す
		MyTemporalAdjuster ex03 = new MyTemporalAdjuster();
		LocalDate before = LocalDate.of(2015, 8, 25);
		LocalDate result = before.with(ex03.next(w -> w.getDayOfWeek().getValue() < 6));
		assertEquals(26, result.getDayOfMonth());
	}

	@Test
	public void test2() {
		// 金曜日を指定。月曜日を返す
		MyTemporalAdjuster ex03 = new MyTemporalAdjuster();
		LocalDate before = LocalDate.of(2015, 8, 28);
		LocalDate result = before.with(ex03.next(w -> w.getDayOfWeek().getValue() < 6));
		assertEquals(31, result.getDayOfMonth());
	}

}
