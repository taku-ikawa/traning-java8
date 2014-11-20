package ch03.ex03_02;

import java.util.concurrent.locks.ReentrantLock;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class Ex02Test {

	@Rule
	public TestName testName = new TestName();

	@Test
	public void test() {
		System.out.println(testName.getMethodName());
		Ex02 ex02 = new Ex02();
		ReentrantLock lock = new ReentrantLock();

		new Thread(() -> {
			ex02.withLock(lock, () -> {
				loop();
			});
		}).start();

		new Thread(() -> {
			ex02.withLock(lock, () -> {
				loop();
			});
		}).start();
	}

	//ロックしない場合
	@Test
	public void test2() {
		System.out.println(testName.getMethodName());
		new Thread(() -> {
			loop();
		}).start();

		new Thread(() -> {
			loop();
		}).start();
	}

	private void loop() {
		for(int i = 0; i < 10; i++) {
			System.out.println(i);
		}
	}

}
