package ch08.ex03;

public class Gcd {

	public static void main(String[] args) {
		System.out.println("gcd1:"+gcd1(6, 9));
		System.out.println("gcd1:"+gcd1(-6, 9));
		System.out.println("gcd1:"+gcd1(-3, 4));
		System.out.println("--------------------------");
		System.out.println("gcd1:"+gcd2(6, 9));
		System.out.println("gcd2:"+gcd2(-6, 9));
		System.out.println("gcd1:"+gcd2(-3, 4));
		System.out.println("--------------------------");
		System.out.println("gcd1:"+gcd3(6, 9));
		System.out.println("gcd3:"+gcd3(-6, 9));
		System.out.println("gcd1:"+gcd3(-3, 4));
	}

	// %
	public static int gcd1(int a, int b) {
		if(a == 0) {
			return b;
		}
		return gcd1(b, rem1(a, b));
	}

	private static int rem1(int a, int b) {
		if(b == 0) {
			return (a > 0) ? a : -a;
		}
		return a%b;
	}

	// floorMode
	public static int gcd2(int a, int b) {
		if(a == 0) {
			return b;
		}
		return gcd2(b, rem2(a, b));
	}

	private static int rem2(int a, int b) {
		if(b == 0) {
			return (a > 0) ? a : -a;
		}
		return Math.floorMod(a, b);
	}

	// 数学的な(負ではない)余りを生成するrem関数
	public static int gcd3(int a, int b) {
		if(a == 0) {
			return b;
		}
		return gcd3(b, rem3(a, b));
	}

	private static int rem3(int a, int b) {
		if(b == 0) {
			return a;
		}
		a = (a > 0) ? a : -a;
		b = (b > 0) ? b : -b;
		return a%b;
	}

}
