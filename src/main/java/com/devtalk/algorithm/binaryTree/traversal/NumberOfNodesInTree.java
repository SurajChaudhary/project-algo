package com.devtalk.algorithm.binaryTree.traversal;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfNodesInTree {

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

		int nodeCount = getTotalNodeCount(root);
		System.out.println("Total nodes in tree : " + nodeCount);

		System.out.println(" ");

		nodeCount = getTotalNodeCountLevelOrder(root);
		System.out.println("Total nodes in tree : " + nodeCount);

	}

	private static int getTotalNodeCount(TreeNode root) {

		if (root == null) {
			return 0;
		}

		int leftCount = getTotalNodeCount(root.left);
		int rightCount = getTotalNodeCount(root.right);

		return leftCount + rightCount + 1;
	}

	private static int getTotalNodeCountLevelOrder(TreeNode root) {

		if (root == null) {
			return 0;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		int nodeCount = 0;
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			nodeCount++;
			if (node.left != null) {
				queue.add(node.left);
			}
			if (node.right != null) {
				queue.add(node.right);
			}
		}
		return nodeCount;
	}

}
