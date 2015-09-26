package ch05.ex05_09;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Map;

import org.junit.Test;

public class TimeZoneOffsetTest {

	@Test
	public void test() {
		Map<String, ZoneOffset> offsetMap = TimeZoneOffset.getTimeZoneOffsetMap(LocalDateTime.now(), 3600);
		System.out.println(offsetMap);
	}

}
