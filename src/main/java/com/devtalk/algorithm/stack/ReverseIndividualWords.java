package com.devtalk.algorithm.stack;

import java.util.Stack;

public class ReverseIndividualWords {

	public static void main(String[] args) {
		//Input : Hello World
		//Output : olleH dlroW
		
		String str = "Geeks for Geeks"; 
	    reverseWords(str);

	}

	private static void reverseWords(String str) {
		Stack<Character> stk = new Stack();
		
		for(int i=0; i <str.length();i++) {
			if(str.charAt(i) != ' ') {
				stk.push(str.charAt(i));
			}else {
				while(!stk.isEmpty()) {
					System.out.print(stk.pop());
				}
				System.out.print(" ");
			}
			
		}
		
		// Since there may not be space after 
	    // last word. 
	    while (stk.empty() == false) { 
	        System.out.print(stk.pop()); 
	          
	    } 
		
	}

}
