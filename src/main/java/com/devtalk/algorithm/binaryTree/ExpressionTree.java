package com.devtalk.algorithm.binaryTree;

import java.util.Stack;

public class ExpressionTree {

	public static void main(String[] args) {
		String postfix = "ab+ef*g*-";
		Node root = constructTree(postfix);
		System.out.println("infix expression is");
		inorder(root);

	}

	private static Node constructTree(String str) {
		if (str == null || str.length() == 0) {
			return null;
		}
		char[] charArray = str.toCharArray();
		Stack<Node> st = new Stack();

		for (char c : charArray) {
			if (Character.isLetterOrDigit(c)) {
				st.push(new Node(String.valueOf(c)));
			} else {
				Node temp = new Node(String.valueOf(c));
				if (!st.isEmpty()) {
					temp.right = st.pop();
				}
				if (!st.isEmpty()) {
					temp.left = st.pop();
				}
				st.push(temp);
			}
		}
		return st.pop();
	}

	private static void inorder(Node root) {
		if (root == null) {
			return;
		}
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);

	}

	static class Node {
		String data;
		Node left;
		Node right;

		public Node(String data) {
			super();
			this.data = data;
			this.left = null;
			this.right = null;
		}

	}

}
