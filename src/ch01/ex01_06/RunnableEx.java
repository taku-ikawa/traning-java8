package ch01.ex01_06;

public interface RunnableEx {

	public static Runnable uncheck(RunnableEx runner){
		return () -> {
			try {
				runner.run();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
	}

	public void run() throws InterruptedException;

}
