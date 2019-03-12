package com.devtalk.algorithm.binaryTree.traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class DiagnolView {

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


		diagonalView(root);

	}

	private static void diagonalView(TreeNode root) {
		if (root == null) {
			return;
		}

		Queue<CustomNode> queue = new LinkedList<>();
		queue.add(new CustomNode(root, 0));
		queue.add(null);

		Map<Integer, List<Integer>> map = new TreeMap<>();

		while (!queue.isEmpty()) {

			CustomNode node = queue.poll();

			if (node == null) {
				queue.add(null);
				if (queue.peek() == null) {
					break;
				}
			} else {
				map.computeIfAbsent(node.horizontalDistance, k -> new ArrayList<Integer>()).add(node.node.data);
				if (node.node.left != null) {
					queue.add(new CustomNode(node.node.left, node.horizontalDistance + 1));
				}
				if (node.node.right != null) {
					queue.add(new CustomNode(node.node.right, node.horizontalDistance));
				}

			}
		}

		if (!map.isEmpty()) {
			for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
				System.out.println(
						"Diagonal :" + entry.getKey() + "    Values : " + entry.getValue().toString());
			}
		}

	}

}
