package com.devtalk.algorithm.binaryTree;

public class TreeTraversals {

	public static void main(String[] args) {
		BTNode root = new BTNode(1); 
        root.left = new BTNode(2); 
        root.right = new BTNode(3); 
        root.left.left = new BTNode(4); 
        root.left.right = new BTNode(5);
		
		
		preOrder(root);
		System.out.println(" ");
		InOrder(root);
		System.out.println(" ");
		postOrder(root);

	}

	public static void preOrder(BTNode root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
	}

	public static void InOrder(BTNode root) {
		if (root == null) {
			return;
		}
		InOrder(root.left);
		System.out.print(root.data + " ");
		InOrder(root.right);
	}

	public static void postOrder(BTNode root) {
		if (root == null) {
			return;
		}
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data + " ");
	}

}
