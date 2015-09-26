package ch06.ex06_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class LinkSearcher {
	
	public static void main(String[] args) throws IOException {
		
		URL url = new URL("http://www.debian.org/");
		
		CompletableFuture<String> contents = readPage(url);
		
		ForkJoinPool.commonPool().awaitQuiescence(10, TimeUnit.SECONDS);
	}
	
	private static CompletableFuture<String> readPage(URL url) throws IOException {
		System.setProperty("proxySet", "true");
		//System.setProperty("proxyHost", "192.168.1.33");
		//System.setProperty("proxyPort", "8080");
		System.setProperty("http.proxyHost", "proxy.ricoh.co.jp");
        System.setProperty("http.proxyPort", "8080");
        System.setProperty("https.proxyHost", "proxy.ricoh.co.jp");
        System.setProperty("https.prozyPort", "8080");
        Authenticator.setDefault(new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("p000480075", "meiren18".toCharArray());
            }
        });
		
		HttpURLConnection urlconn = (HttpURLConnection)url.openConnection();
		urlconn.setRequestMethod("GET");
		urlconn.setInstanceFollowRedirects(false);
		urlconn.setRequestProperty("Accept-Language", "ja;q=0.7,en;q=0.3");

		urlconn.connect();

		Map headers = urlconn.getHeaderFields();
		Iterator it = headers.keySet().iterator();
		System.out.println("レスポンスヘッダ:");
		while (it.hasNext()){
		    String key= (String)it.next();
		    System.out.println("  " + key + ": " + headers.get(key));
		}

		System.out.println("レスポンスコード[" + urlconn.getResponseCode() + "] " +
		                   "レスポンスメッセージ[" + urlconn.getResponseMessage() + "]");
		System.out.println("\n---- ボディ ----");

		BufferedReader reader =
		    new BufferedReader(new InputStreamReader(urlconn.getInputStream()));

		while (true){
		    String line = reader.readLine();
		    if ( line == null ){
		        break;
		    }
		    System.out.println(line);
		}

		reader.close();
		urlconn.disconnect();

		
		return null;
	}

}
