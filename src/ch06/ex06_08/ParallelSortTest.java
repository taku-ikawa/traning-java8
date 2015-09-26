package ch06.ex06_08;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

// 配列数210000あたりからparallelSortのほうが速くなってきた

public class ParallelSortTest {

	private static final int ARRAY_SIZE = 210000; // テキストから読み込む単語の総数(=配列max：644000

	public static void main(String[] args) throws IOException {
		sort();
		parallelSort();

	}

	public static void parallelSort() throws IOException {
		String contents = new String(Files.readAllBytes(Paths.get("alice_big.txt")), StandardCharsets.UTF_8);
		String[] aliceWords = contents.split("[\\P{L}]+");
		String[]words = new String[ARRAY_SIZE];
		for(int i = 0; i < ARRAY_SIZE; i++) {
			words[i] = aliceWords[i];
		}

		long start = System.currentTimeMillis();
		Arrays.parallelSort(words);
		long stop = System.currentTimeMillis();
		System.out.println("parallelSort:time:"+(stop-start));
	}

	public static void sort() throws IOException {
		String contents = new String(Files.readAllBytes(Paths.get("alice_big.txt")), StandardCharsets.UTF_8);
		String[] aliceWords = contents.split("[\\P{L}]+");
		String[]words = new String[ARRAY_SIZE];
		for(int i = 0; i < ARRAY_SIZE; i++) {
			words[i] = aliceWords[i];
		}

		System.out.println(words.length);
		long start = System.currentTimeMillis();
		Arrays.sort(words);
		long stop = System.currentTimeMillis();
		System.out.println("sort:time:"+(stop-start));
	}

}
