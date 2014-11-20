package ch03.ex03_03;

import java.util.function.BooleanSupplier;

public class Ex03 {

	public void myAssert(BooleanSupplier assertTarget) {
		if(!assertTarget.getAsBoolean()) {
			throw new AssertionError();
		}
	}

}
