package com.devtalk.algorithm.doublyLinkedList;

public class TernaryTreeToListTest {
	
	public static Node head = null;
	public static Node last = null;

	public static void main(String[] args) {
		TreeNode root = new TreeNode(30);

		TreeNode left = new TreeNode(5);
		TreeNode middle = new TreeNode(11);
		TreeNode right = new TreeNode(63);

		root.left = left;
		root.middle = middle;
		root.right = right;

		left.left = new TreeNode(1);
		left.middle = new TreeNode(4);
		left.right = new TreeNode(8);

		middle.left = new TreeNode(6);
		middle.middle = new TreeNode(7);
		middle.right = new TreeNode(15);

		right.left = new TreeNode(31);
		right.middle = new TreeNode(55);
		right.right = new TreeNode(65);
		System.out.print("{");
		traverse(root);
		System.out.print("}");
		System.out.println("");
		
		convert(root);
		ListUtil.print(head);

	}

	private static void traverse(TreeNode root) {

		if (root == null) {
			return;
		}
		System.out.print(root.data + " ");
		traverse(root.left);
		traverse(root.middle);
		traverse(root.right);

	}

	private static void convert(TreeNode root) {

		if (root == null) {
			return;
		}
		if(head == null) {
			head = new Node(root.data);
			last = head;
		}else {
			Node newNode = new Node(root.data);
			last.next = newNode;
			newNode.prev = last;
			last = last.next;
		}
		convert(root.left);
		convert(root.middle);
		convert(root.right);

	}

}

class TreeNode {
	int data;
	TreeNode left;
	TreeNode middle;
	TreeNode right;

	public TreeNode(int data) {
		this.data = data;
		this.left = null;
		this.middle = null;
		this.right = null;
	}

}
