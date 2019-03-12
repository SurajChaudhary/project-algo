package com.devtalk.algorithm.binaryTree;

public class CheckForChildrenSumPropertyInBinaryTree {

	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(8);
		root.right = new Node(2);
		root.left.left = new Node(3);
		root.left.right = new Node(5);
		root.right.right = new Node(2);
		if (isSumProperty(root))
			System.out.println("The given tree satisfies children" + " sum property");
		else
			System.out.println("The given tree does not satisfy children" + " sum property");

	}

	private static boolean isSumProperty(Node root) {
		if (root == null || (root.left == null && root.right == null)) {
			return true;
		}
		int leftData = 0;
		int rightData = 0;
		if (root.left != null)
			leftData = root.left.data;
		if (root.right != null)
			rightData = root.right.data;

		if (root.data == (leftData + rightData) && isSumProperty(root.left) && isSumProperty(root.right)) {
			return true;
		}
		return false;

	}

}
