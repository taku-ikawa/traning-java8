package ch01.ex01_06;

import static ch01.ex01_06.RunnableEx.*;


public class Ex06 {

	public static void main(String[] args) {

		new Thread(uncheck(() -> {
			System.out.println("Zzz");
			Thread.sleep(1000);
		})).start();
	}

}
