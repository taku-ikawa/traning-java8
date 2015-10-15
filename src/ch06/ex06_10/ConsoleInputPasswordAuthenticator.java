package ch06.ex06_10;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.net.Authenticator;
import java.net.PasswordAuthentication;

public class ConsoleInputPasswordAuthenticator extends Authenticator {

	public PasswordAuthentication getPasswordAuthentication() {
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
