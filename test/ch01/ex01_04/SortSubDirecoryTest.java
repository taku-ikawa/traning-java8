package ch01.ex01_04;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class SortSubDirecoryTest {

	private final String testDirPath = System.getProperty("user.dir");
	private final String testTargetDirName1 = ".classpath";
	private final String testTargetDirName2 = ".git";
	private final String testTargetDirName3 = "bin";
	private final String testTargetDirName4 = "src";
	private final String testTargetDirName5 = "test";
	private final List<String> testTargetList = new ArrayList<String>();

	@Before
	public void setUp() {
		testTargetList.add(testTargetDirName1);
		testTargetList.add(testTargetDirName2);
		testTargetList.add(testTargetDirName3);
		testTargetList.add(testTargetDirName4);
		testTargetList.add(testTargetDirName5);
	}

	@Test
	public void test_sortSubDir() {
		File[] targetFiles = new File(testDirPath).listFiles();

		SortSubDirecory sortSubDirecory = new SortSubDirecory();
		File[] out = sortSubDirecory.sortSubDir(targetFiles);

		// アウトプットの中から判定対象のファイル名、ディレクトリ名だけを抜き取る
		List<String> fileNameList = new ArrayList<String>();
		Arrays.asList(out).forEach(file -> {
			if(testTargetList.contains(file.getName())) {
				fileNameList.add(file.getName());
			}
		});

		// 順序が一致しているか確認する
		for(int i = 0; i < testTargetList.size(); i++) {
			assertEquals(testTargetList.get(i), fileNameList.get(i));
		}

		System.out.println(testTargetList);
		System.out.println(fileNameList);

	}

}
