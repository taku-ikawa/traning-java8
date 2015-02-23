package ch05.ex05_08;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class Ex08Text {

	@Test
	public void test() {
		Set<String> ids = ZoneId.getAvailableZoneIds();
		Stream<String> idsStream = ids.stream();

//		Stream<ZoneOffset> zoneOffsetStream = idsStream.map(s -> {
//			return LocalDateTime.now().atZone(ZoneId.of(s)).getOffset();
//		});
//		zoneOffsetStream.forEach(offset -> {
//			System.out.println(offset);
//		});

		Map<String, ZoneOffset> offsetMap = idsStream.collect(
				Collectors.toMap(
						s -> s,
						s -> LocalDateTime.now().atZone(ZoneId.of(s)).getOffset()));
		System.out.println(offsetMap);
	}

}
