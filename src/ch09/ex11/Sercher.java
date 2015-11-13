package ch09.ex11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Sercher {

	public static void main(String[] args) {
		// ユーザーホームディレクトリ取得
		//String userHomeDir = System.getProperty("user.home");
		String userHomeDir = ".";

		// grepの正規表現がいまいち機能しなかったので、以下のようなregexに...
		String regex = "[0-9][0-9][0-9][0-9]-[0-9][0-9][0-9][0-9]-[0-9][0-9][0-9][0-9]-[0-9][0-9][0-9][0-9]";

		ProcessBuilder processBuilder = new ProcessBuilder("grep", "-r", regex, userHomeDir);

		List<String> cardNumberList = new ArrayList<String>();
		try {
			Process process = processBuilder.start();
			InputStream in = process.getInputStream();
			try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
				String line;
				while ((line = br.readLine()) != null) {
					// grepの -o オプションが使えなかったので取得しなおす
					Matcher matcher = Pattern.compile(regex).matcher(line);
					if(matcher.find()) {
						String str = matcher.group();
						cardNumberList.add(str);
					}
				}
			}
			process.waitFor();
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}

		Stream<String> cardNumberListStream = cardNumberList.stream();
		cardNumberListStream.forEach(System.out::println);
	}

}
