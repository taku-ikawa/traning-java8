package ch03.ex03_21;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Function;

public class Ex21 {

	public static <T, U> Future<U> map(Future<T> m, Function<T, U> f) {
		Future<U> future = new Future<U> (){
			@Override
			public boolean cancel(boolean mayInterruptIfRunning) {
				// TODO 自動生成されたメソッド・スタブ
				return false;
			}

			@Override
			public boolean isCancelled() {
				// TODO 自動生成されたメソッド・スタブ
				return false;
			}

			@Override
			public boolean isDone() {
				// TODO 自動生成されたメソッド・スタブ
				return false;
			}

			@Override
			public U get() throws InterruptedException, ExecutionException {
				// TODO 自動生成されたメソッド・スタブ
				return null;
			}

			@Override
			public U get(long timeout, TimeUnit unit)
					throws InterruptedException, ExecutionException,
					TimeoutException {
				// TODO 自動生成されたメソッド・スタブ
				return null;
			}

		};

		T t = null;;
		try {
			t = m.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		U u = f.apply(t);
		
		return new Future<U> (){
			@Override
			public boolean cancel(boolean mayInterruptIfRunning) {
				return m.cancel(mayInterruptIfRunning);
			}
			@Override
			public boolean isCancelled() {
				return m.isCancelled();
			}
			@Override
			public boolean isDone() {
				return m.isDone();
			}
			@Override
			public U get() throws InterruptedException, ExecutionException {
				return u;
			}

			@Override
			public U get(long timeout, TimeUnit unit)
					throws InterruptedException, ExecutionException,
					TimeoutException {
				m.get(timeout, unit);
				return u;
			}

		};
	}

}
