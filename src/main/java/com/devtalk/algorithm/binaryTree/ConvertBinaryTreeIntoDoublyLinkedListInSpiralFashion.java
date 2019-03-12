package com.devtalk.algorithm.binaryTree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class ConvertBinaryTreeIntoDoublyLinkedListInSpiralFashion {
	static com.devtalk.algorithm.doublyLinkedList.Node head;
	static com.devtalk.algorithm.doublyLinkedList.Node last;

	static void push(Node node) {
		if (head != null) {
			head = new com.devtalk.algorithm.doublyLinkedList.Node(node.data);
			last = head;
		} else {
			last.next = new com.devtalk.algorithm.doublyLinkedList.Node(node.data);
			last = last.next;
		}
	}

	public static void main(String[] args) {
		// Let us create binary tree as shown in above diagram
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);

		root.left.left.left = new Node(8);
		root.left.left.right = new Node(9);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(11);
		// root.right.left.left = new Node(12);
		root.right.left.right = new Node(13);
		root.right.right.left = new Node(14);
		// root.right.right.right = new Node(15);

		spiralLevelOrder(root);

		// Created DLL is:
		// 1 2 3 7 6 5 4 8 9 10 11 13 14

	}

	private static void spiralLevelOrder(Node root) {
		// Base Case
		if (root == null) {
			return;
		}

		// Create an empty deque for doing spiral
		// level order traversal and enqueue root
		Deque<Node> q = new LinkedList<Node>();
		q.addFirst(root);

		// create a stack to store Binary Tree nodes
		// to insert into DLL later
		Stack<Node> stk = new Stack<Node>();

		int level = 0;
		while (!q.isEmpty()) {
			// nodeCount indicates number of Nodes
			// at current level.
			int nodeCount = q.size();
			// Dequeue all Nodes of current level and
			// Enqueue all Nodes of next level
			if ((level & 1) % 2 != 0) {// odd level
				while (nodeCount > 0) {
					// dequeue node from front & push it to
					// stack
					Node node = q.peekFirst();
					q.pollFirst();
					stk.push(node);

					// insert its left and right children
					// in the back of the deque
					if (node.left != null)
						q.addLast(node.left);
					if (node.right != null)
						q.addLast(node.right);

					nodeCount--;
				}

			} else {// even level
				// dequeue node from the back & push it
				// to stack
				Node node = q.peekLast();
				q.pollLast();
				stk.push(node);

				// inserts its right and left children
				// in the front of the deque
				if (node.right != null)
					q.addFirst(node.right);
				if (node.left != null)
					q.addFirst(node.left);
				nodeCount--;
			}
			level++;

		}

		while (!stk.empty()) {
			push(stk.peek());
			stk.pop();
		}
		System.out.println("Created DLL is : ");
		printList(head);
	}

	private static void printList(com.devtalk.algorithm.doublyLinkedList.Node root2) {
		while (root2 != null) {
			System.out.print(root2.data + " ");
			root2 = root2.next;
		}

	}

}
