package ch01.ex01_03;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

public class SpecificExtentionFilesGetterTest {

	private final String testDirPath = System.getProperty("user.dir");
	private final String testExtention = ".git";
	private final String testTargetDirName = ".git";

	@Test
	public void test_getSpecificExtentionFilesNormal() {
		File targetFile = new File(testDirPath);

		SpecificExtentionFilesGetter specificExtentionFilesGetter = new SpecificExtentionFilesGetter();
		File[] out = specificExtentionFilesGetter.getSpecificExtentionFiles(targetFile, testExtention);
		judge(out);
	}

	private void judge(File[] out) {
		// サブディレクトリ名で判定
		List<String> fileNameList = new ArrayList<String>();
		Stream.of(out).forEach(file -> fileNameList.add(file.getName()));
		assertTrue(fileNameList.contains(testTargetDirName));
	}

}
