package com.devtalk.algorithm.stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {

	Queue<Integer> q1 = new LinkedList<Integer>();
	Queue<Integer> q2 = new LinkedList<Integer>();

	int size;
	int top;

	public StackUsingQueue(int size) {
		this.size = size;
		this.top = 0;
	}

	public boolean isEmpty() {
		return q1.isEmpty() && q2.isEmpty() ? true : false;
	}

	public void push(int data) {
		if (top >= size) {
			System.out.println("Overflow!!!");
			return;
		}
		q1.add(data);
		top++;
	}

	public int pop() {
		if (top <= 0) {
			System.out.println("Underflow!!!");
			return -1;
		}
		if (!q2.isEmpty()) {
			return q2.poll();
		}
		while (!q1.isEmpty()) {
			q2.add(q1.poll());
		}
		--top;
		return q2.poll();
	}

	public int size() {
		return q1.size() + q2.size();
	}

	public int top() {
		if (!q2.isEmpty()) {
			return q2.peek();
		}
		while (!q1.isEmpty()) {
			q2.add(q1.poll());
		}
		return q2.peek();
	}

	public static void main(String[] args) {
		StackUsingQueue s = new StackUsingQueue(3);
		System.out.println("current size: " + s.size());
		s.push(1);
		s.push(2);
		s.push(3);

		System.out.println("current size: " + s.size());
		System.out.println(s.top());
		s.pop();
		System.out.println(s.top());
		s.pop();
		System.out.println(s.top());

		System.out.println("current size: " + s.size());
	}

}
