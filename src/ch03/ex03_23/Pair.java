package ch03.ex03_23;

import java.util.function.Function;

public class Pair<T> {

	T t1;
	T t2;

	public Pair(T t1, T t2) {
		this.t1 = t1;
		this.t2 = t2;
	}

	public <T, R> Pair<T> map(Function<T, R> f) {
		return new Pair(f.apply((T) this.t1), f.apply((T) this.t2));
	}

	public T getT1() {
		return t1;
	}

	public T getT2() {
		return t2;
	}


}
