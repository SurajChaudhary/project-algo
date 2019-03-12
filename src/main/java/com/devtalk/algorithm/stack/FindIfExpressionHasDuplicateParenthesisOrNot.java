package com.devtalk.algorithm.stack;

import java.util.Stack;

public class FindIfExpressionHasDuplicateParenthesisOrNot {

	public static void main(String[] args) {
		// input balanced expression 
	    
	    String [] ss = {"(((a+(b))+(c+d)))","((a+b)+((c+d)))","(((a+(b)))+(c+d))","(((a+(b))+c+d))","((a+b)+(c+d))","((a+(b))+(c+d))"};
	  for(String str : ss) {
	    if (findDuplicateparenthesis(str)) 
	        System.out.println("Duplicate Found in :"+str); 
	    else
	    	System.out.println("No Duplicates Found in :"+str); 
	  }

	}

	private static boolean findDuplicateparenthesis(String str) {
		char [] ch = str.toCharArray();
		Stack<Character> stk = new Stack();
		for(char c : ch) {
			
			if(c == ')') {
				char top = stk.pop();
				int count = 0;
				while(top != '(') {
					count++;
					top = stk.pop();
				}
				if(count <1 ) {
					return true;
				}
				
			}else {
				stk.push(c);
			}
		}
		return false;
	}

}
