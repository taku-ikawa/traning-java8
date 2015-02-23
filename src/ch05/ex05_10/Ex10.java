package ch05.ex05_10;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class Ex10 {

	LocalDateTime getArrivalTime(ZoneId depatureZoneId, ZoneId arrivalZoneId, LocalDateTime depatureTime, Duration flyghtTimeDuration) {
		// 到着時刻
		LocalDateTime arrivalTime = depatureTime.plus(flyghtTimeDuration);

		// タイムゾーンの差異
		int depatureDif = depatureTime.atZone(depatureZoneId).getOffset().getTotalSeconds();
		int arrivalDif = depatureTime.atZone(arrivalZoneId).getOffset().getTotalSeconds();
		int diffSeconds = arrivalDif - depatureDif;

		return arrivalTime.plusSeconds(diffSeconds);
	}

}
