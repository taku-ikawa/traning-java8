package ch03.ex03_02;

import java.util.concurrent.locks.ReentrantLock;

public class Ex02 {

	public void withLock(ReentrantLock lock, Runnable runnable) {
		lock.lock();
		try {
			runnable.run();
		} finally {
			lock.unlock();
		}
	}

}
