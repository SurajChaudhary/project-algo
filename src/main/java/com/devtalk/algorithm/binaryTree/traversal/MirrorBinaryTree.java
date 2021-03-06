package com.devtalk.algorithm.binaryTree.traversal;

public class MirrorBinaryTree {

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
		printInOrder(root);
		mirrorTree(root);
		System.out.println(" ");
		printInOrder(root);

	}

	private static void mirrorTree(TreeNode root) {
		if (root == null) {
			return;
		}
		mirrorTree(root.left);
		mirrorTree(root.right);
		TreeNode temp = root.right;
		root.right = root.left;
		root.left = temp;
	}

	private static void printInOrder(TreeNode root) {
		if (root == null) {
			return;
		}

		printInOrder(root.left);
		System.out.print(root.data + " ");
		printInOrder(root.right);

	}

}
