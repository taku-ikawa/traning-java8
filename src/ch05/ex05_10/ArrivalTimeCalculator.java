package ch05.ex05_10;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Objects;

public class ArrivalTimeCalculator {

	/**
	 * 出発地のタイムゾーン、到着地のタイムゾーン、出発時刻、飛行時間を入力することで、到着時刻を出力します。
	 * @param depatureZoneId
	 * @param arrivalZoneId
	 * @param depatureTime
	 * @param flyghtTimeDuration
	 * @return
	 * @throws NullPointerException 引数がnullのケース
	 */
	LocalDateTime getArrivalTime(ZoneId depatureZoneId, ZoneId arrivalZoneId, LocalDateTime depatureTime, Duration flyghtTimeDuration) {
		Objects.requireNonNull(depatureZoneId, "depatureZoneId is null");
		Objects.requireNonNull(arrivalZoneId, "arrivalZoneId is null");
		Objects.requireNonNull(depatureTime, "depatureTime is null");
		Objects.requireNonNull(flyghtTimeDuration, "flyghtTimeDuration is null");

		// 到着時刻
		LocalDateTime arrivalTime = depatureTime.plus(flyghtTimeDuration);

		// タイムゾーンの差異
		int depatureDif = depatureTime.atZone(depatureZoneId).getOffset().getTotalSeconds();
		int arrivalDif = depatureTime.atZone(arrivalZoneId).getOffset().getTotalSeconds();
		int diffSeconds = arrivalDif - depatureDif;

		return arrivalTime.plusSeconds(diffSeconds);
	}

}
