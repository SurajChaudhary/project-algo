package com.devtalk.algorithm.stack;

import java.util.Stack;

public class FormMinimumNumberFromGivenSequence {

	public static void main(String[] args) {
		String inputs[] = { "IDID", "I", "DD", "II", "DIDI", "IIDDD", "DDIDDIID" };

		for (String input : inputs) {
			System.out.print(printMinNumberForPattern(input));
			System.out.print("===");
			System.out.print(getMinNumberForPattern(input));
			System.out.println(" ");
		}

	}

	// Returns minimum number made from given sequence without repeating digits
	private static String getMinNumberForPattern(String seq) {
		int n = seq.length();

		if (n >= 9)
			return "-1";

		char result[] = new char[n + 1];

		int count = 1;

		// The loop runs for each input character as well as
		// one additional time for assigning rank to each remaining characters
		for (int i = 0; i <= n; i++) {
			if (i == n || seq.charAt(i) == 'I') {
				for (int j = i - 1; j >= -1; j--) {
					result[j + 1] = (char) ((int) '0' + count++);
					if (j >= 0 && seq.charAt(j) == 'I')
						break;
				}
			}
		}
		return new String(result);
	}
	
	private static String printMinNumberForPattern(String s) {
		char [] arr = s.toCharArray();
		Stack<Integer> stk = new Stack();
		String res = "";
		
		for(int i=0; i<= arr.length;i++) {
			stk.push(i+1);
			
			if(i == arr.length || arr[i] == 'I') {
				while(!stk.isEmpty()) {
					
					res+=stk.pop();
				}
				
			}
		}
		
		return res;
		
	}

}
