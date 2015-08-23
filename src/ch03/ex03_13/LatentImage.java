package ch03.ex03_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javafx.scene.image.Image;

public class LatentImage {

	private Image in;
	private List<ImageTransformer> pendingImageTransformerOperatins = new ArrayList<ImageTransformer>();

	private LatentImage(Image in) {
		this.in = in;
	}

	/**
	 * ImageTransformerで定義される遅延操作をLatentImageに変換する
	 * @param f
	 * @return
	 * @throws NullPointerException fがnullのケース
	 */
	LatentImage transform(ImageTransformer f) {
		Objects.requireNonNull(f, "f is null");
		pendingImageTransformerOperatins.add(f);
		return this;
	}

	/**
	 * LatentImageを生成する
	 * @param in
	 * @return
	 * @throws NullPointerException inがnullのケース
	 */
	static LatentImage from(Image in) {
		Objects.requireNonNull(in, "in is null");
		return new LatentImage(in);
	}

	/**
	 * LatentImageとして蓄積された遅延操作を実行して結果をImageとして返す
	 * @return
	 */
	Image toImage() {
		Image outImage = in;
		for(ImageTransformer f : pendingImageTransformerOperatins) {
			// 演算の１つが評価される際に、前段の計算が強制されるようにする
			outImage = f.apply(outImage);
		}
		return outImage;
	}

}
