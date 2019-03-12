package com.devtalk.algorithm.binaryTree;

import java.util.HashMap;
import java.util.Map;

public class PrintPostorderTraversalFromGivenInorderAndPreorderTraversals {
	static int preIndex = 0;

	public static void main(String[] args) {
		int in[] = { 4, 2, 5, 1, 3, 6 };
		int pre[] = { 1, 2, 4, 5, 3, 6 };
		printPostMain(in, pre);

	}

	private static void printPostMain(int[] in, int[] pre) {
		int n = pre.length;
		Map<Integer, Integer> hm = new HashMap();
		for (int i = 0; i < n; i++) {
			hm.put(in[i], i);
		}

		printPost(in, pre, 0, n - 1, hm);

	}

	private static void printPost(int[] in, int[] pre, int inStrt, int inEnd, Map<Integer, Integer> hm) {
		if (inStrt > inEnd) {
			return;
		}
		// Find index of next item in preorder traversal in inorder.
		int inIndex = hm.get(pre[preIndex++]);
		// traverse left tree
		printPost(in, pre, inStrt, inIndex - 1, hm);

		// traverse right tree
		printPost(in, pre, inIndex + 1, inEnd, hm);

		// print root node at the end of traversal
		System.out.print(in[inIndex] + " ");

	}

}
