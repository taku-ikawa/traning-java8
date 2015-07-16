package ch02.ex02_01;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Counter {

	// 単一カウンタを更新するためにスレッドを使用したくないのは、排他制御を考慮した実装を求められるから

	public static void main(String[] args) {
		String contents = null;
		try {
			contents = new String(Files.readAllBytes(Paths.get("alice.txt")), StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

		Counter c = new Counter();
		c.count(words);


		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("count : "+ c.getCounter());
	}

	private int counter = 0;
	private static Object counterLockObject = new Object();

	private int getCounter() {
		synchronized(counterLockObject) {
			return counter;
		}
	}

	private void count(List<String> words) {
		for(int i = 0; (i+1)*100 < words.size(); i++) {
			segmentCount(words, i*100, (i+1)*100);
		}
	}

	private void segmentCount(List<String> words, int startPoint, int endPoint) {
		for(int i = startPoint; i < endPoint; i++) {
			count(words.get(i), 12);
		}
	}

	/**
	 * word の長さが length 以上であった場合にカウントアップする
	 *
	 * @param word
	 * @param length
	 */
	public void count(String word, int length) {
		new Thread(new Runnable() {
			@Override
			public void run() {

				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				if(word.length() > length) {
					synchronized(counterLockObject) {
						counter++;
					}
				}
			}
		}).start();
	}

}
