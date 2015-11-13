package ch09.ex08;

public class Point implements Comparable<Point>{

	private int x;
	private int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Point other) {
		int diff = (x < other.x) ? -1 : ((x == other.x) ? 0 : 1);
		if(diff != 0) {
			return diff;
		}
		return (y < other.y) ? -1 : ((y == other.y) ? 0 : 1);
	}

// オーバーフローを起こす実装
//	@Override
//	public int compareTo(Point other) {
//		int diff = x - other.x;
//		if(diff != 0) {
//			return diff;
//		}
//		return y - other.y;
//	}

// Integer.compareを使用
//	@Override
//	public int compareTo(Point other) {
//		int diff = Integer.compare(x, other.x);
//		if(diff != 0) {
//			return diff;
//		}
//		return Integer.compare(y, other.y);
//	}

}
