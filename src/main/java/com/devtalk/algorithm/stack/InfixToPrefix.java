package com.devtalk.algorithm.stack;

import java.util.Stack;

public class InfixToPrefix {
	/*
	 * Step 1: Reverse the infix expression i.e A+B*C will become C*B+A. Note while
	 * reversing each ‘(‘ will become ‘)’ and each ‘)’ becomes ‘(‘. Step 2: Obtain
	 * the postfix expression of the modified expression i.e CB*A+. Step 3: Reverse
	 * the postfix expression. Hence in our example prefix is +A*BC.
	 */

	public static void main(String[] args) {
		String s = "(a-b/c)*(a/k-l)";
		// *-a/bc-/akl
		String res = new InfixToPrefix().infixToPrefix(s);
		System.out.println(res);

	}

	private String infixToPrefix(String s) {
		String rev = reverse(s);
		String res = "";
		Stack<String> stk = new Stack();
		char[] aa = rev.toCharArray();
		for (char a : aa) {
			if (Character.isLetterOrDigit(a)) {
				res += a;
			} else if (a == '(') {
				stk.push(String.valueOf(a));
			} else if (a == ')') {
				while (!stk.isEmpty() && !"(".equalsIgnoreCase(stk.peek())) {
					res += stk.pop();
				}
				while (!stk.isEmpty() && !"(".equalsIgnoreCase(stk.peek())) {
					stk.pop();
				}
				stk.pop();
			} else {
				while (!stk.isEmpty() && getPriority(String.valueOf(a)) < getPriority(stk.peek())) {
					res += stk.pop();
				}
				stk.push(String.valueOf(a));
			}
		}
		while (!stk.isEmpty()) {
			res += stk.pop();
		}

		return reverse(res);
	}

	private String reverse(String s) {
		StringBuilder sb = new StringBuilder("");
		char[] cc = s.toCharArray();
		int l = cc.length;
		for (int i = l - 1; i >= 0; i--) {
			if (cc[i] == '(') {
				sb.append(')');
			} else if (cc[i] == ')') {
				sb.append('(');
			} else {
				sb.append(cc[i]);
			}
		}
		return sb.toString();
	}

	public int getPriority(String c) {
		switch (c) {
		case "+":
		case "-":
			return 1;
		case "*":
		case "/":
			return 2;
		case "^":
			return 3;

		}
		return -1;
	}

	private boolean isOperator(char c) {
		switch (c) {
		case '+':
		case '-':
		case '*':
		case '/':
		case '^':
			return true;
		}
		return false;
	}

}
