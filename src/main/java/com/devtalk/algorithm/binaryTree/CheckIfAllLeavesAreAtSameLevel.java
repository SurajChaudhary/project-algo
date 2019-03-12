package com.devtalk.algorithm.binaryTree;

public class CheckIfAllLeavesAreAtSameLevel {
	static Leaf mylevel = new Leaf();

	/*
	 * The idea is to first find level of the leftmost leaf and store it in a
	 * variable leafLevel. Then compare level of all other leaves with leafLevel, if
	 * same, return true, else return false. We traverse the given Binary Tree in
	 * Preorder fashion. An argument leaflevel is passed to all calls. The value of
	 * leafLevel is initialized as 0 to indicate that the first leaf is not yet seen
	 * yet. The value is updated when we find first leaf. Level of subsequent leaves
	 * (in preorder) is compared with leafLevel.
	 */
	public static void main(String[] args) {
		Node root = new Node(12);
		root.left = new Node(5);
		root.left.left = new Node(3);
		root.left.right = new Node(9);
		root.left.left.left = new Node(1);
		root.left.right.left = new Node(1);
		if (check(root))
			System.out.println("Leaves are at same level");
		else
			System.out.println("Leaves are not at same level");

	}

	private static boolean check(Node root) {
		int level = 0;
		return checkUtil(root, level, mylevel);
	}

	private static boolean checkUtil(Node node, int level, Leaf leafLevel) {
		// Base case
		if (node == null) {
			return false;
		}
		// If a leaf node is encountered
		if (node.left == null && node.right == null) {
			// When a leaf node is found first time
			if (leafLevel.leaflevel == 0) {
				// Set first found leaf's level
				leafLevel.leaflevel = level;
				return true;
			}
			// If this is not first leaf node, compare its level with
			// first leaf's level
			return (level == leafLevel.leaflevel);
		}
		// If this node is not leaf, recursively check left and right
		// subtrees
		boolean left = checkUtil(node.left, level + 1, leafLevel);
		boolean right = checkUtil(node.right, level + 1, leafLevel);

		return left && right;
	}

}

class Leaf {
	int leaflevel = 0;
}
