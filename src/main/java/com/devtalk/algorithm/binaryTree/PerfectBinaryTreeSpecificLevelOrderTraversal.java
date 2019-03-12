package com.devtalk.algorithm.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class PerfectBinaryTreeSpecificLevelOrderTraversal {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);

		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);

		tree.root.left.left.left = new Node(8);
		tree.root.left.left.right = new Node(9);
		tree.root.left.right.left = new Node(10);
		tree.root.left.right.right = new Node(11);
		tree.root.right.left.left = new Node(12);
		tree.root.right.left.right = new Node(13);
		tree.root.right.right.left = new Node(14);
		tree.root.right.right.right = new Node(15);

		tree.root.left.left.left.left = new Node(16);
		tree.root.left.left.left.right = new Node(17);
		tree.root.left.left.right.left = new Node(18);
		tree.root.left.left.right.right = new Node(19);
		tree.root.left.right.left.left = new Node(20);
		tree.root.left.right.left.right = new Node(21);
		tree.root.left.right.right.left = new Node(22);
		tree.root.left.right.right.right = new Node(23);
		tree.root.right.left.left.left = new Node(24);
		tree.root.right.left.left.right = new Node(25);
		tree.root.right.left.right.left = new Node(26);
		tree.root.right.left.right.right = new Node(27);
		tree.root.right.right.left.left = new Node(28);
		tree.root.right.right.left.right = new Node(29);
		tree.root.right.right.right.left = new Node(30);
		tree.root.right.right.right.right = new Node(31);

		System.out.println("Specific Level Order traversal of binary" + "tree is ");
		printSpecificLevelOrder(tree.root);

	}

	private static void printSpecificLevelOrder(Node root) {
		if (root == null) {
			return;
		}
		System.out.println(" "+root.data);
		if (root.left != null) {
			System.out.println(" "+root.left.data + " " + root.right.data);
		} else {
			return;
		}
		if (root.left.left == null) {
			return;
		}

		// Create a queue and enqueue left and right children of root
		Queue<Node> q = new LinkedList();
		q.add(root.left);
		q.add(root.right);

		// We process two nodes at a time, so we need two variables
		// to store two front items of queue
		Node first = null, second = null;

		// traversal loop
		while (!q.isEmpty()) {
			// Pop two items from queue
			first = q.peek();
			q.remove();
			second = q.peek();
			q.remove();

			// Print children of first and second in reverse order
			System.out.print(" "+first.left.data + " " + second.right.data);
			System.out.print(" "+first.right.data + " " + second.left.data);
			System.out.println("");

			// If first and second have grand children, enqueue them
			// in reverse order
			if (first.left.left != null) {
				q.add(first.left);
				q.add(second.right);
				q.add(first.right);
				q.add(second.left);
			}
		}

	}

}
