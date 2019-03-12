package com.devtalk.algorithm.stack;

import java.util.Stack;

public class ExpressionContainsRedundantBracketOrNot {

	public static void main(String[] args) {
		String str = "((a+b))";
		findRedundant(str);

		str = "(a+(b)/c)";
		findRedundant(str);

		str = "(a+b*(c-d))";
		findRedundant(str);

	}

	private static void findRedundant(String str) {
		char[] cc = str.toCharArray();
		Stack<Character> stk = new Stack();
		for (char c : cc) {

			if (c == ')') {

				char top = stk.pop();
				boolean flag = true;

				while (top != '(') {

					if (top == '+' || top == '-' || top == '*' || top == '/' || top == '^' || top == '%') {
						flag = false;

					}
					top = stk.pop();

				}

				if (flag) {
					System.out.println("Yes");
					return;
				}
			} else {
				stk.push(c);
			}
		}

		System.out.println("No");

	}

}
