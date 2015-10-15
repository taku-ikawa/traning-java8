package ch06.ex06_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

import ch06.ex06_11.ConsoleInputPasswordAuthenticator;

public class LinkSearcher {

	public static void main(String[] args) {

		URL url = null;
		try {
			url = new URL("http://www.google.org/");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		CompletableFuture<String> contents = readPage(url);
		CompletableFuture<List<URL>> links = contents.thenApply(Parser::getLinks);
		links.thenAccept((l) -> {
			System.out.println("--- URL List ---");
			System.out.println(l);
		});

		ForkJoinPool.commonPool().awaitQuiescence(20, TimeUnit.SECONDS);

	}

	private static CompletableFuture<String> readPage(URL url) {
		return CompletableFuture.supplyAsync(() -> {
				// プロキシ
				System.setProperty("proxySet", "true");
				System.setProperty("http.proxyHost", "proxy.ricoh.co.jp");
				System.setProperty("http.proxyPort", "8080");
				System.setProperty("https.proxyHost", "proxy.ricoh.co.jp");
				System.setProperty("https.prozyPort", "8080");

				Authenticator.setDefault(new ConsoleInputPasswordAuthenticator());

				// コネクション
				HttpURLConnection urlconn = null;
				try {
					urlconn = (HttpURLConnection) url.openConnection();
					urlconn.setRequestMethod("GET");
					urlconn.setInstanceFollowRedirects(false);
					urlconn.setRequestProperty("Accept-Language",
							"ja;q=0.7,en;q=0.3");
					urlconn.connect();
				} catch (IOException e) {
					e.printStackTrace();
				}

				// データ読み込み
				StringBuffer stringBuffer = new StringBuffer();
				try {
					BufferedReader reader = new BufferedReader(
							new InputStreamReader(urlconn.getInputStream()));
					while (true) {
						String line = reader.readLine();
						if (line == null) {
							break;
						}
						stringBuffer.append(line);
						stringBuffer.append(System
								.getProperty("line.separator"));
					}
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				if (urlconn != null) {
					urlconn.disconnect();
				}
				return stringBuffer.toString();
			});
	}

}
