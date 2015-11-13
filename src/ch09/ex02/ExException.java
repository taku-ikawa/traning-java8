package ch09.ex02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ExException {

	public static void main(String[] args) {
		new ExException().scannerSampleWithoutUsingTryWithResources();
	}

	public void scannerSampleWithoutUsingTryWithResources() {
		List<Exception> eList = new ArrayList<Exception>();

		Scanner in = null;
		try {
			in = new Scanner(new File("dummyFile.txt"));
		} catch (IllegalStateException e) {
			eList.add(e);
		} catch (NoSuchElementException e) {
			eList.add(e);
		} catch (FileNotFoundException e) {
			eList.add(e);
		} finally {
			try {
				if(in != null) {
					in.close();
				}
				throw new IllegalStateException("dummyException");
			} catch (IllegalStateException e) {
				for(Exception t : eList) {
					t.addSuppressed(e); // もともとの例外へ追加
				}
			}
		}

		for(Exception e : eList) {
			System.out.println("もとの例外");
			System.out.println(e);

			System.out.println("抑制された例外");
			Throwable[] t = e.getSuppressed();
			if(t != null) {
				for(Throwable throwable : t) {
					System.out.println(throwable.getClass());
					System.out.println("Message:"+throwable.getMessage());
					StackTraceElement[] ste = throwable.getStackTrace();
					for(StackTraceElement st : ste) {
						System.out.println(st);
					}
				}
			}
		}
	}

}
