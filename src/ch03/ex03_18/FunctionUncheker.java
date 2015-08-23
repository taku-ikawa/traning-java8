package ch03.ex03_18;

import java.util.function.Function;

public class FunctionUncheker {

	public static <T, U> Function<T, U> unchecked(Callable2<T, U> f) {
		return (x) -> {
			try {
				return f.call(x);
			}catch (Exception e) {
				System.out.println("catch exception");
				throw new RuntimeException(e);
			}catch (Throwable t) {
				System.out.println("catch Throwable");
				throw t;
			}
		};
	}

}
