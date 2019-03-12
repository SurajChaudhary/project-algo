package com.devtalk.algorithm.binaryTree;

public class ConvertBinaryTreeIntoMirrorTree {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);

		/* print inorder traversal of the input tree */
		System.out.println("Inorder traversal of input tree is :");
		inOrder(root);
		System.out.println("");

		/* convert tree to its mirror */
		mirror(root);

		/* print inorder traversal of the minor tree */
		System.out.println("Inorder traversal of binary tree is : ");
		inOrder(root);
		
		/*
		 * Inorder traversal of the constructed tree is 
			4 2 5 1 3 
			Inorder traversal of the mirror tree is 
			3 1 5 2 4 
		 */

	}

	private static void mirror(Node root) {
		if (root == null) {
			return;
		}

		mirror(root.left);
		mirror(root.right);
		Node temp = root.left;
		root.left = root.right;
		root.right = temp;

	}

	private static void inOrder(Node root) {
		if (root == null) {
			return;
		}

		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);

	}

}
