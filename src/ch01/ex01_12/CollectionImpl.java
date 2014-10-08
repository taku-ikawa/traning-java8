package ch01.ex01_12;

import java.util.Collection;
import java.util.Iterator;

public class CollectionImpl implements Collection{


	/*
	 * "stream()"というprivateメソッドがあればコンパイルエラーになる
	 *
	 * private void stream() {}
	 *
	 * このクラスを古いverでコンパイルして生成したJARファイルに対してstreamメソッドがコールされた場合、
	 * publicなstreamメソッドを検出できずにNoSuchMethodErrorが発生すると思われる。
	 *
	 */
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
