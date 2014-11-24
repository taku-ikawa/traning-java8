package ch03.ex03_24;

import static org.junit.Assert.*;

import org.junit.Test;

public class Ex24Test {

	@Test
	public void test() {
		Pair pair = new Pair("aa", "bb");
		Pair pair2 = pair.map((s) -> {
			s = s + "!";
			return s;
		});
		Pair pair3 = pair.flatMap((s) -> {
			s = s + "?";
			return s;
		}, pair2);
		assertEquals("aa!?", pair3.getT1());
		assertEquals("bb!?", pair3.getT2());
	}

}
