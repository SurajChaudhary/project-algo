package com.devtalk.algorithm.binaryTree;

public class CheckIfRemovingAnEdgeCanDivideABinaryTreeInTwoHalves {
	/*
	 * First count number of nodes in whole Let count of all nodes be n. Now
	 * traverse tree and for every node, find size of subtree rooted with this node.
	 * Let the subtree size be s. If n-s is equal to s, then return true, else
	 * false.
	 */
	public static void main(String[] args) {
		Node root = new Node(5);
		root.left = new Node(1);
		root.right = new Node(6);
		root.left.left = new Node(3);
		root.right.left = new Node(7);
		root.right.right = new Node(4);
		if (check(root) == true)
			System.out.println("YES");
		else
			System.out.println("NO");

	}

	private static boolean check(Node root) {
		// Count total nodes in given tree
		int n = count(root);

		// Now recursively check all nodes
		return checkRec(root, n);
	}

	private static boolean checkRec(Node node, int n) {
		// Base cases
		if (node == null) {
			return false;
		}
		// Check for root
		if (count(node) == n - count(node))
			return true;

		// Check for rest of the nodes
		return checkRec(node.left, n) || checkRec(node.right, n);
	}

	// To calculate size of tree with given root
	static int count(Node node) {
		if (node == null)
			return 0;

		return count(node.left) + count(node.right) + 1;
	}

}
