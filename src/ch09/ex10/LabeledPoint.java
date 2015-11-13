package ch09.ex10;

import java.util.Objects;

public class LabeledPoint implements Comparable<LabeledPoint>{

	private String label;
	private int x;
	private int y;

	LabeledPoint(String label, int x, int y) {
		this.label = label;
		this.x = x;
		this.y = y;
	}

	public boolean equals(Object otherObject) {
		if (this == otherObject) {
			return true;
		}
		if (otherObject == null) {
			return false;
		}
		if (getClass() != otherObject.getClass()) {
			return false;
		}
		LabeledPoint other = (LabeledPoint) otherObject;
		return Objects.equals(label, other.label) && Objects.equals(x, other.x)
				&& Objects.equals(y, other.y);
	}

	public int hashCode() {
		return Objects.hash(label, x, y);
	}

	@Override
	public int compareTo(LabeledPoint labeledPoint) {
		if(labeledPoint == null) {
			return 1;
		}
		if(this == labeledPoint) {
			return 0;
		}
		// label の判定
		if(label == null && labeledPoint.label != null) {
			return -1;
		}
		if(label != null && labeledPoint.label == null) {
			return 1;
		}
		if(label != null && labeledPoint.label != null) {
			int diffLabel = label.compareTo(labeledPoint.label);
			if(diffLabel != 0) {
				return diffLabel;
			}
		}
		// x の判定
		int diffX = Integer.compare(x, labeledPoint.x);
		if(diffX != 0) {
			return diffX;
		}
		// y の判定
		return Integer.compare(y, labeledPoint.y);
	}

}
