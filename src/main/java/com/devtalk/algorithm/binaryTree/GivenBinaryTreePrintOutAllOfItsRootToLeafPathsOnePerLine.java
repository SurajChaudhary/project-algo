package com.devtalk.algorithm.binaryTree;

import java.util.Stack;

public class GivenBinaryTreePrintOutAllOfItsRootToLeafPathsOnePerLine {
	static Stack<Node> stk = new Stack();

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);

		/* Print all root-to-leaf paths of the input tree */
		printPaths(root);

	}

	private static void printPaths(Node root) {
		int path[] = new int[1000];
		printPathsRecur(root, path, 0);

	}

	private static void printPathsRecur(Node node, int path[], int pathLen) {
		if (node == null) {
			return;
		}
		path[pathLen] = node.data;
		pathLen++;
		/* it's a leaf, so print the path that led to here */
		if (node.left == null && node.right == null) {
			printArray(path, pathLen);
		} else {
			/* otherwise try both subtrees */
			printPathsRecur(node.left, path, pathLen);
			printPathsRecur(node.right, path, pathLen);
		}

	}

	private static void printArray(int ints[], int len) {
		for (int i = 0; i < len; i++) {
			System.out.print(ints[i] + " ");
		}
		System.out.println("");
	}

}
