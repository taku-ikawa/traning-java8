package ch08.ex14;

import java.util.Objects;

// requireNonNullメソッドにより、もっと役立つエラーメッセージとなる方法を示しなさい
// 問題の意図がわかりませんでした。遅延によるメリットが示せればよい？？？

public class ExReauireNonNull {

	public static void main(String[] args) {
		new ExReauireNonNull().process(null);
	}

	private String directions;
	private String goal = "goal" ;

	public void process(String directions) {
		this.directions = Objects.requireNonNull(directions,
				() -> "directions for " + this.goal + " must not be null");
	}

}
