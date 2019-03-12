package com.devtalk.algorithm.binaryTree.traversal;

public class LeafNodeCountInTree {

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

		int nodeCount = getLeafNodeCount(root);
		System.out.println(" ");
		System.out.println("Total leaf nodes in tree : " + nodeCount);

	}

	private static int getLeafNodeCount(TreeNode root) {
		if (root == null) {
			return 0;
		}

		if (root.left == null && root.right == null) {
			System.out.print(root.data + " ");
			return 1;
		}
		int leafNodeInLeftTree = getLeafNodeCount(root.left);
		int leafNodeInRightTree = getLeafNodeCount(root.right);
		return leafNodeInLeftTree + leafNodeInRightTree;
	}

}
