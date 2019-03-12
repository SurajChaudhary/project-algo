package com.devtalk.algorithm.number;

import java.util.Arrays;

public class ReplaceNumberWithGreatestNumberToTheRightTest {

	public static void main(String[] args) {
		int[] arr = { 5, 7, 20, 9, 15, 6, 3, 9 };
		System.out.println("Length : " + arr.length);
		System.out.println(Arrays.toString(arr));
		replaceWithGreatestInRight(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void replaceWithGreatestInRight(int[] arr) {
		int maxFromRight = Integer.MIN_VALUE;
		int last = arr.length - 1;
		for (int i = last; i >= 0; i--) {
			if(arr[i] < maxFromRight) {
				arr[i] = maxFromRight;
			}else {
				maxFromRight = arr[i];
			}
		}
	}

}
