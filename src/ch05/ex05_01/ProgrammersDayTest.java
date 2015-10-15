package ch05.ex05_01;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class ProgrammersDayTest {

	@Test
	public void test1() {
		LocalDate localDate = new ProgrammersDay().calculateProgrammersDay(2015);
		assertEquals(9, localDate.getMonth().getValue());
		assertEquals(13, localDate.getDayOfMonth());
	}

	@Test
	public void test2() {
		LocalDate localDate = new ProgrammersDay().calculateProgrammersDay2(2015);
		assertEquals(9, localDate.getMonth().getValue());
		assertEquals(13, localDate.getDayOfMonth());
	}

}
