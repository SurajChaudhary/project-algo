package com.devtalk.algorithm.queue;

public class ArrayImplementationOfQueue {

	public static void main(String[] args) {
		Queue queue = new Queue(1000);

		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);

		System.out.println(queue.dequeue() + " dequeued from queue\n");

		System.out.println("Front item is " + queue.front());

		System.out.println("Rear item is " + queue.rear());

	}

	static class Queue {

		int[] arr;
		int capacity;
		int size;
		int front;
		int rear;

		public Queue(int capacity) {
			this.capacity = capacity;
			this.size = 0;
			this.front = 0;
			this.arr = new int[capacity];
			this.rear = capacity - 1;
		}

		public int dequeue() {
			if (isEmpty()) {
				System.out.println("Queue is empty!!!");
				return -1;
			}
			int item = arr[this.front];
			this.front = (this.front + 1) % this.capacity;
			this.size = this.size - 1;
			return item;
		}

		public void enqueue(int item) {
			if (isFull()) {
				System.out.println("Queue is full!!!");
				return;
			}
			this.rear = (this.rear + 1) % this.capacity;
			this.arr[this.rear] = item;
			this.size = this.size + 1;
			System.out.println(item + " enqueued to queue");

		}

		public boolean isFull() {
			return this.size == this.capacity;
		}

		public boolean isEmpty() {
			return this.size == 0;
		}

		public int front() {
			if (isEmpty()) {
				System.out.println("Queue is empty!!!");
				return 0;
			}
			return arr[this.front];
		}

		public int rear() {
			if (isEmpty()) {
				System.out.println("Queue is empty!!!");
				return 0;
			}
			return arr[this.rear];
		}

	}

}
