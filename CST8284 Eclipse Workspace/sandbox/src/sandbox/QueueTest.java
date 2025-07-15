package sandbox;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {

	public static void main(String[] args) {
		Queue<String> q = new
		LinkedList<>();
				q.add("A");
				q.add("B");
				q.add("C");
				while (q.size() > 0) { System.out.print(q.remove() + " "); }

	}

}