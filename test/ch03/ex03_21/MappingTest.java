package ch03.ex03_21;

import static org.junit.Assert.*;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Test;

public class MappingTest {

	@Test
	public void test() {
		
		ExecutorService pool = Executors.newCachedThreadPool();
		Future<Integer> fi = pool.submit(() -> {
			return new Integer(1);
		});
		
		Future<String> fs = Mapping.map(fi, (Integer i) -> {
			return i.toString();
		});
		
		try {
			assertEquals("1", fs.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}

}
