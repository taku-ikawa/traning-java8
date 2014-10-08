package ch01.ex01_07;

import static ch01.ex01_06.RunnableEx.*;

public class AndThen {

	public static void main(String[] args) {
		Runnable r = andThen(
			uncheck(() -> {
				System.out.println("runner1");
				Thread.sleep(1000);
			}),
			uncheck(() -> {
				System.out.println("runner2");
				Thread.sleep(1000);
			})
		);
		new Thread(r).start();
	}

	public static Runnable andThen(Runnable runner1, Runnable runner2) {
		return () -> {
			runner1.run();
			runner2.run();
		};
	}

}
