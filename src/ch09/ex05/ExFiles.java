package ch09.ex05;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ExFiles {

	public static void main(String[] args) {
		try {
			String contents = new String(Files.readAllBytes(Paths
					.get("alice.txt")), StandardCharsets.UTF_8);
			List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

			Collections.sort(words);
			Collections.reverse(words);

			StringBuffer sb = new StringBuffer();
			for (String word : words) {
				sb.append(word).append("\r\n");
			}
			Files.write(Paths.get("reverse_word_alice.txt"),
					sb.toString().getBytes(StandardCharsets.UTF_8));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
