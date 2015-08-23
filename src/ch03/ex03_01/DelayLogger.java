package ch03.ex03_01;

import java.util.Objects;
import java.util.function.BooleanSupplier;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DelayLogger {

	/**
	 * 遅延ロギングします
	 *
	 * @param level
	 * @param booleanSupplier
	 * @param message
	 * @throws NullPointerException 各引数がnullのケース
	 */
	public <T> void logIf(Level level, BooleanSupplier booleanSupplier, Supplier<String> message) {
		Objects.requireNonNull(level, "level is null");
		Objects.requireNonNull(booleanSupplier, "booleanSupplier is null");
		Objects.requireNonNull(message, "message is null");

		final Logger logger = Logger.getLogger("SampleLogging");
		if(!logger.isLoggable(level)) {
			return;
		}
		if(!booleanSupplier.getAsBoolean()){
			return;
		}
		logger.log(level, message);
	}
}
