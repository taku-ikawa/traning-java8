package ch01.ex01_03;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class Ex03 {

	public static void main(String[] args) {
		new Ex03().exec();
	}

	private void exec() {
		String dirPath = System.getProperty("user.dir");
		File targetFile = new File(dirPath);
		String extention = ".git";

		sysoutFiles(getSpecificExtentionFilesNormal(targetFile, extention));
		sysoutFiles(getSpecificExtentionFilesLambda(targetFile, extention));
	}

	private void sysoutFiles(File[] subDirs) {
		Arrays.asList(subDirs).forEach(System.out::println);
	}

	public File[] getSpecificExtentionFilesNormal(File target, String extention) {
		System.out.println(":::getSubDirNormal:::");

		return target.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File file, String name) {
				return name.endsWith(extention);
			}
		});
	}

	public File[] getSpecificExtentionFilesLambda(File target, String extention) {

		// エンクロージングスコープからキャプチャされる変数は"extention"

		System.out.println(":::getSubDirLambda:::");
		return target.listFiles((file, name) -> name.endsWith(extention));
	}

}
