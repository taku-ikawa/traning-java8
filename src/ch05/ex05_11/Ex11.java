package ch05.ex05_11;

import java.time.Duration;
import java.time.ZonedDateTime;

public class Ex11 {

	public Duration getFlyghtTimeDuration(ZonedDateTime depatureTime, ZonedDateTime arrivalTime) {
		return Duration.between(depatureTime.toInstant(), arrivalTime.toInstant());
	}

}
