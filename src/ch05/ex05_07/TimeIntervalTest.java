package ch05.ex05_07;

import static org.junit.Assert.*;

import java.time.LocalTime;

import org.junit.Test;

public class TimeIntervalTest {

	@Test
	public void test1() {
		TimeInterval timeInterval1 = new TimeInterval();
		timeInterval1.setStartLocalTime(LocalTime.of(1, 0));
		timeInterval1.setEndLocalTime(LocalTime.of(3, 0));

		TimeInterval timeInterval2 = new TimeInterval();
		timeInterval2.setStartLocalTime(LocalTime.of(2, 0));
		timeInterval2.setEndLocalTime(LocalTime.of(4, 0));

		assertTrue(timeInterval1.overlap(timeInterval2));
	}
	
	@Test
	public void test2() {
		TimeInterval timeInterval1 = new TimeInterval();
		timeInterval1.setStartLocalTime(LocalTime.of(1, 0));
		timeInterval1.setEndLocalTime(LocalTime.of(2, 0));

		TimeInterval timeInterval2 = new TimeInterval();
		timeInterval2.setStartLocalTime(LocalTime.of(3, 0));
		timeInterval2.setEndLocalTime(LocalTime.of(4, 0));

		assertFalse(timeInterval1.overlap(timeInterval2));
	}
	
	@Test
	public void test3() {
		TimeInterval timeInterval1 = new TimeInterval();
		timeInterval1.setStartLocalTime(LocalTime.of(2, 0));
		timeInterval1.setEndLocalTime(LocalTime.of(4, 0));

		TimeInterval timeInterval2 = new TimeInterval();
		timeInterval2.setStartLocalTime(LocalTime.of(1, 0));
		timeInterval2.setEndLocalTime(LocalTime.of(3, 0));

		assertTrue(timeInterval1.overlap(timeInterval2));
	}

}
