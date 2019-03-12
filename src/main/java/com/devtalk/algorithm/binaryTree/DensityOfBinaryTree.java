package com.devtalk.algorithm.binaryTree;

public class DensityOfBinaryTree {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);

		System.out.println("Density of given Binary Tree is : " + density(tree.root));

	}

	private static float density(Node root) {
		if (root == null) {
			return 0;
		}
		Size size = new Size();
		int height = getHeightAndSize(root, size);
		System.out.println("Height :" + height + " Size :" + size.size);

		return (float) size.size / height;
	}

	private static int getHeightAndSize(Node root, Size size) {

		if (root == null) {
			return 0;
		}
		int left = getHeightAndSize(root.left, size);
		int right = getHeightAndSize(root.right, size);
		size.size++;
		if (left > right) {
			return left + 1;
		} else {
			return right + 1;
		}
	}

}

class Size {
	int size;
}
