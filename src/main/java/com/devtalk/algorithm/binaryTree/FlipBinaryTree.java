package com.devtalk.algorithm.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class FlipBinaryTree {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.right.left = new Node(4);
		root.right.right = new Node(5);
		System.out.println("Level order traversal of given tree");
		printLevelOrder(root);
		System.out.println(" ");
		root = flipBinaryTree(root);
		System.out.println("Level order traversal of flipped tree");
		printLevelOrder(root);

	}

	private static Node flipBinaryTree(Node root) {
		if (root == null) {
			return root;
		}
		if (root.left == null && root.right == null) {
			return root;
		}
		Node flipedNode = flipBinaryTree(root.left);
		root.left.left = root.right;
		root.left.right = root;
		root.left = root.right = null;
		return flipedNode;
	}

	private static void printLevelOrder(Node root) {
		if (root == null) {
			return;
		}

		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);

		while (!queue.isEmpty()) {
			Node temp = queue.poll();
			System.out.print(temp.data + " ");
			if (temp.left != null) {
				queue.add(temp.left);
			}
			if (temp.right != null) {
				queue.add(temp.right);
			}
		}

	}

}
