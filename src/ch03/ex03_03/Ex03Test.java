package ch03.ex03_03;

import static org.junit.Assert.*;

import org.junit.Test;

public class Ex03Test {

	@Test(expected = AssertionError.class)
	public void test1() {
		Ex03 ex03 = new Ex03();
		ex03.myAssert(() -> false);
	}

	@Test
	public void test2() {
		Ex03 ex03 = new Ex03();
		try {
			ex03.myAssert(() -> true);
		}catch (AssertionError e) {
			fail();
		}
	}

}
