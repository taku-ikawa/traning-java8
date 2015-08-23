package ch01.ex01_06;

import java.util.Objects;

public interface RunnableEx {

	/**
	 * チェックされるすべての例外をキャッチし、それをチェックされない例外へ変える
	 * @param runner
	 * @return
	 */
	public static Runnable uncheck(RunnableEx runner){
		Objects.requireNonNull(runner);
		return () -> {
			try {
				runner.run();
			} catch (RuntimeException e) {
				throw e;
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		};
	}

	public void run() throws InterruptedException;



//	public static Runnable uncheck(Callable runner){
//		Objects.requireNonNull(runner);
//		return () -> {
//			try {
//				((RunnableEx) runner).run();
//			} catch (RuntimeException e) {
//				throw e;
//			} catch (Exception e) {
//				throw new RuntimeException(e);
//			}
//		};
//	}


}
