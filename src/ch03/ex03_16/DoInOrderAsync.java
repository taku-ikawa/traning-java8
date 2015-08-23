package ch03.ex03_16;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class DoInOrderAsync {

	public static <T> void doInOrderAsync(Supplier<T> first, BiConsumer<T, Throwable> second) {
		Thread t = new Thread() {
			public void run() {
				T t = null;
				try {
					t = first.get();
				} catch (Throwable throwable) {
					second.accept(null, throwable);
				} finally {
					second.accept(t, null);
				}
			}
		};
		t.start();
	}

}
