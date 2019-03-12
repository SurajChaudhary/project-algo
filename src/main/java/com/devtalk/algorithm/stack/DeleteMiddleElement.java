package com.devtalk.algorithm.stack;

import java.util.Stack;

public class DeleteMiddleElement {

	public static void main(String[] args) {
		Stack<Character> st = new Stack<Character>();

		// push elements into the stack
		st.push('1');
		st.push('2');
		st.push('3');
		st.push('4');
		st.push('5');
		st.push('6');
		st.push('7');
		System.out.println(st);
		deleteMiddle(st, st.size(), 0);
		System.out.println(st);

	}

	private static void deleteMiddle(Stack<Character> st, int size, int n) {
		if (st.isEmpty() || size == n) {
			return;
		}

		char c = st.pop();
		deleteMiddle(st, size, n + 1);
		if (n != size / 2) {
			st.push(c);
		}

	}

}
