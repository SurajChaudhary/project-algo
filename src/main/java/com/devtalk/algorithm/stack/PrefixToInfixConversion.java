package com.devtalk.algorithm.stack;

import java.util.Stack;

public class PrefixToInfixConversion {

	public static void main(String[] args) {
		String exp = "*-A/BC-/AKL";
		// Infix : ((A-(B/C))*((A/K)-L))
		
		String res = new PrefixToInfixConversion().prefixToInfix(exp);
		System.out.println(res);

	}

	private String prefixToInfix(String exp) {
		char [] arr = exp.toCharArray();
		Stack<String> stk = new Stack();
		int l = arr.length;
		for(int i = l-1; i >=0;i--) {
			if(isOperator(arr[i])) {
				String a = stk.pop();
				String b = stk.pop();
				String c = "("+a+arr[i]+b+")";
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
