package com.devtalk.algorithm.queue;

public class LinkedListImplementationOfQueue {

	public static void main(String[] args) {
		Queue q = new Queue();
		q.enqueue(10);
		q.enqueue(20);
		q.dequeue();
		q.dequeue();
		q.enqueue(30);
		q.enqueue(40);
		q.enqueue(50);

		System.out.println("Dequeued item is " + q.dequeue().data);

	}

	static class Queue {

		Node front;
		Node rear;

		public Queue() {
			this.front = null;
			this.rear = null;
		}

		public Node dequeue() {
			if (this.front == null) {
				System.out.println("Queue is empty!!!");
				return null;
			} else {
				Node item = this.front;
				this.front = this.front.next;
				return item;
			}

		}

		public void enqueue(int item) {
			if (this.front == null) {
				this.front = new Node(item);
				this.rear = this.front;
			} else {
				this.rear.next = new Node(item);
				this.rear = this.rear.next;
			}

		}

		static class Node {
			int data;
			Node next;

			public Node(int data) {
				this.data = data;
				this.next = null;
			}

		}
	}

}
