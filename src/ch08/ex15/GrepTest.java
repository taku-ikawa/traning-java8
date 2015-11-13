package ch08.ex15;

import org.junit.BeforeClass;
import org.junit.Test;

public class GrepTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void test() {
		Grep.main(new String[]{"アリス", "alice.txt"});
	}

}
