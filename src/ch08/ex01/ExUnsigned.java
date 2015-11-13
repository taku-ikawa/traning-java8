package ch08.ex01;

public class ExUnsigned {

	public static void main(String[] args) {

		int a  = Integer.MAX_VALUE;
		System.out.println(a); // 2147483647
		int b  = a+1;
		System.out.println(b); // -2147483648
		System.out.println(b-1); // 2147483647
		System.out.println(Integer.toUnsignedLong(b)); // 2147483648
		System.out.println(b-1); //2147483647
		System.out.println(a*2); //-2
		System.out.println(Integer.toUnsignedLong(a*2)); // 4294967294
		System.out.println(Integer.toUnsignedLong(a*2+1)); // 4294967295
		System.out.println(Integer.toUnsignedLong(a*2+2)); // 0

		// 割り算の場合は、
		// 負の値で割り算をしてから符号変換するのと、符号変換してから割り算するのとで値が異なるため、
		// divideUnsignedで先に符号変換することを明示してやる必要がある。
		System.out.println((b)/2); // -1073741824
		System.out.println(Integer.toUnsignedLong((b)/2)); // 3221225472

		System.out.println(Integer.divideUnsigned(b, 2)); // 1073741824

		System.out.println((b+1)%2); // -1
		System.out.println(Integer.remainderUnsigned(b+1, 2)); // 1
	}

}
