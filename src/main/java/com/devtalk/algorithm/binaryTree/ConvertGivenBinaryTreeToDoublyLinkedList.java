package com.devtalk.algorithm.binaryTree;

public class ConvertGivenBinaryTreeToDoublyLinkedList {
	static com.devtalk.algorithm.doublyLinkedList.Node head = null;
	static com.devtalk.algorithm.doublyLinkedList.Node last = null;
	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(12);
		root.right = new Node(15);
		root.left.left = new Node(25);
		root.left.right = new Node(30);
		root.right.left = new Node(36);

		// Convert to DLL
		bintree2list(root);

		// Print the converted list
		printList(head);
		//25 12 30 10 36 15
	}

	private static void printList(com.devtalk.algorithm.doublyLinkedList.Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}

	}

	private static void bintree2list(Node root) {
		if (root == null) {
			return;
		}

		bintree2list(root.left);
		if(head == null) {
			head = new com.devtalk.algorithm.doublyLinkedList.Node(root.data);
			last = head;
		}else {
			last.next = new com.devtalk.algorithm.doublyLinkedList.Node(root.data);
			last.next.prev = last;
			last = last.next;
		}
		bintree2list(root.right);

	}

}
