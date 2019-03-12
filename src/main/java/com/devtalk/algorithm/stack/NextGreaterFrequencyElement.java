package com.devtalk.algorithm.stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterFrequencyElement {

	public static void main(String[] args) {
		// Input : a[] = [1,   1, 2, 3, 4, 2, 1] 
		// Output :      [-1, -1, 1, 2, 2, 1, -1]
		int a[] = {1, 1, 2, 3, 4, 2, 1} ;
		
		nextGreaterFrequencyElement(a);

	}

	private static void nextGreaterFrequencyElement(int[] arr) {
		Map<Integer,Integer> freq = new HashMap();
		for(int a : arr) {
			if(freq.containsKey(a)) {
				int c = freq.get(a);
				freq.put(a, c+1);
			}else {
				freq.put(a, 1);
			}
		}
		int [] ff = new int[arr.length];
		
		Stack<Integer> stk = new Stack();
		for(int i = 0; i <=arr.length-1; i++) {
			if(stk.isEmpty()) {
				stk.push(i);
			}else {
				while(!stk.isEmpty() && freq.get(arr[i]) > freq.get(arr[stk.peek()])) {
					ff[stk.pop()] = arr[i];
				}
				stk.push(i);
			}
		}
		
		while(!stk.isEmpty()) {
			ff[stk.pop()] = -1;
		}
		
		System.out.println(Arrays.toString(ff));
		
		
	}

}
