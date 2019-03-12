package com.devtalk.algorithm.stack;

import java.util.Stack;

public class ReverseStackUsingRecursion {
	static Stack<Character> stk = new Stack<>();
	public static void main(String[] args) {
		Stack<Character> st = new Stack<>();
		st.push('1');
		st.push('2');
		st.push('3');
		st.push('4');

		System.out.println("Original Stack");

		System.out.println(st);

		// function to reverse
		// the stack
		reverse(st);

		System.out.println("Reversed Stack");

		System.out.println(stk);

	}

	private static void reverse(Stack<Character> st) {
		if(st.isEmpty()) {
			return;
		}
		char c = st.pop();
		reverse(st);
		stk.push(c);
		
	}

}
