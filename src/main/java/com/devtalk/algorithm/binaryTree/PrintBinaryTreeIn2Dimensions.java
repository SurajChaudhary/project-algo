package com.devtalk.algorithm.binaryTree;

public class PrintBinaryTreeIn2Dimensions {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);

		printIn2Dimention(root, 0);

	}

	private static void printIn2Dimention(Node root, int space) {
		if (root == null) {
			return;
		}

		space += 10;
		printIn2Dimention(root.right, space);
		System.out.println(" ");
		for (int i = 10; i < space; i++) {
			System.out.print(" ");
		}
		System.out.print(root.data);
		printIn2Dimention(root.left, space);

	}

}
