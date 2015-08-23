package ch03.ex03_03;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyAssertionTest {

	@Test(expected = AssertionError.class)
	public void test1() {
		MyAssertion myAssertion = new MyAssertion();
		myAssertion.myAssert(() -> false);
	}

	@Test
	public void test2() {
		MyAssertion myAssertion = new MyAssertion();
		try {
			myAssertion.myAssert(() -> true);
		}catch (AssertionError e) {
			fail();
		}
	}

}
