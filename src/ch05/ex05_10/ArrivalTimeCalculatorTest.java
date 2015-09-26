package ch05.ex05_10;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;

import org.junit.Test;

public class ArrivalTimeCalculatorTest {

	@Test
	public void test1() {
		ArrivalTimeCalculator arrivalTimeCalculator = new ArrivalTimeCalculator();
		LocalDateTime d = arrivalTimeCalculator.getArrivalTime(ZoneId.of("America/Los_Angeles"), ZoneId.of("Japan"), LocalDateTime.of(2014, 1, 1, 3, 5), Duration.ofMinutes(650));
		System.out.println(d);
	}

	@Test
	public void test2() {
		ArrivalTimeCalculator arrivalTimeCalculator = new ArrivalTimeCalculator();
		LocalDateTime d2 = arrivalTimeCalculator.getArrivalTime(ZoneId.of("Japan"), ZoneId.of("America/Los_Angeles"), LocalDateTime.of(2014, 1, 1, 3, 5), Duration.ofMinutes(650));
		System.out.println(d2);
	}

}
