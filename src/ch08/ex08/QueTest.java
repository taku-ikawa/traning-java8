package ch08.ex08;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class QueTest {

	//private static Checkedqueue(new LinkedList<Path>, Path.class);

	private static Queue<Path> queue = new LinkedList<Path>();

	public static void getMoreWork(Queue q) {
		// 誤ってStringを挿入
		q.add("path2");
	}

	public static void main(String[] args) {
		queue = Collections.checkedQueue(queue, Path.class); // checkedQueueすれば挿入時に検出

		queue.add(Paths.get("path1"));
		getMoreWork(queue);
		queue.add(Paths.get("path3"));

		while(!queue.isEmpty()) {
			Path p = queue.remove();
			System.out.println(p);
		}

	}

}
