package com.devtalk.algorithm.stack;

import java.util.Stack;

public class EvaluatePostfix {

	public static void main(String[] args) {
		String exp="231*+9-"; 
        System.out.println("postfix evaluation: "+evaluatePostfix(exp));
        //postfix evaluation: -4

	}

	private static String evaluatePostfix(String exp) {
		char [] arr = exp.toCharArray();
		Stack<Integer> stk = new Stack();
		
		for(char c : arr) {
			if(Character.isDigit(c)) {
				stk.push(c-'0');
			}else {
				stk.push(evaluate(c, stk.pop(), stk.pop()));
			}
			
		}
		return "postfix evaluation : "+stk.pop();
	}
	
	private static int evaluate(char c, int val1, int val2) {
		switch(c) 
        { 
            case '+': 
            return val2+val1; 
              
            case '-': 
            	return val2- val1; 
              
            case '/': 
            	return val2/val1; 
              
            case '*': 
            	return val2*val1; 
      }
		return 0;
	}

}
