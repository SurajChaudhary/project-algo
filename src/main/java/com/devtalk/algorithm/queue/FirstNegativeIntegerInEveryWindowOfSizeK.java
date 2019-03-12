package com.devtalk.algorithm.queue;

import java.util.Deque;
import java.util.LinkedList;

public class FirstNegativeIntegerInEveryWindowOfSizeK {

	public static void main(String[] args) {
		int arr[] = { 12, -1, -7, 8, -15, 30, 16, 28 };
		int n = arr.length;
		int k = 2;
		printFirstNegativeInteger(arr, n, k);
		System.out.println(" ");
		printFirstNegativeIntegerDeque(arr, n, k);

	}

	private static void printFirstNegativeInteger(int[] arr, int n, int k) {

		for (int i = 0; i < (n - k + 1); i++) {
			boolean flag = false;

			for (int j = 0; j < k; j++) {
				if (arr[j + i] < 0) {
					System.out.print(arr[j + i] + " ");
					flag = true;
					break;
				}
			}

			if (!flag) {
				System.out.print("0 ");
			}

		}

	}

	private static void printFirstNegativeIntegerDeque(int[] arr, int n, int k) {
		Deque<Integer> deq = new LinkedList<Integer>();
		
		int i;
		for(i=0;i<k;i++) {
			if(arr[i] < 0) {
				deq.add(i);
			}
		}
		
		for(; i < n;i++) {
			
			if(!deq.isEmpty()) {
				System.out.print(arr[deq.getFirst()]+" ");
			}else {
				System.out.print("0 ");
			}
			
			while(!deq.isEmpty() && deq.getFirst() < (i-k+1)) {
				deq.pop();
			}
			
			if(arr[i] < 0) {
				deq.add(i);
			}
			
		}
		
		if(!deq.isEmpty()) {
			System.out.println(arr[deq.getFirst()]+" ");
		}else {
			System.out.print("0 ");
		}

	}

}
