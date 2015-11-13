package ch08.ex10;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ReservedWordSearch {

	private static final String TRANSIENT = "transient";
	private static final String VOLATILE = "volatile";

	private static Path javaSrc = Paths.get(File.separator
			+ "Program Files" + File.separator + "Java" + File.separator
			+ "jdk1.8.0_20" + File.separator + "src");

	private static Path traningSrc = Paths.get(File.separator
			+ "Users" + File.separator + "p000480075" + File.separator
			+ "git" + File.separator + "traning-java8" + File.separator + "src");

	public static void main(String[] args) {

		try (Stream<Path> entries = Files.walk(javaSrc)) {
			entries.filter(
					path -> {
						File file = path.toFile();
						if (file.isFile() && file.canRead()
								&& file.getPath().endsWith(".java")) {
							try (Stream<String> lines = Files.lines(path)) {
								return lines.anyMatch(line -> {
									if (line.contains(TRANSIENT)
											|| line.contains(VOLATILE)) {
										return true;
									}
									return false;
								});
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
						return false;
					}).forEach(path -> {
				System.out.println(path.getFileName());
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
