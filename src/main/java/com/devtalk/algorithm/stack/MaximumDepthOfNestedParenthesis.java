package com.devtalk.algorithm.stack;

import java.util.Stack;

public class MaximumDepthOfNestedParenthesis {

	public static void main(String[] args) {
		String s = "( ((X)) (((Y))) )";
		System.out.println(maxDepth(s));
		System.out.println(maxDepth2(s));
		
		System.out.println(maxSubstring("()(()))))"));

	}

	private static int maxDepth(String s) {
		char[] arr = s.toCharArray();
		int count = 0;
		int currentCount = 0;
		Stack<Character> stk = new Stack();
		for (char c : arr) {
			if (c == '(') {
				stk.push(c);
				currentCount++;
				if(currentCount > count) {
					count = currentCount;
				}
			} else if (!stk.isEmpty() && c == ')') {

				stk.pop();
				currentCount--;
				

			}
		}
		
		if(currentCount != 0) {
			return -1;
		}
		return count;
	}
	
	static int maxDepth2(String str) {
	char[] S = str.toCharArray();
	
	    int current_max = 0; // current count 
	    int max = 0;    // overall maximum count 
	    int n = S.length; 
	  
	    // Traverse the input string 
	    for (int i = 0; i< n; i++) 
	    { 
	        if (S[i] == '(') 
	        { 
	            current_max++; 
	  
	            // update max if required 
	            if (current_max> max) 
	                max = current_max; 
	        } 
	        else if (S[i] == ')') 
	        { 
	            if (current_max>0) 
	                current_max--; 
	            else
	                return -1; 
	        } 
	    } 
	  
	    // finally check for unbalanced string 
	    if (current_max != 0) 
	        return -1; 
	  
	    return max; 
	} 
	/*
	 * Input : ((()
Output : 2
Explanation : ()

Input: )()())
Output : 4
Explanation: ()() 

Input:  ()(()))))
Output: 6
Explanation:  ()(())
	 */
	static int maxSubstring(String s) {
		char [] cc = s.toCharArray();
		Stack<Character> stk = new Stack();
		int count = 0;
		for(char c : cc) {
			if(c == '(') {
				stk.push(c);
			}else if(c == ')'){
				if(stk.isEmpty()) {
					stk.push(c);
				}else {
					if(stk.peek() == '(') {
						count= count+2;
						stk.pop();
					}
				}
			}
		}
		return count;
	}

}
