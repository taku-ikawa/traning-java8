package ch01.ex01_09;

import java.util.Collection;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;

public interface Collection2<T> extends Collection<T>{

	public default void forEachIf(Consumer<? super T> action, Predicate<? super T> filter) {
		Objects.requireNonNull(action);
		Objects.requireNonNull(filter);

		for (T t : this) {
			if(filter.test(t)){
				action.accept(t);
			}
		}
	}

}
