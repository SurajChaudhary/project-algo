package com.devtalk.algorithm.circularLinkedList;

import com.devtalk.algorithm.binaryTree.BTNode;
import com.devtalk.algorithm.doublyLinkedList.Node;

public class TreeToCircularDoublyLinkListTest {
	
	static Node start = null;
	static Node last = null;

	public static void main(String[] args) {
		BTNode root = new BTNode(1);
		root.left = new BTNode(2);
		root.right = new BTNode(3);
		root.left.left = new BTNode(4);
		root.left.right = new BTNode(5);
		root.right.left = new BTNode(6);
		root.right.right = new BTNode(7);
		
		
		
		printInOrderTraversal(root);
		
		convert(root);
		last.next = start;
		start.prev = last;
		System.out.println("");
		ListUtil.print(start);

	}
	
	private static void convert(BTNode root) {
		if(root == null) {
			return;
		}
		convert(root.left);
		
		if(start == null) {
			start = new Node(root.data);
			last = start;
		}else {
			Node newNode = new Node(root.data);
			last.next = newNode;
			newNode.prev = last;
			last = last.next;
		}
		
		convert(root.right);
	}

	private static void printInOrderTraversal(BTNode root) {
		if(root == null) {
			return;
		}
		
		printInOrderTraversal(root.left);
		System.out.print(root.data+" ");
		printInOrderTraversal(root.right);
	}

}
