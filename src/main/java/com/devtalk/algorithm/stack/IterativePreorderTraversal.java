package com.devtalk.algorithm.stack;

import java.util.Stack;

public class IterativePreorderTraversal {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		preorderTraversal(root);
		// 12453

	}

	private static void preorderTraversal(Node root) {
		Stack<Node> stk = new Stack<>();
		Node curr = root;
		stk.push(curr);
		while (!stk.isEmpty()) {

			curr = stk.pop();
			System.out.println(curr.data + " ");
			if (curr.right != null) {
				stk.push(curr.right);
			}
			if (curr.left != null) {
				stk.push(curr.left);
			}

		}

	}

	

}
