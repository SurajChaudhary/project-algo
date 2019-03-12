package com.devtalk.algorithm.stack;

import java.util.Stack;

public class FindMaximumDifferenceBetweenNearestLeftAndRightSmallerElements {

	public static void main(String[] args) {
		int arr[] = { 2, 4, 8, 7, 7, 9, 3 };
		int diff = findMaximumDifferenceBetweenNearestLeftAndRightSmallerElements(arr);
		System.out.println(diff);

	}

	private static int findMaximumDifferenceBetweenNearestLeftAndRightSmallerElements(int[] arr) {
		int[] left = findLeftNearestMin(arr);
		arr = reverse(arr);
		int[] right = findLeftNearestMin(arr);
		right = reverse(right);
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length - 1; i++) {
			max = Math.max(max, Math.abs(left[i] - right[i]));
		}
		return max;
	}

	private static int[] reverse(int[] arr) {
		int n = arr.length - 1;
		for (int i = 0; i < n; i++, n--) {
			int temp = arr[i];
			arr[i] = arr[n];
			arr[n] = temp;
		}
		return arr;
	}

	private static int[] findLeftNearestMin(int[] arr) {
		Stack<Integer> stk = new Stack();
		int[] res = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			while (!stk.isEmpty() && stk.peek() >= arr[i]) {
				stk.pop();
			}
			if (stk.isEmpty()) {
				res[i] = 0;
			} else {
				res[i] = stk.peek();
			}
			stk.push(arr[i]);
		}
		return res;
	}

}
