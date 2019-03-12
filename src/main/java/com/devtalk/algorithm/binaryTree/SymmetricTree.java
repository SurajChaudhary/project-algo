package com.devtalk.algorithm.binaryTree;

public class SymmetricTree {

	public static void main(String[] args) {
		BTNode root = new BTNode(1);
		root.left = new BTNode(2);
		root.right = new BTNode(2);
		root.left.left = new BTNode(3);
		root.left.right = new BTNode(4);
		root.right.left = new BTNode(4);
		root.right.right = new BTNode(3);
		boolean output = isSymmetric(root);
		if (output == true)
			System.out.println("1");
		else
			System.out.println("0");

	}

	private static boolean isSymmetric(BTNode root) {
		// Tree is symmetric if it is Mirror Image of itself
		return isMirror(root, root);
	}

	private static boolean isMirror(BTNode r1, BTNode r2) {
		if (r1 == null && r2 == null) {
			return true;
		}
		
		if (r1 != null && r2 != null &&
				r1.data == r2.data && 
				isMirror(r1.left, r2.right) && 
				isMirror(r1.right, r2.left)) {
			return true;
		}

		return false;
	}

}
