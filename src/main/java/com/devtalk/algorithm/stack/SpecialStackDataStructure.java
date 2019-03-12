package com.devtalk.algorithm.stack;

import java.util.Stack;

public class SpecialStackDataStructure {

	Stack<Integer> s1 = new Stack();
	Stack<Integer> min = new Stack();

	public static void main(String[] args) {
		SpecialStackDataStructure s = new SpecialStackDataStructure();
		s.push(10);
		s.push(20);
		s.push(30);
		System.out.println(s.getMin());
		s.push(5);
		System.out.println(s.getMin());

	}

	public void push(int data) {
		if (s1.isEmpty() && min.isEmpty()) {
			s1.push(data);
			min.push(data);
		} else {
			s1.push(data);
			int d = min.peek();
			if (d < data) {
				min.push(d);
			} else {
				min.push(data);
			}
		}
	}

	public int pop() {
		min.pop();
		return s1.pop();
	}

	public int getMin() {
		return min.peek();
	}

}
