package ch01.ex01_01;

import java.util.Arrays;

public class ThreadCheck {

	// Arrays.sort メソッド内で呼び出されるコンパレータのコードは、同一スレッドで実行されていた。

	public static void main(String[] args) {

		String[] strings = {"abcde", "xyz"};

		// mainで確認
		showThread();

		// Arrays.sort メソッド内で確認
		Arrays.sort(strings, (first, second) -> {
			showThread();
			return Integer.compare(first.length(), second.length());
		});

		// スレッドを立てて確認
		new Thread(() -> showThread()).start();
	}

	/**
	 * スレッド名を表示する
	 */
	public static void showThread() {
		System.out.println("-------------------------------------------------------");
		new Throwable().printStackTrace();
		System.out.println("Thread : "+Thread.currentThread().getName());
		System.out.println("-------------------------------------------------------");
	}

}
