package com.devtalk.algorithm.binaryTree;

import java.util.Stack;

public class IterativePreorderTraversal {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(10);
		tree.root.left = new Node(8);
		tree.root.right = new Node(2);
		tree.root.left.left = new Node(3);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(2);
		iterativePreorder(tree.root);
		// 10 8 3 5 2 2
		System.out.println("");
		iterativePostorder(tree.root);
		System.out.println("");
		iterativePostorderWithOneStack(tree.root);
	}

	private static void iterativePreorder(Node root) {
		if (root == null) {
			return;
		}
		Stack<Node> st = new Stack();
		st.push(root);

		while (!st.isEmpty()) {
			Node curr = st.pop();
			System.out.print(curr.data + " ");
			if (curr.right != null) {
				st.push(curr.right);
			}
			if (curr.left != null) {
				st.push(curr.left);
			}
		}

	}

	private static void iterativePostorder(Node root) {
		if (root == null) {
			return;
		}
		Stack<Node> st = new Stack();
		Stack<Node> s = new Stack();
		st.push(root);

		while (!st.isEmpty()) {
			Node curr = st.pop();
			s.push(curr);
			if (curr.left != null) {
				st.push(curr.left);
			}
			if (curr.right != null) {
				st.push(curr.right);
			}
		}
		while (!s.isEmpty()) {
			System.out.print(s.pop().data + " ");
		}

	}

	private static void iterativePostorderWithOneStack(Node root) {
		if (root == null) {
			return;
		}
		Stack<Node> stack = new Stack();
		while (true) {
			while (root != null) {
				stack.push(root);
				stack.push(root);
				root = root.left;
			}

			// Check for empty stack
			if (stack.empty())
				return;
			root = stack.pop();

			if (!stack.empty() && stack.peek() == root)
				root = root.right;

			else {

				System.out.print(root.data + " ");
				root = null;
			}
		}

	}

}
