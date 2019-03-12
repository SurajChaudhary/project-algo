package com.devtalk.algorithm.binaryTree.traversal;

import java.util.Stack;

public class InOrderTraversalIterative {

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

		printInOrderIterative(root);

	}

	private static void printInOrderIterative(TreeNode root) {
		if (root == null) {
			return;
		}
		TreeNode node = root;
		Stack<TreeNode> stack = new Stack();
		while (node != null || !stack.isEmpty()) {

			while (node != null) {
				stack.push(node);
				node = node.left;
			}

			while (!stack.isEmpty()) {
				TreeNode tNode = stack.pop();
				System.out.print(tNode.data + " ");
				if (tNode.right != null) {
					node = tNode.right;
					break;
				}
			}
		}

	}

}
