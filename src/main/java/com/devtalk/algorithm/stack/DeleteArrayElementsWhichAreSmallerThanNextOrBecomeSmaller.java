package com.devtalk.algorithm.stack;

import java.util.Stack;

public class DeleteArrayElementsWhichAreSmallerThanNextOrBecomeSmaller {

	public static void main(String[] args) {
		int arr[] = {20, 10, 25, 30, 40};
        int k = 2;
        
        deleteArrayElementsWhichAreSmallerThanNextOrBecomeSmaller(arr,k);
        
        int arr1[] = { 23, 45, 11, 77, 18};
         k = 3;
//Output      : 77, 18
         deleteArrayElementsWhichAreSmallerThanNextOrBecomeSmaller(arr1,k);

	}

	private static void deleteArrayElementsWhichAreSmallerThanNextOrBecomeSmaller(int[] arr, int k) {
		Stack<Integer> st = new Stack();
		int c = 0;
		for(int a : arr) {
			if(!st.isEmpty()) {
				while(!st.isEmpty() && a > st.peek() && c <k) {
					st.pop();
					c++;
				}
				
			}
			st.push(a);
		}
		while(!st.isEmpty()) {
			System.out.println(st.pop());
		}
		
	}

}
