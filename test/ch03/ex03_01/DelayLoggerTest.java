package ch03.ex03_01;

import java.util.logging.Level;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class DelayLoggerTest {

	@Rule
	public TestName testName = new TestName();

	@Test
	public void test1() {
		System.out.println(testName.getMethodName());
		DelayLogger delayLogger = new DelayLogger();
		int a[] = {1,2,3,4,5,6,7,8,9,10,11,12};
		int i = 10;
		delayLogger.logIf(Level.WARNING, () -> i == 10, () -> "a[10] = " + a[10]);
	}

	//抑制されるログレベルを設定
	@Test
	public void test2() {
		System.out.println(testName.getMethodName());
		DelayLogger delayLogger = new DelayLogger();
		int a[] = {1,2,3,4,5,6,7,8,9,10,11,12};
		int i = 10;
		delayLogger.logIf(Level.FINEST, () -> i == 10, () -> "a[10] = " + a[10]);
	}

	//指定した条件が不一致
	@Test
	public void test3() {
		System.out.println(testName.getMethodName());
		DelayLogger delayLogger = new DelayLogger();
		int a[] = {1,2,3,4,5,6,7,8,9,10,11,12};
		int i = 1;
		delayLogger.logIf(Level.WARNING, () -> i == 10, () -> "a[10] = " + a[10]);
	}

}
