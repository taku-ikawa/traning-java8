package ch08.ex12;

import java.lang.annotation.Annotation;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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

	public static void main(String[] args) {
		Method method = null;
		try {
			Class<AnnotationSample> clazz = AnnotationSample.class;
			method = clazz.getMethod("factorial", new Class[] { int.class });
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		Annotation[] annotations = method.getAnnotations();
		for (Annotation annotation : annotations) {
			if (annotation instanceof TestCases) {
				TestCases testCases = (TestCases) annotation;
				TestCase[] TestCasez = testCases.value();
				for (TestCase testCase : TestCasez) {
					try {
						System.out.println("params:" + testCase.params()
								+ ", expected:" + testCase.expected());
						Long ret = (Long) method
								.invoke(null, new Object[] { new Integer(
										testCase.params()) });
						if (ret == Long.valueOf(testCase.expected())
								.longValue()) {
							System.out.println("True");
						} else {
							System.out.println("False!! expected:"
									+ testCase.expected() + " actual:" + ret);
						}
						System.out.println("ret:" + ret);
					} catch (IllegalAccessException | IllegalArgumentException
							| InvocationTargetException e) {
						e.printStackTrace();
					}

				}
			}
		}
	}

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
