package ch05.ex05_10;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;

import org.junit.Test;

public class Ex10Test {

	@Test
	public void test() {
		Ex10 ex10 = new Ex10();
		LocalDateTime d = ex10.getArrivalTime(ZoneId.of("America/Los_Angeles"), ZoneId.of("Japan"), LocalDateTime.of(2014, 1, 1, 3, 5), Duration.ofMinutes(650));
		System.out.println(d);

		LocalDateTime d2 = ex10.getArrivalTime(ZoneId.of("Japan"), ZoneId.of("America/Los_Angeles"), LocalDateTime.of(2014, 1, 1, 3, 5), Duration.ofMinutes(650));
		System.out.println(d2);

	}

}
