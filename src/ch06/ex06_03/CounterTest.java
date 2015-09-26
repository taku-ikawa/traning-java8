package ch06.ex06_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

//LongAdderのほうが処理が早い

public class CounterTest {

	private static final int THREAD_COUNT = 1000;
	private static final int COUNTER_COUNT = 10000;

	public static void main(String[] args) {
		atomicLongTest();
		longAdderTest();
	}

	public static void atomicLongTest() {
		AtomicLong atomicLong = new AtomicLong(0);
		long start = System.currentTimeMillis();
		try {
			ExecutorService pool = Executors.newCachedThreadPool();
			for(int i = 0; i < THREAD_COUNT; i++) {
				pool.submit(() -> {
					for(int j = 0; j < COUNTER_COUNT; j++) {
						atomicLong.incrementAndGet();
					}
				});
			}
			pool.shutdown();
			pool.awaitTermination(1, TimeUnit.HOURS);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(atomicLong);
		long stop = System.currentTimeMillis();
		System.out.println("AtomicLong:time:"+(stop-start));
	}

	public static void longAdderTest() {
		LongAdder longAdder = new LongAdder();
		long start = System.currentTimeMillis();
		try {
			ExecutorService pool = Executors.newCachedThreadPool();
			for(int i = 0; i < THREAD_COUNT; i++) {
				pool.submit(() -> {
					for(int j = 0; j < COUNTER_COUNT; j++) {
						longAdder.increment();
					}
				});
			}
			pool.shutdown();
			pool.awaitTermination(1, TimeUnit.HOURS);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(longAdder);
		long stop = System.currentTimeMillis();
		System.out.println("LongAdder:time:"+(stop-start));
	}

}
