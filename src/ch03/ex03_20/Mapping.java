package ch03.ex03_20;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

// ArrayListをつくるべきでない
// mapしてcollectするのがよい

public class Mapping {

	/**
	 * ListをFunctionに従って変換したListを返す
	 * @param m
	 * @param f
	 * @return
	 * @throws NullPointerException 各引数がnullのケース
	 */
	public static <T, U> List<U> map(List<T> m, Function<T, U> f) {
		Objects.requireNonNull(m, "m is null");
		Objects.requireNonNull(f, "f is null");

		List<U> u = new ArrayList<U>();
		for(T t : m) {
			u.add(f.apply(t));
		}
		return u;
	}

}
