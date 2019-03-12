package com.devtalk.algorithm.queue;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class BreadthFirstSearchWithQueue {

	public static void main(String[] args) {
		Node root = createTree();

		breadthFirstTraversal(root);

	}

	private static void breadthFirstTraversal(Node root) {
		Queue<Node> queue = new LinkedList();
		queue.add(root);
		queue.add(null);

		while (!queue.isEmpty()) {
			Node temp = queue.poll();
			if (temp == null) {
				queue.add(null);
				System.out.println(" ");
				if (queue.peek() == null) {
					break;
				}
			} else {
				System.out.print(temp.data + " ");
				if (temp.left != null) {
					queue.add(temp.left);
				}
				if (temp.right != null) {
					queue.add(temp.right);
				}
			}

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
