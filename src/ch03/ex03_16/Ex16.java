package ch03.ex03_16;

import java.io.InputStream;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class Ex16 {

	public static void doInOrderAsync(Supplier<InputStream> first, BiConsumer<InputStream, Throwable> second) {
		Thread t = new Thread() {
			public void run() {
				InputStream inputStream = null;
				try {
					inputStream = first.get();
				} catch (Throwable throwable) {
					second.accept(null, throwable);
				} finally {
					second.accept(inputStream, null);
				}
			}
		};
		t.start();
	}

}
