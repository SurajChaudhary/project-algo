package com.devtalk.algorithm.binaryTree;

import java.util.Stack;

public class PrintPathFromRootToAGivenNodeInABinaryTree {
	static Stack<Node> s = new Stack<>();

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		int x = 5;
		printPath(root, x);

	}

	private static void printPath(Node root, int x) {
		if (root == null) {
			return;
		}
		s.push(root);
		if (root.data == x) {
			while (!s.isEmpty()) {
				System.out.print(s.pop().data + " ");
			}
			return;
		}
		if (root.left == null && root.right == null) {
			s.pop();
			return;
		}
		printPath(root.left, x);
		printPath(root.right, x);

	}

}
