package com.devtalk.algorithm.binaryTree.traversal;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

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

		printLevelOrder(root);

	}

	private static void printLevelOrder(TreeNode root) {
		if (root == null) {
			return;
		}

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		queue.add(null);
		int level = 1;
		System.out.print("Level : "+level+" -> ");
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (node == null) {
				level++;
				queue.add(null);
				if (queue.peek() == null) {
					return;
				}
				System.out.println("");
				System.out.print("Level : "+level+" -> ");
			} else {
				System.out.print(node.data + " ");
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}

		}

	}

}
