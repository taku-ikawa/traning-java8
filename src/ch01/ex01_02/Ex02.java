package ch01.ex01_02;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class Ex02 {

	public static void main(String[] args) {
		new Ex02().exec();
	}

	private void exec() {
		String dirPath = System.getProperty("user.dir");
		File targetFile = new File(dirPath);

		sysoutFiles(getSubDirNormal(targetFile));
		sysoutFiles(getSubDirLambda(targetFile));
		sysoutFiles(getSubDirMethodReference(targetFile));
	}

	private void sysoutFiles(File[] subDirs) {
		Arrays.asList(subDirs).forEach(System.out::println);
	}

	public File[] getSubDirNormal(File target) {
		System.out.println(":::getSubDirNormal:::");

		return target.listFiles(new FileFilter() {
			@Override
			public boolean accept(File file) {
				return file.isDirectory();
			}
		});
	}

	public File[] getSubDirLambda(File target) {
		System.out.println(":::getSubDirLambda:::");

		return target.listFiles(file -> file.isDirectory());
	}

	public File[] getSubDirMethodReference(File target) {
		System.out.println(":::getSubDirMethodReference:::");

		return target.listFiles(File::isDirectory);
	}

}
