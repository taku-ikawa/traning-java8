package ch06.ex06_01;

import org.junit.Test;

public class Ex01Test {

	@Test
	public void test() {
		
		for(int i = 0; i < 10; i++) {
			
			final int strLength = i;
			new Thread(() -> {
				
				try {
					Thread.sleep(800*strLength); // 0.8秒おきに設定する
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				StringBuilder sb = new StringBuilder();
				for(int j = 0; j < strLength; j++) {
					sb.append("test");
				}
				Ex01.setStr(sb.toString());
			}).start();
		}
		
		for(int i = 0; i < 10; i++) {
			
			try {
				Thread.sleep(1000); // 1秒おきに確認する
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println(Ex01.getStr());
			
		}
	}

}
