package ch06.ex06_09;

import static org.junit.Assert.*;

import org.junit.Test;

public class FibonacciTest {

	@Test
	public void test() {
		assertEquals(0, Fibonacci.getFibonacci(0));
		assertEquals(1, Fibonacci.getFibonacci(1));
		assertEquals(1, Fibonacci.getFibonacci(2));
		assertEquals(2, Fibonacci.getFibonacci(3));
		assertEquals(3, Fibonacci.getFibonacci(4));
		assertEquals(5, Fibonacci.getFibonacci(5));
		assertEquals(8, Fibonacci.getFibonacci(6));
		assertEquals(13, Fibonacci.getFibonacci(7));
		assertEquals(21, Fibonacci.getFibonacci(8));
	}

	
}
