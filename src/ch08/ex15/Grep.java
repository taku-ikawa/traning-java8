package ch08.ex15;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Grep {

	// 第一引数：検索対象の文字列
	// 第二引数：検索対象のファイル
	public static void main(String[] args) {
		Objects.requireNonNull(args, "args is null");
		if (args.length != 2) {
			throw new IllegalArgumentException("args length is not 2");
		}
		String target = args[0];
		String fileName = args[1];

		try (Stream<String> lineStream = Files.lines(Paths.get("alice.txt"));) {
			Stream<String> grepLineStream = lineStream.filter(Pattern.compile(
					target).asPredicate());
			long count = grepLineStream.peek(System.out::println).count();
			System.out.println("-------------------------------------------------");
			System.out.println("検索語句：" + target);
			System.out.println("検索対象：" + fileName);
			System.out.println(count + "件みつかりました");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
