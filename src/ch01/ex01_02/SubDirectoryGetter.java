package ch01.ex01_02;

import java.io.File;
import java.util.Objects;

public class SubDirectoryGetter {

	/**
	 * 指定されたディレクトリのすべてのサブディレクトリを返す
	 * @param target 指定ディレクトリ
	 * @return サブディレクトリ
	 */
	public File[] getSubDirLambda(File target) {
		Objects.requireNonNull(target);
		return target.listFiles(file -> file.isDirectory());
	}

	/**
	 * 指定されたディレクトリのすべてのサブディレクトリを返す
	 * @param target 指定ディレクトリ
	 * @return サブディレクトリ
	 */
	public File[] getSubDirMethodReference(File target) {
		Objects.requireNonNull(target);
		return target.listFiles(File::isDirectory);
	}

}
