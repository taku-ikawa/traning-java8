package ch03.ex03_18;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.function.Function;

import org.junit.Test;

public class FunctionUnchekerTest {

	@Test
	public void test1() {
		hoge1(FunctionUncheker.unchecked((x) -> {
			//二乗して文字列にして返す
			return String.valueOf(Math.pow((double) x, 2));
		}));
	}

	private <T, R> void hoge1(Function<T, R> f) {
		String str = (String) f.apply((T) new Double(100));
		System.out.println(str);
		assertEquals("10000.0", str);
	}

	@Test
	public void test2() {
		hoge2(FunctionUncheker.unchecked((x) -> {
			throw new IOException();
		}));
	}

	private <T, R> void hoge2(Function<T, R> f) {
		try {
			String str = (String) f.apply((T) new Double(100));
			fail();
		}catch (Throwable e) {
			System.out.println("hoge2 catch");
		}
		
	}
}
