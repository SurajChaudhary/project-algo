package com.devtalk.algorithm.queue;

public class PriorityQueueUsingLinkedList {

	public static void main(String[] args) {
		PriorityQueue pq = new PriorityQueue();
		pq.push(4, 1);
		pq.push(5, 2);
		pq.push(6, 3);
		pq.push(7, 0);

		while (!pq.isEmpty()) {
			System.out.printf("%d ", pq.peek());
			pq.pop();
		}

	}

	static class PriorityQueue {

		Node front;

		public PriorityQueue() {
			this.front = null;
		}

		public Object peek() {
			return this.front.data;
		}

		public boolean isEmpty() {
			return this.front == null;
		}

		public Node top() {
			return this.front;
		}

		public Node pop() {
			if (this.front == null) {
				System.out.println("Underflow!!!");
				return null;
			} else {
				Node item = this.front;
				this.front = this.front.next;
				return item;
			}

		}

		public void push(int item, int priority) {
			if (this.front == null) {
				this.front = new Node(item, priority);
			} else if (this.front.priority > priority) {
				Node start = new Node(item, priority);
				start.next = this.front;
				this.front = start;
			} else {
				Node start = this.front;
				Node prev = null;
				while (start != null && start.priority < priority) {
					prev = start;
					start = start.next;
				}
				prev.next = new Node(item, priority);
				prev.next.next = start;

			}

		}

		static class Node {
			int data;
			int priority;
			Node next;

			public Node(int data, int priority) {
				this.data = data;
				this.priority = priority;
				this.next = null;
			}

		}
	}

}
