package com.devtalk.algorithm.stack;

import java.util.Stack;

public class InfixToPostfix {

	public static void main(String[] args) {
		String exp = "a+b*(c^d-e)^(f+g*h)-i";
		
		String res = new InfixToPostfix().infixToPostfix(exp);
		System.out.println(res);

		//O/p: abcd^e-fgh*+^*+i-

	}

	private String infixToPostfix(String exp) {
		String result = "";
		char[] arr = exp.toCharArray();
		Stack<Character> stk = new Stack();
		for (char c : arr) {
			if (Character.isLetterOrDigit(c)) {
				result += c;
			} else if (c == '(') {
				stk.push(c);
			} else if (c == ')') {
				while (!stk.isEmpty() && stk.peek() != '(') {
					result += stk.pop();
				}
				if (!stk.isEmpty() && stk.peek() != '(')
					return "Invalid Expression"; // invalid expression
				else
					stk.pop();
			}else {
				while (!stk.isEmpty() && getPrecedence(c) <= getPrecedence(stk.peek())) {
                    result += stk.pop(); 
				}
                stk.push(c); 
			}
			
		}
		// pop all the operators from the stack 
        while (!stk.isEmpty()) { 
            result += stk.pop();
        }
		return result;
	}

	public int getPrecedence(char c) {
		switch (c) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '^':
			return 3;

		}
		return -1;
	}

}
