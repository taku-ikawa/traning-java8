package ch06.ex06_04;

import java.util.Objects;
import java.util.concurrent.atomic.LongAccumulator;

public class LongAccumlatorSample {

	/**
	 * 配列の要素の最大値を取得します
	 * @param array
	 * @return
	 * @throws NullPointerException
	 * @throws IllegalArgumentException
	 */
	public long getMaxValue(long[] array) {
		Objects.requireNonNull(array, "array is null");
		if(array.length == 0) {
			throw new IllegalArgumentException("array length is 0");
		}
		LongAccumulator max = new LongAccumulator((x, y) -> {
			return (x > y ? x : y);
		}, array[0]);
		for(long l : array) {
			max.accumulate(l);
		}
		return max.get();
	}

	/**
	 * 配列の要素の最小値を取得します
	 * @param array
	 * @return
	 * @throws NullPointerException
	 * @throws IllegalArgumentException
	 */
	public long getMinValue(long[] array) {
		Objects.requireNonNull(array, "array is null");
		if(array.length == 0) {
			throw new IllegalArgumentException("array length is 0");
		}
		LongAccumulator min = new LongAccumulator((x, y) -> {
			return (x < y ? x : y);
		}, array[0]);
		for(long l : array) {
			min.accumulate(l);
		}
		return min.get();
	}

}
