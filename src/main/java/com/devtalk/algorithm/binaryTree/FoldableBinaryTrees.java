package com.devtalk.algorithm.binaryTree;

public class FoldableBinaryTrees {

	public static void main(String[] args) {
		BTNode root = new BTNode(1);
		root.left = new BTNode(2);
		root.right = new BTNode(3);
		root.right.left = new BTNode(4);
		root.left.right = new BTNode(5);

		if (isFoldable(root))
			System.out.println("tree is foldable");
		else
			System.out.println("Tree is not foldable");

	}

	private static boolean isFoldable(BTNode root) {
		if (root == null) {
			return true;
		}
		boolean result = false;

		mirror(root.left);
		result = isStructSame(root.left, root.right);
		mirror(root.left);

		return result;
	}

	private static boolean isStructSame(BTNode a, BTNode b) {
		if (a == null && b == null) {
			return true;
		}
		if (a != null && b != null && isStructSame(a.left, b.left) && isStructSame(a.right, b.right)) {
			return true;
		}
		return false;
	}

	private static void mirror(BTNode root) {
		if (root == null) {
			return;
		}
		mirror(root.left);
		mirror(root.right);

		BTNode temp = root.left;
		root.left = root.right;
		root.right = temp;
	}

}
