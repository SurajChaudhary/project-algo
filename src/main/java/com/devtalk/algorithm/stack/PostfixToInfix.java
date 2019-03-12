package com.devtalk.algorithm.stack;

import java.util.Stack;

public class PostfixToInfix {

	public static void main(String[] args) {
		String exp = "ab*c+";
		// ((a*b)+c)
		String res = new PostfixToInfix().postfixToInfix(exp);
		System.out.println(res);

	}

	private String postfixToInfix(String exp) {
		char [] arr = exp.toCharArray();
		Stack<String> stk = new Stack();
		int l = arr.length;
		for(int i = 0; i <=l-1;i++) {
			if(isOperator(arr[i])) {
				String a = stk.pop();
				String b = stk.pop();
				String c = "("+b+arr[i]+a+")";
				stk.push(c);
			}else {
				stk.push(String.valueOf(arr[i]));
			}
		}
		return stk.pop();
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
