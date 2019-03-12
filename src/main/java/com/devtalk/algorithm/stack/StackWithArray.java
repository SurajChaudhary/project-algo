package com.devtalk.algorithm.stack;

public class StackWithArray {
	static final int MAX = 100;
	int stack [] = new int[MAX];
	int top = 0;
	
	public boolean isEmpty() {
		return top <= 0 ? true : false;
	}
	
	public void push(int el) {
		
		if(top >= MAX) {
			System.out.println("Overflow!!!");
		}else {
			top++;
			stack[top] = el;
		}
	}
	
	public int pop() {
		if(top < 0) {
			System.out.println("Underflow!!!");
			return -1;
		}else {
			int el = stack[top];
			top--;
			return el;
		}
		
	}
	
	public int peek() {
		if(top < 0) {
			System.out.println("Underflow!!!");
			return -1;
		}else {
			return stack[top];
		}
	}
	
	public int size() {
		return top;
	}
	
	public void print(StackWithArray s ) {
		if(s.size() <= 0) {
			return;
		}
		int el = s.pop();
		print( s );
		System.out.println(el + " ");
	}

}
