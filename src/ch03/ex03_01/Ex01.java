package ch03.ex03_01;

import java.util.function.BooleanSupplier;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ex01 {

	public <T> void logIf(Level level, BooleanSupplier booleanSupplier, Supplier<String> message) {
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
