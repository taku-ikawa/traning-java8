package ch06.ex06_09;

import java.util.Arrays;

public class Fibonacci {

	/**
	 * index番目のフィボナッチ数を返します
	 * @param index
	 * @return
	 * @throws IllegalArgumentException
	 */
	public static int getFibonacci(int index) {
		if(index < 0) {
			throw new IllegalArgumentException("illegal index : "+index);
		}
		if(index == 0) {
			return 0;
		}
		if(index == 1) {
			return 1;
		}

		Matrix[] matrixArray = new Matrix[index];

		Arrays.parallelSetAll(matrixArray, (i) -> {
			Matrix matrix = new Matrix();
			matrix.setComponent1_1(1);
			matrix.setComponent1_2(1);
			matrix.setComponent2_1(1);
			matrix.setComponent2_2(0);
			return matrix;
		});

		Arrays.parallelPrefix(matrixArray, (x, y) -> {
			Matrix matrix = new Matrix();
			matrix.setComponent1_1(x.getComponent1_1() * y.getComponent1_1() + x.getComponent1_2() * y.getComponent2_1());
			matrix.setComponent1_2(x.getComponent1_1() * y.getComponent1_2() + x.getComponent1_2() * y.getComponent2_2());
			matrix.setComponent2_1(x.getComponent2_1() * y.getComponent1_1() + x.getComponent2_2() * y.getComponent2_1());
			matrix.setComponent2_2(x.getComponent2_1() * y.getComponent1_2() + x.getComponent2_2() * y.getComponent2_2());
			return matrix;
		});

		return matrixArray[index-2].getComponent1_1();
	}

}
