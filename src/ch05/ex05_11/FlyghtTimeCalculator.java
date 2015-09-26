package ch05.ex05_11;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.Objects;

public class FlyghtTimeCalculator {

	/**
	 * 飛行時間を計算します
	 * @param depatureTime
	 * @param arrivalTime
	 * @return
	 */
	public Duration getFlyghtTimeDuration(ZonedDateTime depatureTime, ZonedDateTime arrivalTime) {
		Objects.requireNonNull(depatureTime, "depatureTime is null");
		Objects.requireNonNull(arrivalTime, "arrivalTime is null");
		return Duration.between(depatureTime.toInstant(), arrivalTime.toInstant());
	}

}
