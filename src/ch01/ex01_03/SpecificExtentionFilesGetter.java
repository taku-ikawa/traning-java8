package ch01.ex01_03;

import java.io.File;
import java.util.Objects;

public class SpecificExtentionFilesGetter {

	/**
	 * 指定されたディレクトリにあって、指定された拡張子を持つすべてのファイルを返す
	 * @param target 指定ディレクトリ
	 * @param extention 指定拡張子
	 * @return
	 */
	public File[] getSpecificExtentionFiles(File target, String extention) {
		Objects.requireNonNull(target);
		Objects.requireNonNull(extention);

		// エンクロージングスコープからキャプチャされる変数は"extention"

		return target.listFiles((file, name) -> name.endsWith(extention));
	}

}
