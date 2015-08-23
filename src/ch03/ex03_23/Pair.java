package ch03.ex03_23;

import java.util.Objects;
import java.util.function.Function;

public class Pair<T> {

	T t1;
	T t2;

	public Pair(T t1, T t2) {
		this.t1 = t1;
		this.t2 = t2;
	}

	/**
	 * PairをFunctionに従って変換したPairを返す
	 * @param f
	 * @return
	 * @throws NullPointerException 引数がnullのケース
	 */
	public Pair<T> map(Function<T, T> f) {
		Objects.requireNonNull(f, "f is null");
		return new Pair<T>(f.apply(this.t1), f.apply(this.t2));
	}

	public T getT1() {
		return t1;
	}

	public T getT2() {
		return t2;
	}


}
