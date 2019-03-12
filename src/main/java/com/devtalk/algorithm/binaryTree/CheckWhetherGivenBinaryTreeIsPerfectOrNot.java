package com.devtalk.algorithm.binaryTree;

public class CheckWhetherGivenBinaryTreeIsPerfectOrNot {
	/**
	 * A Perfect Binary Tree of height h (where height is number of nodes on path
	 * from root to leaf) has 2h – 1 nodes.
	 * 
	 * Below is an idea to check whether a given Binary Tree is perfect or not.
	 * 
	 * Find depth of any node (in below tree we find depth of leftmost node). Let
	 * this depth be d. Now recursively traverse the tree and check for following
	 * two conditions. Every internal node should have both children non-empty All
	 * leaves are at depth ‘d’
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Node root = null;
		root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);

		root.left.left = new Node(40);
		root.left.right = new Node(50);
		root.right.left = new Node(60);
		root.right.right = new Node(70);

		if (isPerfect(root) == true)
			System.out.println("Yes");
		else
			System.out.println("No");

	}

	private static boolean isPerfect(Node root) {
		int depth = getDepth(root);
		int level = 0;
		return isPerfectRec(root, depth, level);
	}

	/*
	 * This function tests if a binary tree is perfect or not. It basically checks
	 * for two things : 1) All leaves are at same level 2) All internal nodes have
	 * two children
	 */
	private static boolean isPerfectRec(Node root, int depth, int level) {
		// An empty tree is perfect
		if (root == null) {
			return true;
		}
		// If leaf node, then its depth must be same as
		// depth of all other leaves.
		if (root.left == null && root.right == null) {
			return (depth == level + 1);
		}
		// If internal node and one child is empty
		if (root.left == null || root.right == null) {
			return false;
		}
		// Left and right subtrees must be perfect.
		return isPerfectRec(root.left, depth, level + 1) && isPerfectRec(root.right, depth, level + 1);
	}

	private static int getDepth(Node root) {
		int d = 0;
		while (root != null) {
			d++;
			root = root.left;
		}
		return d;
	}

}
