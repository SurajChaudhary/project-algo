package com.devtalk.algorithm.binaryTree;

public class ConvertAGivenBinaryTreeToATreeThatHoldsLogicalANDProperty {

	public static void main(String[] args) {
		/* Create following Binary Tree  
                      1  
				    / 	 \  
			        1     0  
			       / \   / \  
			      0   1  1 1  
        */

		Node root = new Node(0);
		root.left = new Node(1);
		root.right = new Node(0);
		root.left.left = new Node(0);
		root.left.right = new Node(1);
		root.right.left = new Node(1);
		root.right.right = new Node(1);
		System.out.print("Inorder traversal before conversion ");
		printInorder(root);

		convertTree(root);
		System.out.println();
		System.out.print("Inorder traversal after conversion ");
		printInorder(root);
		
		// Inorder traversal before conversion 0 1 1 0 1 0 1 
		// Inorder traversal after conversion 0 0 1 0 1 1 1 

	}

	private static void convertTree(Node root) {
		if(root == null) {
			return;
		}
		if(root.left == null && root.right == null) {
			return;
		}
		convertTree(root.left);
		convertTree(root.right);
		if(root.left != null && root.right != null) {
			root.data = root.left.data & root.right.data ;
		}
		
	}

	private static void printInorder(Node root) {
		if (root == null) {
			return;
		}
		printInorder(root.left);
		System.out.print(root.data + " ");
		printInorder(root.right);

	}

}
