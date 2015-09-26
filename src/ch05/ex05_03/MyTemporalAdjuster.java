package ch05.ex05_03;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Objects;
import java.util.function.Predicate;

public class MyTemporalAdjuster {

	/**
	 * Predicateの定義に従って処理TemporalAdjusterを生成します
	 * @param predicate
	 * @return
	 * @throws NullPointerException predicateがnullのケース
	 */
	public TemporalAdjuster next(Predicate<LocalDate> predicate) {
		Objects.requireNonNull(predicate, "predicate is null");
		return TemporalAdjusters.ofDateAdjuster((localDate) -> {
			LocalDate result = (LocalDate) localDate;
			do {
				result = result.plusDays(1);
			}while (!predicate.test(result));
			return result;
		});
	}

}
