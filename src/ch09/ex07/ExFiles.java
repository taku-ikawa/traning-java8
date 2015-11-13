package ch09.ex07;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ExFiles {

	public static void main(String[] args) {
		try {
			URL url = new URL("http://www.ricoh.co.jp");
			InputStream in = url.openStream();

			Files.copy(in, Paths.get("url.html"));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
