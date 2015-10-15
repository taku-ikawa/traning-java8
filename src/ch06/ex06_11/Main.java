package ch06.ex06_11;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.net.PasswordAuthentication;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class Main {

	private static final String PASSWORD = "secret";

	public static void main(String[] args) {
		Repeter.repeat(() -> {
			return getPasswordAuthentication();
		}, (passwordAuthentication) -> {
			if(PASSWORD.equals(String.copyValueOf(passwordAuthentication.getPassword()))) {
				System.out.print("認証成功");
				return true;
			}else {
				System.out.print("認証失敗");
				System.out.println();
				return false;
			}
		});
		ForkJoinPool.commonPool().awaitQuiescence(30, TimeUnit.SECONDS);
	}

	private static PasswordAuthentication getPasswordAuthentication() {
		String user = "", pass = "";
		try {
			System.out.print("ユーザー名を入力してください>");
			LineNumberReader in = new LineNumberReader(new InputStreamReader(
					System.in));
			user = in.readLine();

			System.out.print("パスワードを入力してください>");
			in = new LineNumberReader(new InputStreamReader(System.in));
			pass = in.readLine();
		} catch (IOException err) {
			System.out.println(err);
		}
		return new PasswordAuthentication(user, pass.toCharArray());
	}

}
