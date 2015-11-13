package ch08.ex05;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Counter {

	// removeifの方が速かった

	public static void main(String[] args) throws IOException {
		countByStream();
		countByRemoveIf();
	}

	private static void countByStream() throws IOException {
		String contents = new String(Files.readAllBytes(Paths.get("alice_big.txt")), StandardCharsets.UTF_8);
		List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

		long before = System.nanoTime();
		long count = words.stream().filter(w -> w.length() > 12).count();
		long after = System.nanoTime();

		System.out.println("count:"+count);
		System.out.println("countByStream");
		System.out.println("時間："+(after -before));
	}

	private static void countByRemoveIf() throws IOException {
		String contents = new String(Files.readAllBytes(Paths.get("alice_big.txt")), StandardCharsets.UTF_8);
		List<String> words = new ArrayList<String>(Arrays.asList(contents.split("[\\P{L}]+")));

		long before = System.nanoTime();
		words.removeIf((w -> {
			return w.length() < 12;
		}));
		long count = words.size();
		long after = System.nanoTime();

		System.out.println("count:"+count);
		System.out.println("countByRemoveIf");
		System.out.println("時間："+(after -before));
	}

}
