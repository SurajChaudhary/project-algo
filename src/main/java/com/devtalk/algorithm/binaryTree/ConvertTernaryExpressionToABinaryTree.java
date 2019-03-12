package com.devtalk.algorithm.binaryTree;

import com.devtalk.algorithm.binaryTree.ConstructTreeFromGivenInorderAndPreorderTraversals.CharNode;

public class ConvertTernaryExpressionToABinaryTree {

	public static void main(String[] args) {
		String exp = "a?b?c:d:e";
		char[] expression = exp.toCharArray();
		CharNode root = convertExpression(expression, 0);
		printTree(root);

	}

	private static CharNode convertExpression(char[] expression, int i) {
		if (expression == null) {
			return null;
		}
		// Base case
		if (i >= expression.length) {
			return null;
		}

		// store current character of expression_string
		// [ 'a' to 'z']
		CharNode root = new CharNode(expression[i]);
		// Move ahead in str
		i++;

		// if current character of ternary expression is '?'
		// then we add next character as a left child of
		// current node
		if (i < expression.length && expression[i] == '?') {
			root.left = convertExpression(expression, i + 1);
		}
		// else we have to add it as a right child of
		// current node expression.at(0) == ':'
		else if (i < expression.length) {
			root.right = convertExpression(expression, i + 1);
		}
		return root;
	}

	private static void printTree(CharNode root) {
		if (root == null) {
			return;
		}

		System.out.print(root.data + " ");
		printTree(root.left);

		printTree(root.right);

	}

}
