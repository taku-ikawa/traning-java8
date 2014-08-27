package ch01.ex01_01;

import java.util.Arrays;

public class Ex01 {

	// 同一スレッドで実行されていた。

	public static void main(String[] args) {
		String[] strings = {"abcde", "xyz"};

		showThread();

		Arrays.sort(strings, (first, second) -> {

			showThread();

			return Integer.compare(first.length(), second.length());
		});
	}

	public static void showThread() {
		System.out.println("-------------------------------------------------------");
		new Throwable().printStackTrace();
		System.out.println("Thread : "+Thread.currentThread().getThreadGroup().getName());
		System.out.println("-------------------------------------------------------");
	}

}
