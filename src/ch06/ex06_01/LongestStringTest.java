package ch06.ex06_01;

import static org.junit.Assert.*;

import org.junit.Test;

public class LongestStringTest {

	@Test
	public void test() {
		LongestString ls = new LongestString();
		
		new Thread(() -> {
			ls.setString("1");
		}).start();
		new Thread(() -> {
			ls.setString("22");
		}).start();
		new Thread(() -> {
			ls.setString("333");
		}).start();
		new Thread(() -> {
			ls.setString("4444");
		}).start();
		new Thread(() -> {
			ls.setString("55555");
		}).start();
		new Thread(() -> {
			ls.setString("333");
		}).start();
		
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		assertEquals("55555", ls.getLongestString());
	}

}
