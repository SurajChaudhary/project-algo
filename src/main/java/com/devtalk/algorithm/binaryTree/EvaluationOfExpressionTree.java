package com.devtalk.algorithm.binaryTree;

import com.devtalk.algorithm.binaryTree.ExpressionTree.Node;

public class EvaluationOfExpressionTree {

	public static void main(String[] args) {
		// create a syntax tree
		Node root = new Node("+");
		root.left = new Node("*");
		root.left.left = new Node("5");
		root.left.right = new Node("4");
		root.right = new Node("-");
		root.right.left = new Node("100");
		root.right.right = new Node("20");
		System.out.println(eval(root));

		root = new Node("+");
		root.left = new Node("*");
		root.left.left = new Node("5");
		root.left.right = new Node("4");
		root.right = new Node("-");
		root.right.left = new Node("100");
		root.right.right = new Node("/");
		root.right.right.left = new Node("20");
		root.right.right.right = new Node("2");

		System.out.println(eval(root));
	}

	private static int eval(Node root) {
		if (root == null) {
			return 0;
		}

		if (root.left == null && root.right == null) {
			return Integer.parseInt(root.data);
		}

		int left = eval(root.left);
		int right = eval(root.right);

		switch (root.data) {
		case "+":
			return left + right;
		case "-":
			return left - right;
		case "*":
			return left * right;
		}
		return left / right;
		
	}

}
