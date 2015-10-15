package ch02.ex02_02;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class FilterTest {

	public static void main(String[] args) throws IOException {
		String contents = new String(Files.readAllBytes(Paths.get("alice.txt")), StandardCharsets.UTF_8);
		List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

		words.stream().filter(w -> {
			System.out.println("called filter");
			return w.length() > 12;
		}).limit(5).forEach(System.out::println);


		System.out.println(new java.math.BigInteger("1234567890987654321"));

		BigInteger b1 = new BigInteger("8");
		System.out.println(b1);
		System.out.println(b1.mod(new BigInteger("3")));	
		
		
	}


}
