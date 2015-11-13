package ch08.ex13;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Repeatable(TestCases.class)
@interface TestCase {
	String params();

	String expected();
}

@Retention(RetentionPolicy.RUNTIME)
@interface TestCases {
	TestCase[] value();
}

public class AnnotationSample {

	@TestCase(params = "4", expected = "24")
	@TestCase(params = "0", expected = "1")
	@TestCase(params = "0", expected = "0")
	public static long factorial(int n) {
		int result = 1;
		if (n <= 0) {
			return result;
		}
		for (int i = 1; i <= n; i++) {
			result = result * i;
		}
		return result;
	}

}
