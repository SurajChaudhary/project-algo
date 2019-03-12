package com.devtalk.algorithm.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BTUtil {

	public static BTNode getTree(int... nodes) {

		if (nodes == null || nodes.length == 0) {
			return new BTNode(0);
		}

		BTNode[] btNodes = new BTNode[nodes.length];

		int index = 0;
		for (int data : nodes) {
			btNodes[index] = new BTNode(data);
			index++;
		}
		BTNode root = btNodes[0];

		for (int i = 1; i < btNodes.length; i = i + 2) {
			btNodes[i - 1].left = btNodes[i];
			btNodes[i - 1].right = btNodes[i + 1];

		}
		return root;
	}

	public static void print(BTNode root) {

		if (root == null) {
			return;
		}
		Queue<BTNode> q = new LinkedList();
		q.add(root);
		q.add(null);
		while (!q.isEmpty()) {
			BTNode node = q.poll();
			if (node == null) {
				q.add(null);
				System.out.println(" ");
				if (q.peek() == null) {
					return;
				}
			} else {
				System.out.print(node.data + " ");
				if (node.left != null) {
					q.add(node.left);
				}
				if (node.right != null) {
					q.add(node.right);
				}
			}

		}

	}

	public static void printBFS(BTNode root) {

		if (root == null) {
			return;
		}
		Queue<BTNode> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			BTNode node = q.poll();

			System.out.print(node.data + " ");
			if (node.left != null) {
				q.add(node.left);
			}
			if (node.right != null) {
				q.add(node.right);
			}

		}

	}

	public static void printDFS(BTNode root) {
		// Base Case
		if (root == null) {
			return;
		}
		System.out.print(root.data);
		// hypothesis
		printDFS(root.left);
		printDFS(root.right);

	}

	public static BTNode addNode(BTNode root, BTNode newNode) {

		if (root == null) {
			return newNode;
		}
		Queue<BTNode> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			BTNode node = q.poll();

			if (node.left != null) {
				q.add(node.left);
			} else {
				node.left = newNode;
				break;
			}
			if (node.right != null) {
				q.add(node.right);
			} else {
				node.right = newNode;
				break;
			}

		}
		return root;

	}

	public static BTNode deleteNode(BTNode root, int key) {

		if (root == null) {
			return null;
		}
		BTNode rightMostNode = null;
		BTNode keyNode = null;
		Queue<BTNode> q = new LinkedList<>();
		q.add(root);

		while (!q.isEmpty()) {
			rightMostNode = q.poll();

			if (rightMostNode.data == key) {
				keyNode = rightMostNode;
			}

			if (rightMostNode.left != null) {
				q.add(rightMostNode.left);
			}
			if (rightMostNode.right != null) {
				q.add(rightMostNode.right);
			}

		}
		keyNode.data = rightMostNode.data;
		deleteRightMostNode(root, rightMostNode);
		return root;

	}

	private static void deleteRightMostNode(BTNode root, BTNode rightMostNode) {
		if (root == null) {
			return;
		}

		Queue<BTNode> q = new LinkedList<>();
		q.add(root);

		BTNode temp = null;
		while (!q.isEmpty()) {
			temp = q.poll();

			if (temp.right != null) {
				if (temp.right == rightMostNode) {
					temp.right = null;
					return;
				} else {
					q.add(temp.right);
				}
			}

			if (temp.left != null) {
				if (temp.left == rightMostNode) {
					temp.left = null;
					return;
				} else {
					q.add(temp.left);
				}
			}

		}

	}

}
