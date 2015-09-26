package ch06.ex06_06;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// mergeの代わりにcomputeIfAbsentを使用することの利点は、
// 初期値の生成処理が初期化時に初めて行われる点。


public class WordManagement {

	public static final String PATH = "src"+File.separator+"ch06"+File.separator+"ex06_05"+File.separator;
	public static final String[] fileNames = {"a.txt", "b.txt", "c.txt"};

	public static void main(String[] args) {

		ConcurrentHashMap<String, Set<File>> wordMap = new ConcurrentHashMap<String, Set<File>>();

		try {
			ExecutorService pool = Executors.newCachedThreadPool();

			for(String fileName : fileNames) {
				File file = new File(PATH+fileName);
				pool.submit(() -> {
					String contents = null;
					try {
						contents = new String(Files.readAllBytes(Paths.get(file.getAbsolutePath())), StandardCharsets.UTF_8);
					} catch (IOException e) {
						e.printStackTrace();
						return;
					}
					List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
					for(String word : words) {
						wordMap.computeIfAbsent(word, (k) -> {
							Set<File> initialValue = new HashSet<File>();
							initialValue.add(file);
							return initialValue;
						}).add(file);
					}
				});
			}
			pool.shutdown();
			pool.awaitTermination(1, TimeUnit.HOURS);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(wordMap);
	}

}
