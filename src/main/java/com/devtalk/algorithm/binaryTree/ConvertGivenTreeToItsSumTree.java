package com.devtalk.algorithm.binaryTree;

public class ConvertGivenTreeToItsSumTree {

	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(-2);
		root.right = new Node(6);
		root.left.left = new Node(8);
		root.left.right = new Node(-4);
		root.right.left = new Node(7);
		root.right.right = new Node(5);

		toSumTree(root);

		// Print inorder traversal of the converted tree to test result
		// of toSumTree()
		System.out.println("Inorder Traversal of the resultant tree is:");
		inorder(root);
		//Inorder Traversal of the resultant tree is:
		// 0 4 0 20 0 12 0

	}

	private static int toSumTree(Node root) {
		if (root == null) {
			return 0;
		}
		int val = root.data;
		root.data = toSumTree(root.left) + toSumTree(root.right);
		return root.data + val;

	}

	private static void inorder(Node root) {
		if (root == null) {
			return;
		}

		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);

	}

}
