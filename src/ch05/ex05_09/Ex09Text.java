package ch05.ex05_09;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class Ex09Text {

	@Test
	public void test() {
		Set<String> ids = ZoneId.getAvailableZoneIds();
		Stream<String> idsStream = ids.stream();

		Stream<String> filteredIdsStream = idsStream.filter(s -> {
			ZoneOffset zoneOffset = LocalDateTime.now().atZone(ZoneId.of(s)).getOffset();
			System.out.println(zoneOffset.getTotalSeconds());
			return 3600 > zoneOffset.getTotalSeconds() && -3600 < zoneOffset.getTotalSeconds();
		});

		Map<String, ZoneOffset> offsetMap = filteredIdsStream.collect(
				Collectors.toMap(
						s -> s,
						s -> LocalDateTime.now().atZone(ZoneId.of(s)).getOffset()));
		System.out.println(offsetMap);
	}

}
