package com.devtalk.algorithm.stack;

import java.util.Stack;

public class PrefixToPostfix {

	public static void main(String[] args) {
		String exp = "*-A/BC-/AKL";
		//Postfix : ABC/-AK/L-*
		
		String res = new PrefixToPostfix().prefixToPostfix(exp);
		System.out.println(res);

	}
	
	private String prefixToPostfix(String exp) {
		char [] arr = exp.toCharArray();
		Stack<String> stk = new Stack();
		int l = arr.length;
		for(int i = l-1; i >=0;i--) {
			if(isOperator(arr[i])) {
				String a = stk.pop();
				String b = stk.pop();
				String c = a+b+arr[i];
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
