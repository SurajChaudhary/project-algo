package com.devtalk.algorithm.binaryTree.traversal;

import java.util.LinkedList;
import java.util.Queue;

public class RightView {

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

		rightView(root);

	}

	private static void rightView(TreeNode root) {

		if (root == null) {
			return;
		}

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		queue.add(null);
		int level = 0;
		while (!queue.isEmpty()) {
			int count = queue.size();
			System.out.print("Level : " + level + "  data : ");
			level++;
			while (count > 0) {
				TreeNode node = queue.poll();
				count--;
				if (node == null) {
					count--;
					System.out.println(" ");
					queue.add(null);
					if (queue.peek() == null) {
						return;
					}
				} else {
					if (count == 1) {
						System.out.print(node.data + " ");
					}
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

}
