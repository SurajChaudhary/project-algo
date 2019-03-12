package com.devtalk.algorithm.stack;

import java.util.Stack;

public class TheCelebrityProblem {

	// Person with 2 is celebrity
	static int MATRIX[][] = { { 0, 0, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 0 }, { 0, 0, 1, 0 } };

	static int MATRIX1[][] = { { 0, 0, 0, 1 }, { 0, 0, 0, 1 }, { 0, 0, 0, 1 }, { 0, 0, 0, 1 } };

	public static void main(String[] args) {
		int n = 4;
		int result = findCelebrity(n);
		if (result == -1) {
			System.out.println("No Celebrity");
		} else
			System.out.println("Celebrity ID " + result);

	}

	private static int findCelebrity(int n) {
		Stack<Integer> stk = new Stack();

		// Step 1 :Push everybody onto stack
		for (int i = 0; i < n; i++) {
			stk.push(i);
		}

		while (stk.size() > 1) {
			// Step 2 :Pop off top two persons from the stack, discard one person based on
			// return status of knows(A, B).

			int a = stk.pop();
			int b = stk.pop();

			// Step 3 : Push the remained person onto stack.
			if (knows(a, b)) {
				stk.push(b);
			} else {
				stk.push(a);
			}
		}

		int c = stk.pop();
		// Step 5 : Check if the last person is celebrity or not
		for (int i = 0; i < n; i++) {
			// If any person doesn't know 'c' or 'c' knows any person, return -1
			if (i != c && (knows(c, i) || !knows(i, c)))
				return -1;
		}
		return c;
	}

	// Returns true if a knows b, false otherwise
	static boolean knows(int a, int b) {
		return (MATRIX1[a][b] == 1) ? true : false;
	}

}
