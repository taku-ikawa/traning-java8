package ch01.ex01_06;

import static ch01.ex01_06.RunnableEx.*;

import org.junit.Test;

public class RunnableExTest {

	@Test
	public void test_uncheck() {
		new Thread(uncheck(() -> {
			System.out.println("Zzz");
			Thread.sleep(1000);
		})).start();
	}

}
