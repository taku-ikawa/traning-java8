package ch03.ex03_24;

import static org.junit.Assert.*;

import org.junit.Test;

public class PairTest {

	@Test
	public void test() {
		Pair<String> pair = new Pair<String>("aa", "bb");
		String str = pair.flatMap(
				((s) -> {
					s = s + "!";
					return s;
					}),
				((a, b) -> {
					return a + b;
					})
				);
		assertEquals("aa!bb!", str);
	}

}
