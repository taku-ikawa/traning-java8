package ch08.ex16;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Capcher {

	public static void main(String[] args) {
		String regex = "(?<city>[\\p{L} ]+),\\s*(?<state>[A-Z]{2})\\s+(?<zipcode>[0-9]{5}($|\\s|-[0-9]{4}($|\\s)))";
		try (Stream<String> lineStream = Files.lines(Paths.get("address.txt"));) {
			Stream<String> grepLineStream = lineStream.filter(Pattern.compile(
					regex).asPredicate());
			grepLineStream.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
