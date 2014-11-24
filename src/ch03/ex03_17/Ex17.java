package ch03.ex03_17;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class Ex17 {

	//Junitで実行するとなぜかうまくいかない

	public static void main(String[] args) {
		doInParallelAsync(
				() -> {
					for(int i = 0; i < 3; i++) {
						try {
							Thread.sleep(1000);
						} catch (Exception e) {
							e.printStackTrace();
						}
						System.out.println(i);
					}
					throw new RuntimeException();
				},
				() -> {
					for(int i = 100; i < 103; i++) {
						try {
							Thread.sleep(1000);
						} catch (Exception e) {
							e.printStackTrace();
						}
						System.out.println(i);
					}
				},
				(t) -> {
					t.printStackTrace();
				});
	}

	public static void doInParallelAsync(Runnable first, Runnable second, Consumer<Throwable> handler) {
		Thread t = new Thread() {
			public void run() {
				try {
					ExecutorService pool = Executors.newCachedThreadPool();
					Future future1 = pool.submit(first);
					Future future2 = pool.submit(second);
					future1.get();
					future2.get();
					pool.shutdown();
					pool.awaitTermination(1, TimeUnit.HOURS);
				}catch (Throwable th) {
					System.out.println("例外を処理する");
					handler.accept(th);
				}
			}
		};
		t.start();
	}

}
