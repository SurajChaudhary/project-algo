package com.devtalk.algorithm.stack;

import java.util.Stack;

public class QueueUsingStacks {
	Stack<Integer> s1 = new Stack();
	Stack<Integer> s2 = new Stack();

	public void enQueue(int data) {
		s1.push(data);
	}

	public void deQueue() {
		if (!s2.isEmpty()) {
			System.out.println("Popped : " + s2.pop());
			return;
		}
		while (!s1.isEmpty()) {
			s2.push(s1.pop());
		}
		System.out.println("Popped : " + s2.pop());
	}

	public boolean isEmpty() {
		return s1.isEmpty() && s2.isEmpty();
	}

	public int size() {
		return s1.size() + s2.size();
	}

	public static void main(String[] args) {
		QueueUsingStacks q = new QueueUsingStacks();
		q.enQueue(1);
		q.enQueue(2);
		q.enQueue(3);

		q.deQueue();
		q.deQueue();
		q.deQueue();
	}

}
