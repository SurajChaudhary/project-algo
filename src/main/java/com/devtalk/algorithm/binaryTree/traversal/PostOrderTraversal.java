package com.devtalk.algorithm.binaryTree.traversal;

import java.util.Stack;

public class PostOrderTraversal {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.left.left.left = new TreeNode(8);
		root.left.left.right = new TreeNode(9);
		root.right.right.left = new TreeNode(10);
		root.right.right.right = new TreeNode(11);

		printPostOrder(root);

	}

	private static void printPostOrder(TreeNode root) {
		if (root == null) {
			return;
		}

		printPostOrder(root.left);
		printPostOrder(root.right);
		System.out.print(root.data + " ");

	}

}
