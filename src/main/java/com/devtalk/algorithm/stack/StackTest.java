package com.devtalk.algorithm.stack;

public class StackTest {
	public static void main(String args[]) {
		StackWithArray s = new StackWithArray();
		s.push(10);
		s.push(20);
		s.push(30);
		System.out.println(s.pop() + " Popped from stack");
		System.out.println("Size :" + s.size());
		System.out.println(s.pop() + " Popped from stack");
		System.out.println(s.peek() + " Peeked from stack");
		System.out.println("Size :" + s.size());

		System.out.println("###############");

		StackWithLinkedList stk = new StackWithLinkedList(3);
		stk.push(10);
		stk.push(20);
		stk.push(30);
		System.out.println(stk.pop() + " Popped from stack");
		System.out.println("Size :" + stk.size());
		System.out.println(stk.pop() + " Popped from stack");
		System.out.println(stk.peek() + " Peeked from stack");
		System.out.println("Size :" + stk.size());
		System.out.println(stk.pop() + " Popped from stack");
		System.out.println(stk.pop() + " Popped from stack");
	}

}
