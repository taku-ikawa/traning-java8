package ch01.ex01_07;

import static ch01.ex01_06.RunnableEx.*;

import java.util.Objects;

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

	/**
	 * 最初のRunnableを実行した後に２つめのRunnableを実行する
	 * @param runner1
	 * @param runner2
	 * @return
	 */
	public static Runnable andThen(Runnable runner1, Runnable runner2) {
		Objects.requireNonNull(runner1);
		Objects.requireNonNull(runner2);
		return () -> {
			runner1.run();
			runner2.run();
		};
	}

}
