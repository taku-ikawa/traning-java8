package ch03.ex03_16;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UncheckedIOException;

import org.junit.Test;

public class Ex16Test {

	@Test
	public void test1() {
		Ex16.doInOrderAsync(
				() -> {
					 FileInputStream inputStream;
					try {
						inputStream = new FileInputStream(new File("furano.jpg"));
					} catch (IOException e) {
						throw new UncheckedIOException(e);
					}
					 return inputStream;
				},
				(inputStream, throwable) -> {
					if(inputStream != null) {
						System.out.println("ストリームを処理する1"
								+ "");
					}
					if(throwable != null) {
						System.out.println("例外を処理する1");
						throwable.printStackTrace();
						fail();

					}
				});
	}

	@Test
	public void test2() {
		Ex16.doInOrderAsync(
				() -> {
					 FileInputStream inputStream;
					try {
						inputStream = new FileInputStream(new File("non-existence.txt"));
					} catch (IOException e) {
						throw new UncheckedIOException(e);
					}
					 return inputStream;
				},
				(inputStream, throwable) -> {
					if(inputStream != null) {
						System.out.println("ストリームを処理する2");
						fail();
					}
					if(throwable != null) {
						System.out.println("例外を処理する2");
					}
				});
	}

}
