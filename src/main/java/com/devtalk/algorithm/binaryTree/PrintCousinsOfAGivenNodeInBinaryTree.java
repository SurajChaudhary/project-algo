package com.devtalk.algorithm.binaryTree;

public class PrintCousinsOfAGivenNodeInBinaryTree {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.right.right = new Node(15);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.right.left.right = new Node(8);

		printCousins(root, root.left.right);
		int k = 2;
		System.out.println("");
		printNodesAtkDistanceFromRoot(root, k);

	}

	private static void printCousins(Node root, Node node) {
		int level = getLevel(root, node);
		// Print nodes of given level.
		printGivenLevel(root, node, level);

	}

	private static void printGivenLevel(Node root, Node node, int level) {
		// Base cases
		if (root == null || level < 2) {
			return;
		}
		// If current node is parent of a node with
		// given level
		if (level == 2) {
			if (root.left == node || root.right == node) {
				return;
			}
			if (root.left != null) {
				System.out.print(root.left.data + " ");
			}
			if (root.right != null) {
				System.out.print(root.right.data + " ");
			}
		} else if (level > 2) {// Recur for left and right subtrees
			printGivenLevel(root.left, node, level - 1);
			printGivenLevel(root.right, node, level - 1);
		}

	}

	private static void printNodesAtkDistanceFromRoot(Node root, int k) {
		if (root == null) {
			return;
		}
		if (k == 0) {
			System.out.print(root.data + " ");
		} else {
			printNodesAtkDistanceFromRoot(root.left, k - 1);
			printNodesAtkDistanceFromRoot(root.right, k - 1);
		}

	}

	private static int getLevel(Node root, Node node) {
		int level = 1;
		return getLevelUtil(root, node, level);
	}

	private static int getLevelUtil(Node root, Node node, int level) {
		if (root == null) {
			return 0;
		}
		if (root.data == node.data) {
			return level;
		}

		int leftLevel = getLevelUtil(root.left, node, level + 1);
		if (leftLevel != 0) {
			return leftLevel;
		}
		int rightLevel = getLevelUtil(root.right, node, level + 1);
		return rightLevel;

	}

}
