package com.devtalk.algorithm.queue;

import java.util.Stack;

public class QueueUsingStacksTest {

	public static void main(String[] args) {
		MyQueue queue = new MyQueue();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		System.out.println("No of elements in queue : " + queue.size());
		queue.dequeue();
		queue.dequeue();
		System.out.println("No of elements in queue : " + queue.size());
		queue.enqueue(5);
		System.out.println("Is queue empty : " + queue.isEmpty());
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		System.out.println("No of elements in queue : " + queue.size());
		System.out.println("Is queue empty : " + queue.isEmpty());
	}

}

class MyQueue {

	private Stack<Integer> stackOne = new Stack<Integer>();
	private Stack<Integer> stackTwo = new Stack<Integer>();

	public void enqueue(int number) {
		stackOne.push(number);
	}

	public int dequeue() {
		if (stackOne.isEmpty() && stackTwo.isEmpty()) {
			System.out.println("Nothing to dequeue. Queue is empty.");
			return 0;
		}
		if (stackTwo.isEmpty()) {
			while (!stackOne.isEmpty()) {
				int num = stackOne.pop();
				stackTwo.push(num);
			}
		}

		return stackTwo.pop();
	}

	public int size() {
		return stackOne.size() + stackTwo.size();
	}

	public boolean isEmpty() {
		return stackOne.isEmpty() && stackTwo.isEmpty();
	}
}
