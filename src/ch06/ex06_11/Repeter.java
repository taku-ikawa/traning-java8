package ch06.ex06_11;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Repeter {

	public static <T> CompletableFuture<T> repeat(Supplier<T> action, Predicate<T> until) {
		CompletableFuture<T> completableFuture = CompletableFuture.supplyAsync(action);
		completableFuture.thenAccept((t) -> {
			if(until.test(t)) {
				return;
			}
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (Exception e) {
				e.printStackTrace();
			}
			repeat(action, until);
		});
		return completableFuture;

	}
}
