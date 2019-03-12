package com.devtalk.algorithm.binaryTree;

public class PopulateInorderSuccessorForAllNodes {
	private static Node next = null;

	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(8);
		root.right = new Node(12);
		root.left.left = new Node(3);
		inorder(root);
		// Populates nextRight pointer in all nodes
		populateNext(root);

		inorder(root);

	}

	private static void inorder(Node root) {
		if(root == null) {
			return;
		}
		inorder(root.left);
		int data = root.data;
		int next = root.next != null ? root.next.data : -1;
		System.out.println("Data :"+data+" Next :"+next);
		inorder(root.right);
		
	}

	private static void populateNext(Node root ) {
		if (root == null) {
			return;
		}

		populateNext(root.right);
		root.next = next;
		next = root;
		populateNext(root.left);

	}

	static class Node {
		int data;
		Node left, right, next;

		Node(int item) {
			data = item;
			left = null;
			right = null;
			next = null;
		}
	}

}
