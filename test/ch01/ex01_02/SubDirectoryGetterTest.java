package ch01.ex01_02;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class SubDirectoryGetterTest {

	private final String testDirPath = System.getProperty("user.dir");
	private final String testTargetDirName = "src";

	@Test
	public void test() {
		Stream<String> s = Stream.generate(() -> "Echo");
		s.collect(Collectors.toList());
	}
	
	@Test
	public void test_getSubDirLambda() {
		File targetFile = new File(testDirPath);

		// サブディレクトリ取得
		SubDirectoryGetter subDirectoryGetter = new SubDirectoryGetter();
		File[] out = subDirectoryGetter.getSubDirLambda(targetFile);
		judge(out);
	}

	@Test
	public void test_getSubDirMethodReference() {
		File targetFile = new File(testDirPath);

		// サブディレクトリ取得
		SubDirectoryGetter subDirectoryGetter = new SubDirectoryGetter();
		File[] out = subDirectoryGetter.getSubDirMethodReference(targetFile);
		judge(out);
	}

	private void judge(File[] out) {
		// サブディレクトリ名で判定
		List<String> fileNameList = new ArrayList<String>();
		Stream.of(out).forEach(file -> fileNameList.add(file.getName()));
		assertTrue(fileNameList.contains(testTargetDirName));
	}

}
