package ch02.ex02_03;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Ex03 {

	public static void main(String[] argws) throws IOException {
		normal();
		para();
	}
	
	private static void normal() throws IOException {
		String contents = new String(Files.readAllBytes(Paths.get("alice_big.txt")), StandardCharsets.UTF_8);
		List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
		
		long before = System.nanoTime();
		long count = words.stream().filter(w -> w.length() > 12).count();
		long after = System.nanoTime();
		
		System.out.println("count: "+count);
		System.out.println(after -before);
	}
	
	private static void para() throws IOException {
		String contents = new String(Files.readAllBytes(Paths.get("alice_big.txt")), StandardCharsets.UTF_8);
		List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
		
		long before = System.nanoTime();
		long count = words.parallelStream().filter(w -> w.length() > 12).count();
		long after = System.nanoTime();
		
		System.out.println("count: "+count);
		System.out.println(after -before);
	}

}

