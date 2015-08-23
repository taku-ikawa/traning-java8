package ch03.ex03_23;

import static org.junit.Assert.*;

import org.junit.Test;

public class PairTest {

	@Test
	public void test() {
		Pair<String> pair = new Pair<String>("aa", "bb");
		Pair<String> pair2 = pair.map((s) -> {
			s = s + "!";
			return s;
		});
		assertEquals("aa!", pair2.getT1());
		assertEquals("bb!", pair2.getT2());
	}

}
