package ch09.ex06;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class ExFiles {

	public static void main(String[] args) {
		try {
			List<String> lines = Files.readAllLines(Paths
					.get("alice.txt"));

			Collections.sort(lines);
			Collections.reverse(lines);

			Files.write(Paths.get("reverse_lins_alice.txt"),
					lines);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
