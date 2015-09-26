package ch05.ex05_08;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Map;

import org.junit.Test;

public class TimeZoneOffsetTest {

	@Test
	public void test() {
		Map<String, ZoneOffset> offsetMap = TimeZoneOffset.getTimeZoneOffsetMap(LocalDateTime.now());
		System.out.println(offsetMap);
	}

}
