package ch04.ex04_05;

import java.util.function.BiFunction;
import java.util.function.Function;

import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class Observer {
	
	public static <T, R> ObservableValue<R> observe(Function<T, R> f, ObservableValue<T> t) {
		return new ObservableValue<R>() {
			@Override
			public void addListener(InvalidationListener arg0) {
				t.addListener(arg0);
			}
			@Override
			public void removeListener(InvalidationListener arg0) {
				t.removeListener(arg0);
			}
			@Override
			public void addListener(ChangeListener arg0) {
				t.addListener(arg0);
			}
			@Override
			public void removeListener(ChangeListener arg0) {
				t.removeListener(arg0);
			};
			@Override
			public R getValue() {
				T tValue = t.getValue();
				R r = f.apply(tValue);
				return r;
			}
		};
	}

	public static <T, U, R> ObservableValue<R> observe(BiFunction<T, U, R> f, ObservableValue<T> t, ObservableValue<U> u) {
		return new ObservableValue<R>() {
			@Override
			public void addListener(InvalidationListener arg0) {
				t.addListener(arg0);
			}
			@Override
			public void removeListener(InvalidationListener arg0) {
				t.removeListener(arg0);
			}
			@Override
			public void addListener(ChangeListener arg0) {
				t.addListener(arg0);
			}
			@Override
			public void removeListener(ChangeListener arg0) {
				t.removeListener(arg0);
			};
			@Override
			public R getValue() {
				T tValue = t.getValue();
				U uValue = u.getValue();
				R r = f.apply(tValue, uValue);
				return r;
			}
		};
	}


}
