package ch08.ex04;

import java.util.Random;

public class Seed0 {

	private static final long m = 25214903917L;
	private static final int a = 11;
	private static final double N = Math.pow(2, 48);
	private static final long v = 246154705703781L;

	public static void main(String[] args) {

		System.out.println((long)prev(prev(prev(0))) ^ m); // 164311266871034にならない...

		Random r = new Random(164311266871034L);
		System.out.println(r.nextDouble());
		System.out.println(r.nextDouble());


	}

	private static double prev(double s) {
		return (s-a)*v%N;
	}

}
