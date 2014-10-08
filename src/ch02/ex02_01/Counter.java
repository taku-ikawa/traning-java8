package ch02.ex02_01;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Counter {

	public static void main(String[] args) throws IOException {
		String contents = new String(Files.readAllBytes(Paths.get("alice.txt")), StandardCharsets.UTF_8);
		List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

		Counter counter = new Counter();
		for(String w :words) {
			counter.count(w, 12);
		}
		System.out.println("count : "+ counter.getCounter());
	}

	private int counter = 0;

	public int getCounter() {
		synchronized(this) {
			return counter;
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
				if(word.length() > length) {
					synchronized(this) {
						counter++;
					}
				}
			}
		}).start();
	}

}
