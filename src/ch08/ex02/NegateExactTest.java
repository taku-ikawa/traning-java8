package ch08.ex02;

public class NegateExactTest {

	public static void main(String[] args) {
		int a = 100000;
		int b = 100000;
		int r = a * b;
		System.out.println(r);
		//int m = Math.multiplyExact(a, b);


		System.out.println(Math.negateExact(1)); // -1
		System.out.println(Math.negateExact(0)); // 0
		System.out.println(Math.negateExact(-1)); // 1

		System.out.println(Integer.MAX_VALUE); // 2147483647
		System.out.println(Math.negateExact(Integer.MAX_VALUE)); // -2147483647
		System.out.println(Integer.MIN_VALUE); // -2147483648
		System.out.println(Math.negateExact(Integer.MIN_VALUE)); // java.lang.ArithmeticException
	}

}
