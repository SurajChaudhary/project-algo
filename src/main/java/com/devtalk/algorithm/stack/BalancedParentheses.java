package com.devtalk.algorithm.stack;

import java.util.Stack;

public class BalancedParentheses {

	public static void main(String[] args) {
		char exp[] = { '{', '(', ')', '}', '[', ']' };
		if (areParenthesisBalanced(exp))
			System.out.println("Balanced ");
		else
			System.out.println("Not Balanced ");

	}

	private static boolean areParenthesisBalanced(char[] exp) {
		Stack<Character> stk = new Stack<>();

		for (char c : exp) {
			if (c == '(' || c == '{' || c == '[') {
				stk.push(c);
			} else if (c == ')' || c == '}' || c == ']') {
				if (!machingPair(c, stk.pop())) {
					return false;
				}
			}
		}
		return true;
	}

	private static boolean machingPair(char character2, Character character1) {
		if (character1 == '(' && character2 == ')')
			return true;
		else if (character1 == '{' && character2 == '}')
			return true;
		else if (character1 == '[' && character2 == ']')
			return true;
		else
			return false;
	}

}
