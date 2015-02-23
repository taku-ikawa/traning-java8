package ch05.ex05_11;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.junit.Test;

public class Ex11Text {

	@Test
	public void test() {
		ZonedDateTime depatureJapanTime = LocalDateTime.of(2014, 1, 1, 3, 5).atZone(ZoneId.of("Japan"));
		ZonedDateTime arrivalLosTime = LocalDateTime.of(2014, 1, 1, 3, 5).atZone(ZoneId.of("America/Los_Angeles"));

		Ex11 ex11 = new Ex11();
		Duration duration = ex11.getFlyghtTimeDuration(depatureJapanTime, arrivalLosTime);

		System.out.println(duration.getSeconds()/60/60);
	}

}
