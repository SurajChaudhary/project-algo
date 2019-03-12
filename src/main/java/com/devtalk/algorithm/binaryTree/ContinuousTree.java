package com.devtalk.algorithm.binaryTree;

public class ContinuousTree {

	public static void main(String[] args) {
		BTNode root = new BTNode(3);
		root.left = new BTNode(2);
		root.right = new BTNode(4);
		root.left.left = new BTNode(1);
		root.left.right = new BTNode(3);
		root.right.right = new BTNode(5);
		if (treeContinuous(root))
			System.out.println("Yes");
		else
			System.out.println("No");

	}

	private static boolean treeContinuous(BTNode root) {
		if (root == null) {
			return true;
		}
		if (root.left == null && root.right == null) {
			return true;
		}

		if (root.left == null) {
			return (Math.abs(root.data - root.right.data) == 1 && treeContinuous(root.right));
		}

		if (root.right == null) {
			return (Math.abs(root.data - root.left.data) == 1 && treeContinuous(root.left));
		}

		return (Math.abs(root.data - root.left.data) == 1 && Math.abs(root.data - root.right.data) == 1
				&& treeContinuous(root.left) && treeContinuous(root.right));
	}

}
