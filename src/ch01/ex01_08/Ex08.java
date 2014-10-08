package ch01.ex01_08;

import java.util.ArrayList;
import java.util.List;

public class Ex08 {

	public static void main(String[] args) {
		kakucho();
		jyurai();
	}

	private static void kakucho() {
		String[] names = {"Peter", "Paul", "Mary"};
		List<Runnable> runners = new ArrayList<>();
		for(String name : names) {
			runners.add(() -> System.out.println(name));
		}

		for(Runnable runner : runners) {
			new Thread(runner).start();
		}
	}

	private static void jyurai() {
		String[] names = {"Peter", "Paul", "Mary"};
		List<Runnable> runners = new ArrayList<>();

		for(int i = 0; i < names.length; i++) {
			// コンパイルエラー
			//runners.add(() -> System.out.println(names[i]));
		}

		for(Runnable runner : runners) {
			new Thread(runner).start();
		}
	}

}
