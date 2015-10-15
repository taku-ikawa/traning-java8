package ch06.ex06_10;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

	private static final String REGEX = "<a href=\"([^\"]+)\">";

	public static List<URL> getLinks(String page) {
		List<URL> list = new ArrayList<URL>();
		List<String> lines = Arrays.asList(page.split(System
				.getProperty("line.separator"))); // 行単位に分割
		StringBuffer stringBuffer = new StringBuffer();
		Pattern pattern = Pattern.compile(REGEX, Pattern.CASE_INSENSITIVE);
		for (String line : lines) {
			Matcher matcher = pattern.matcher(line);
			while (matcher.find()) {
				try {
					list.add(new URL(matcher.group(1)));
				} catch (MalformedURLException e) {
					System.out.println("catch MalformedURLException. srt:"
							+ matcher.group(1));
				}
			}
		}
		return list;
	}

}
