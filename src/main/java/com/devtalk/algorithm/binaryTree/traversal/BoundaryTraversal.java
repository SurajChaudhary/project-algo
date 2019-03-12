package com.devtalk.algorithm.binaryTree.traversal;

public class BoundaryTraversal {

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

		boundaryTraversal(root);

	}

	private static void boundaryTraversal(TreeNode root) {
		if (root == null) {
			return;
		}

		printLeftNodesExceptLeaf(root);
		printLeafNodes(root);
		printreverseRightNodesExceptLeafAndRoot(root.right);

	}

	private static void printreverseRightNodesExceptLeafAndRoot(TreeNode root) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			return;
		}
		printreverseRightNodesExceptLeafAndRoot(root.right);
		System.out.print(root.data+" ");
		
	}

	private static void printLeafNodes(TreeNode root) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			System.out.print(root.data+ " ");
		}
		printLeafNodes(root.left);
		printLeafNodes(root.right);

	}

	private static void printLeftNodesExceptLeaf(TreeNode root) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			return;
		}
		System.out.print(root.data + " ");
		printLeftNodesExceptLeaf(root.left);

	}

}
