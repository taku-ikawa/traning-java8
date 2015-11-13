package ch06.ex06_05;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

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
						// ConcurrentなHashMapにしないとだめ
						Set<File> initialValue = ConcurrentHashMap.newKeySet();
						initialValue.add(file);
						wordMap.merge(word, initialValue, (existingValue, newValue) -> {
							if(existingValue.contains(file)) {
								return existingValue;
							}
							existingValue.add(file);
							return existingValue;
						});
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
