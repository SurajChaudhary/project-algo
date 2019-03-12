package com.devtalk.algorithm.binaryTree.traversal;

import java.util.Stack;

public class SpiralTraversal {

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

		root.left.left.right.right = new TreeNode(12);
		root.left.left.right.right.left = new TreeNode(13);
		root.left.left.right.right.right = new TreeNode(14);

		spiralTraversal(root);
	}

	private static void spiralTraversal(TreeNode root) {
		if (root == null) {
			return;
		}

		Stack<TreeNode> stackOne = new Stack();
		Stack<TreeNode> stackTwo = new Stack();

		stackOne.push(root);

		while (!stackOne.isEmpty() || !stackTwo.isEmpty()) {

			while (!stackOne.isEmpty()) {
				TreeNode node = stackOne.pop();
				System.out.print(node.data + " ");
				if (node.left != null) {
					stackTwo.push(node.left);
				}
				if (node.right != null) {
					stackTwo.push(node.right);
				}
			}
			System.out.println(" ");
			while (!stackTwo.isEmpty()) {
				TreeNode node = stackTwo.pop();
				System.out.print(node.data + " ");
				if (node.right != null) {
					stackOne.push(node.right);
				}
				if (node.left != null) {
					stackOne.push(node.left);
				}
			}
			System.out.println(" ");

		}

	}

}
