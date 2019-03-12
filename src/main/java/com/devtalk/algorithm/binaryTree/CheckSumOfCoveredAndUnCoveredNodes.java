package com.devtalk.algorithm.binaryTree;

public class CheckSumOfCoveredAndUnCoveredNodes {
	public static void main(String[] args) {
		Node root = new Node(8);
		root.left = new Node(3);
		root.left.left = new Node(1);
		root.left.right = new Node(6);
		root.left.right.left = new Node(4);
		root.left.right.right = new Node(7);

		root.right = new Node(10);
		root.right.right = new Node(14);
		root.right.right.left = new Node(13);

		if (isSumSame(root))
			System.out.println("Sum of covered and uncovered is same");
		else
			System.out.println("Sum of covered and uncovered is not same");
	}

	private static boolean isSumSame(Node root) {
		// Sum of uncovered elements
		int sumUC = uncoverSum(root);

		// Sum of all elements
		int sumT = getSum(root);

		// Check if sum of covered and uncovered is same
		return (sumUC == (sumT - sumUC));
	}

	private static int uncoveredSumLeft(Node root) {
		if (root == null) {
			return 0;
		}
		if (root.left != null) {
			return root.data + uncoveredSumLeft(root.left);
		} else {
			return root.data + uncoveredSumLeft(root.right);
		}
	}

	private static int uncoveredSumRight(Node root) {
		if (root == null) {
			return 0;
		}
		if (root.right != null) {
			return root.data + uncoveredSumLeft(root.right);
		} else {
			return root.data + uncoveredSumLeft(root.left);
		}
	}

	// Returns sum of uncovered elements
	static int uncoverSum(Node t) {
		/*
		 * Initializing with 0 in case we don't have left or right boundary
		 */
		int lb = 0, rb = 0;

		if (t.left != null)
			lb = uncoveredSumLeft(t.left);
		if (t.right != null)
			rb = uncoveredSumRight(t.right);

		/*
		 * returning sum of root node, left boundry and right boundry
		 */
		return t.data + lb + rb;
	}

	static int getSum(Node root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return root.data;
		}

		return root.data + getSum(root.left) + getSum(root.right);
	}
}
