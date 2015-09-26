package ch06.ex06_11;

import java.util.concurrent.CompletableFuture;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Repeter {

	public static <T> CompletableFuture<T> repeat(Supplier<T> action, Predicate<T> until) {
		return null;
	}
}
