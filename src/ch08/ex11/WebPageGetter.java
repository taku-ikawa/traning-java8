package ch08.ex11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class WebPageGetter {

	// 取得できませんでした。。


	public static void main(String[] args) {

		URL url = null;
		try {

			// httpsのサイトでためした場合は取得できませんでした。。
			url = new URL("http://www.ricoh.co.jp/");



		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		CompletableFuture<String> contents = readPage(url);
		contents.thenAccept(System.out::println);

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
				Authenticator
						.setDefault(new ConsoleInputPasswordAuthenticator());

				// コネクション
				HttpURLConnection urlconn = null;
				try {
					urlconn = (HttpURLConnection) url.openConnection();
					urlconn.setRequestMethod("GET");
					urlconn.setInstanceFollowRedirects(false);

					Base64.Encoder encoder = Base64.getEncoder();
					String original = "username:password";
					String encoded = encoder.encodeToString(original.getBytes(StandardCharsets.UTF_8));
					urlconn.setRequestProperty("Authorization", "Basic "+encoded);
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
