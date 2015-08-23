package ch03.ex03_02;

import java.util.Objects;
import java.util.concurrent.locks.ReentrantLock;

public class Locker {

	/**
	 * ReentrantLockでロックしてRunnableを実行します
	 *
	 * @param lock
	 * @param runnable
	 * @throws NullPointerException 各引数がnullのケース
	 */
	public void withLock(ReentrantLock lock, Runnable runnable) {
		Objects.requireNonNull(lock, "level is null");
		Objects.requireNonNull(runnable, "level is null");

		lock.lock();
		try {
			runnable.run();
			System.out.println("finish");
		} finally {
			System.out.println("unlock");
			lock.unlock();
		}
	}

}
