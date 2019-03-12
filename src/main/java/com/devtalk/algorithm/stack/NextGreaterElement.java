package com.devtalk.algorithm.stack;

import java.util.Stack;

public class NextGreaterElement {

	public static void main(String[] args) {
		int arr[] = { 11, 13, 21, 3 };
		int n = arr.length;
		printNGE(arr, n);
		/*
		 * 11 -- 13
			 13 -- 21
			 3 -- -1
			 21 -- -1
		 */

	}

	private static void printNGE(int[] arr, int n) {
		Stack<Integer> stk = new Stack();

		for (int a : arr) {
			if (stk.isEmpty()) {
				stk.push(a);
			}else {
				while(!stk.isEmpty() && stk.peek() < a) {
					System.out.println("Next greater of :"+ stk.pop()+ " is :" + a);
				}
				stk.push(a);
			}
		}
		while(!stk.isEmpty()) {
			System.out.println("Next greater of :"+ stk.pop()+ " is : -1");
		}

	}

}
