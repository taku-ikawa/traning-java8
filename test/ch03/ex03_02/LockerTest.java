package ch03.ex03_02;

import java.util.concurrent.locks.ReentrantLock;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class LockerTest {

	@Rule
	public TestName testName = new TestName();

	@Test
	public void test() {
		System.out.println(testName.getMethodName());
		Locker locker = new Locker();

		new Thread(() -> {
			locker.withLock(new ReentrantLock(), () -> {
				loop();
			});
		}).start();

		new Thread(() -> {
			locker.withLock(new ReentrantLock(), () -> {
				System.out.println("loop2");
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
		for(int i = 0; i < 100; i++) {
			System.out.println(i);
		}
	}

}
