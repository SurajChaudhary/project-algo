package com.devtalk.algorithm.linkedList;

public class Sort0s1sAnd2sTest {

	public static void main(String[] args) {
		Node root = ListUtil.getList(0, 1, 1, 2, 0, 0, 1, 0, 1, 2, 2, 0, 2, 2, 1, 2, 0);
		ListUtil.print(root);

		sortListFor0s1sAnd2s(root);

		ListUtil.print(root);

	}

	private static void sortListFor0s1sAnd2s(Node root) {

		// Array to hold count of 0s, 1s and 2s
		int[] countArray = { 0, 0, 0 };

		Node curr = root;

		// Counting and storing counts for 0s, 1s and 2s
		while (curr != null) {
			countArray[curr.data]++;
			curr = curr.nextNode;

		}

		// Index to keep track index of countArray
		int i = 0;

		curr = root;
		// Iterating whole list to replace node data with 0s, 1s and 2s as per count
		// Array.
		while (curr != null) {

			// Checking if value of array is 0, then move to next index.
			if (countArray[i] == 0) {
				// Increasing index once value at this index reaches 0.
				i++;
			} else {
				// Setting value from array
				curr.data = i;
				// Decreasing the count at index, but keeping index same.
				countArray[i]--;
				curr = curr.nextNode;
			}

		}

	}

}
