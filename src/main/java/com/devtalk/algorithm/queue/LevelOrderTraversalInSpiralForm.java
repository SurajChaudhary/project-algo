package com.devtalk.algorithm.queue;

public class LevelOrderTraversalInSpiralForm {

	public static void main(String[] args) {
		Node root = createTree();

		breadthFirstSpiralTraversal(root);

	}

	private static void breadthFirstSpiralTraversal(Node root) {
		int height = getHeight(root);
		boolean flag = true;
		for (int level = 0; level <= height; level++) {
			printSpiral(root, level, flag);
			System.out.println(" ");
			flag = !flag;
		}

	}

	private static void printSpiral(Node root, int level, boolean flag) {
		if (root == null) {
			return;
		}
		if (level == 1) {
			System.out.print(root.data);
		} else {
			if (flag) {
				printSpiral(root.left, level - 1, flag);
				printSpiral(root.right, level - 1, flag);
			} else {
				printSpiral(root.right, level - 1, flag);
				printSpiral(root.left, level - 1, flag);
			}
		}

	}

	private static int getHeight(Node root) {
		if (root == null) {
			return 0;
		}

		int leftHeight = getHeight(root.left);
		int rightHeight = getHeight(root.right);

		if (leftHeight > rightHeight) {
			return leftHeight + 1;
		} else {
			return rightHeight + 1;
		}
	}

	private static Node createTree() {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);

		root.left.left = new Node(4);
		root.left.right = new Node(5);

		root.right.left = new Node(6);
		root.right.right = new Node(7);

		root.left.left.left = new Node(8);
		root.left.right.right = new Node(9);

		root.right.right.left = new Node(10);

		root.right.right.left.left = new Node(11);
		root.right.right.left.right = new Node(12);
		return root;
	}

	static class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}

	}

}
