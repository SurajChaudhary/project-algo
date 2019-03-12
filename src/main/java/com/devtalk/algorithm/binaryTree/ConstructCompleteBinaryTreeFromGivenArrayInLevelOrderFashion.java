package com.devtalk.algorithm.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class ConstructCompleteBinaryTreeFromGivenArrayInLevelOrderFashion {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6, 6, 6, 6 };
		TreeNode root = insertLevelOrder(arr);
		inOrder(root);

	}

	private static void inOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);

	}

	private static TreeNode insertLevelOrder(int[] arr) {
		if (arr == null || arr.length == 0) {
			return null;
		}

		TreeNode root = new TreeNode(arr[0]);

		Queue<TreeNode> q = new LinkedList();
		q.add(root);

		for (int i = 1; i < arr.length;) {
			TreeNode parent = q.poll();
			if (i < arr.length) {
				TreeNode left = new TreeNode(arr[i]);
				parent.left = left;
				q.add(left);
				i++;
			}
			if (i < arr.length) {
				TreeNode right = new TreeNode(arr[i]);
				parent.right = right;
				q.add(right);
				i++;
			}

		}

		return root;
	}

}
