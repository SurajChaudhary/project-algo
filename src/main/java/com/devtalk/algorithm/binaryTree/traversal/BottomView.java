package com.devtalk.algorithm.binaryTree.traversal;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BottomView {

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

		bottomView(root);

	}
	
	private static void bottomView(TreeNode root) {
		if (root == null) {
			return;
		}
		Map<Integer, TreeNode> nodeMap = new TreeMap();

		Queue<CustomNode> queue = new LinkedList();
		queue.add(new CustomNode(root, 0));

		while (!queue.isEmpty()) {
			CustomNode node = queue.poll();
			nodeMap.put(node.horizontalDistance, node.node);
			if (node.node.left != null) {
				queue.add(new CustomNode(node.node.left, node.horizontalDistance - 1));
			}
			if (node.node.right != null) {
				queue.add(new CustomNode(node.node.right, node.horizontalDistance + 1));
			}
		}
		for (Map.Entry<Integer, TreeNode> entry : nodeMap.entrySet()) {
			System.out.print(entry.getValue().data + " ");
		}

	}

}
