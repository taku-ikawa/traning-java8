package ch05.ex05_08;

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
	 * サポートされるすべてのタイムゾーンと指定された時刻インスタントとのオフセットのマップを返します
	 * @param localDateTime
	 * @return
	 * @throws NullPointerException localDateTimeがnullのケース
	 */
	public static Map<String, ZoneOffset> getTimeZoneOffsetMap(LocalDateTime localDateTime) {
		Objects.requireNonNull(localDateTime, "localDateTime is null");
		Set<String> ids = ZoneId.getAvailableZoneIds();
		Stream<String> idsStream = ids.stream();
		Map<String, ZoneOffset> offsetMap = idsStream.collect(
				Collectors.toMap(
						s -> s,
						s -> localDateTime.atZone(ZoneId.of(s)).getOffset()));
		return offsetMap;
	}

}
