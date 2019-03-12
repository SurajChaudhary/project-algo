package com.devtalk.algorithm.binaryTree;

public class NumberOfBinaryTreesForGivenPreorderSequenceLength {

	public static void main(String[] args) {
		int n = 5;
		System.out.println("Total Possible " + "Binary Trees are : " + countTrees(n));
		System.out.println("Total Possible " + "Binary Trees Recur are : " + countTreesRecur(n));

	}

	private static int countTrees(int n) {
		int[] arr = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			arr[i] = 0;
		}

		arr[0] = 1;
		arr[1] = 1;

		for (int i = 2; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				arr[i] = arr[i] + (arr[j] * arr[i - j - 1]);
			}

		}
		return arr[n];
	}

	private static int countTreesRecur(int n) {
		if (n == 0 || n == 1) {
			return 1;
		}
		int sum = 0;
		int left, right = 0;

		for (int k = 1; k <= n; k++) {
			left = countTreesRecur(k - 1);
			right = countTreesRecur(n - k);
			sum += left * right;
		}
		return sum;

	}

}
