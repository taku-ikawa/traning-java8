package ch01.ex01_12;

import java.util.Collection;
import java.util.Iterator;

public class CollectionImpl implements Collection{


	/*
	 * Q：Collectionインターフェースの新たなstreamメソッドが古いコードのコンパイルを失敗させるシナリオを述べなさい。
	 * A："stream()"というprivateメソッドがあればコンパイルエラーになる
	 *
	 * Q：jarファイルからの古いコードは、動作するでしょうか？
	 * A：このクラスを古いverでコンパイルして生成したJARファイルに対してstreamメソッドがコールされた場合、
	 *    publicなstreamメソッドを検出できずにNoSuchMethodErrorが発生すると考えられる。
	 */

	// 以下のような"stream()"というprivateメソッドがあればコンパイルエラーになる
	// private void stream() {}

	@Override
	public int size() {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public boolean contains(Object o) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public Iterator iterator() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public Object[] toArray(Object[] a) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public boolean add(Object e) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public boolean remove(Object o) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public boolean containsAll(Collection c) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public boolean addAll(Collection c) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public boolean removeAll(Collection c) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public boolean retainAll(Collection c) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public void clear() {
		// TODO 自動生成されたメソッド・スタブ

	}


}
