package com.devtalk.algorithm.stack;

import java.util.Stack;

public class IterativePostorderTraversal {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		postorderTraversal(root);
		// [4, 5, 2, 6, 7, 3, 1]
		System.out.println("#######");
		postorderTraversal2(root);
	}

	private static void postorderTraversal(Node root) {
		Stack<Node> stk = new Stack();
		Node curr = root;
		while (curr != null || stk.size() > 0) {
			while (curr != null) {
				if (curr.right != null) {
					stk.push(curr.right);
				}
				stk.push(curr);
				curr = curr.left;
			}

			curr = stk.pop();
			if (curr.right != null && !stk.isEmpty() && stk.peek() == curr.right) {
				Node temp = stk.pop();
				stk.push(curr);
				curr = temp;

			} else {
				System.out.print(curr.data + " ");
				curr = null;
			}
		}

	}

	private static void postorderTraversal2(Node root) {
		Stack<Node> stk1 = new Stack();
		Stack<Node> stk2 = new Stack();

		stk1.push(root);
		while (!stk1.isEmpty()) {
			Node curr = stk1.pop();
			if (curr.left != null)
				stk1.push(curr.left);
			if (curr.right != null)
				stk1.push(curr.right);
			stk2.push(curr);
		}
		while(!stk2.isEmpty()) {
			System.out.print(stk2.pop().data + " ");
		}

	}

}
