package com.devtalk.algorithm.binaryTree.traversal;

import java.util.Stack;

public class PostOrderTraversalIterative {

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

		printPostOrderIterative(root);

	}

	private static void printPostOrderIterative(TreeNode root) {
		if (root == null) {
			return;
		}

		Stack<TreeNode> stack1 = new Stack();
		Stack<TreeNode> stack2 = new Stack();

		TreeNode node = root;

		while (node != null || !stack1.isEmpty()) {

			while (node != null) {
				stack1.push(node);
				stack2.push(node);
				node = node.right;
			}

			while (!stack1.isEmpty()) {
				TreeNode temp = stack1.pop();
				if (temp.left != null) {
					node = temp.left;
					break;
				}
			}

		}

		while (!stack2.isEmpty()) {
			System.out.print(stack2.pop().data + " ");
		}

	}

}
