package ch06.ex06_01;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public class LongestString {

	AtomicReference<String> longestString = new AtomicReference<String>("");

	public void setString(String update) {
		Objects.requireNonNull(update, "update is null");
		longestString.updateAndGet(x -> {
			return (x.length() > update.length()) ? x : update;
		});
	}

	/**
	 * これまでセットした文字列のうち最大長の文字列を返します
	 * @return
	 */
	public String getLongestString() {
		return longestString.get();
	}

}
