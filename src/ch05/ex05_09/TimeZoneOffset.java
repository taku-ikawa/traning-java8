package ch05.ex05_09;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TimeZoneOffset {

	/**
	 * サポートされるすべてのタイムゾーンの指定された時刻インスタントとのオフセットのうち、termで指定された時間未満のオフセットのマップを返します
	 * @param localDateTime
	 * @param term 単位は秒
	 * @return
	 * @throws NullPointerException localDateTimeがnullのケース
	 * @throws IllegalArgumentException termの値が異常のケース
	 */
	public static Map<String, ZoneOffset> getTimeZoneOffsetMap(LocalDateTime localDateTime, long term) {
		Objects.requireNonNull(localDateTime, "localDateTime is null");
		if(term < 0) {
			throw new IllegalArgumentException("term:"+term);
		}
		Set<String> ids = ZoneId.getAvailableZoneIds();
		Stream<String> idsStream = ids.stream();

		Stream<String> filteredIdsStream = idsStream.filter(s -> {
			ZoneOffset zoneOffset = LocalDateTime.now().atZone(ZoneId.of(s)).getOffset();
			return term > zoneOffset.getTotalSeconds() && -3600 < zoneOffset.getTotalSeconds();
		});

		Map<String, ZoneOffset> offsetMap = filteredIdsStream.collect(
				Collectors.toMap(
						s -> s,
						s -> LocalDateTime.now().atZone(ZoneId.of(s)).getOffset()));
		return offsetMap;
	}

}
