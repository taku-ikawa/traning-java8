package ch01.ex01_04;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class Ex04 {

	public static void main(String[] args) {
		new Ex04().exec();
	}

	private void exec() {
		String dirPath = System.getProperty("user.dir");
		File[] targetFiles = new File(dirPath).listFiles();
		sysoutFiles(getSubDirNormal(targetFiles));

		File[] targetFiles2 = new File(dirPath).listFiles();
		sysoutFiles(getSubDirLambda(targetFiles2));
	}

	private void sysoutFiles(File[] subDirs) {
		Arrays.asList(subDirs).forEach(System.out::println);
	}

	public File[] getSubDirNormal(File[] target) {
		System.out.println(":::getSubDirNormal:::");

		Arrays.sort(target, new Comparator<File>() {
			@Override
			public int compare(File o1, File o2) {
				// パス名でソート
				if((o1.isFile()) && (o2.isFile()) || (o1.isDirectory()) && (o2.isDirectory())) {
					return o2.getAbsolutePath().compareTo(o1.getAbsolutePath());
				}
				// ファイルの前にディレクトリが来るようにする
				if(o1.isDirectory()) {
					return 1;
				}
				if(o2.isDirectory()) {
					return -1;
				}
				return 1;
			}
		});

		return target;
	}

	public File[] getSubDirLambda(File[] target) {
		System.out.println(":::getSubDirLambda:::");

		Arrays.sort(target, (File o1, File o2) -> {
			// パス名でソート
			if((o1.isFile()) && (o2.isFile()) || (o1.isDirectory()) && (o2.isDirectory())) {
				return o2.getAbsolutePath().compareTo(o1.getAbsolutePath());
			}
			// ファイルの前にディレクトリが来るようにする
			if(o1.isDirectory()) {
				return 1;
			}
			if(o2.isDirectory()) {
				return -1;
			}
			return 1;
		});

		return target;
	}


}
