package ch01.ex01_04;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;

public class SortSubDirecory {

	/**
	 * 指定されたFileオブジェクトの配列をソートします
	 * ファイルの前にディレクトリが来るようにし、ファイルとディレクトリのそれぞれのグループではパス名でソートします
	 * @param target 指定ファイル
	 * @return ソートされたファイル
	 */
	public File[] sortSubDir(File[] target) {
		Objects.requireNonNull(target);
		Arrays.sort(target, (File o1, File o2) -> {
			// 両方ともパス、もしくは両方ともディレクトリであった場合はパス名でソート
			if((o1.isFile()) && (o2.isFile()) || (o1.isDirectory()) && (o2.isDirectory())) {
				return o1.getAbsolutePath().compareTo(o2.getAbsolutePath());
			}else {
				// ファイルの前にディレクトリが来るようにする
				if(o1.isDirectory()) {
					return 1;
				}
				if(o2.isDirectory()) {
					return -1;
				}
			}
			return 1;
		});
		return target;
	}

}
