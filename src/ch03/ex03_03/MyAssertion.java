package ch03.ex03_03;

import java.util.Objects;
import java.util.function.BooleanSupplier;

public class MyAssertion {

	/**
	 * アサーションします
	 *
	 * @param assertTarget
	 * @throws NullPointerException 各引数がnullのケース
	 */
	public void myAssert(BooleanSupplier assertTarget) {
		Objects.requireNonNull(assertTarget, "level is null");

		if(!assertTarget.getAsBoolean()) {
			throw new AssertionError();
		}
	}

}
