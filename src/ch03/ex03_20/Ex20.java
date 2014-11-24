package ch03.ex03_20;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Ex20 {

	public static <T, U> List<U> map(List<T> m, Function<T, U> f) {
		List<U> u = new ArrayList<U>();
		for(T t : m) {
			u.add(f.apply(t));
		}
		return u;
	}

}
