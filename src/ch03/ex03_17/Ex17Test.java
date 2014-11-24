package ch03.ex03_17;

import org.junit.Test;

public class Ex17Test {

	@Test
	public void test() {
		Ex17.doInParallelAsync(
				() -> {
					for(int i = 0; i < 10; i++) {
						try {
							Thread.sleep(1000);
						} catch (Exception e) {
							e.printStackTrace();
						}
						System.out.println(i);
					}
				},
				() -> {
					for(int i = 100; i < 110; i++) {
						try {
							Thread.sleep(1000);
						} catch (Exception e) {
							e.printStackTrace();
						}
						System.out.println(i);
					}
				},
				(t) -> {
					t.printStackTrace();
				});
	}

}
