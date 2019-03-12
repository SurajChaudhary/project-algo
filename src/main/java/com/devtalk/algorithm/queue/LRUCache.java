package com.devtalk.algorithm.queue;

import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {

	public static void main(String[] args) {
		Cache ca = new Cache(4);
		ca.refer(1);
		ca.refer(2);
		ca.refer(3);
		ca.refer(1);
		ca.refer(4);
		ca.refer(5);
		ca.display();

	}

	static class Cache {
		private Deque<Integer> dequeue;
		private Map<Integer, Integer> map;
		int capacity;

		public Cache(int capacity) {
			this.dequeue = new LinkedList<Integer>();
			this.map = new HashMap<Integer, Integer>();
			this.capacity = capacity;
		}

		public void refer(int item) {

			if (map.containsKey(item)) {
				dequeue.remove(item);
				dequeue.addFirst(item);
				map.put(item, dequeue.peek());

			} else {
				if (dequeue.size() == capacity) {
					dequeue.removeLast();
					dequeue.addFirst(item);
					map.put(item, dequeue.peek());
				} else {
					dequeue.addFirst(item);
					map.put(item, dequeue.peek());
				}
			}

		}

		// display contents of cache
		public void display() {
			Iterator<Integer> itr = dequeue.iterator();
			while (itr.hasNext()) {
				System.out.print(itr.next() + " ");
			}
		}

	}

}
