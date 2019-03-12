package com.devtalk.algorithm.binaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseLevelOrderTraversal {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();

		// Let us create trees shown in above diagram
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		System.out.println("Level Order traversal of binary tree is : ");
		tree.reverseLevelOrder(tree.root);
		System.out.println(" ------ ");
		tree.levelOrder(tree.root);
		System.out.println(" ------ ");
		tree.reverseLevelOrderUsingStackAndQueue(tree.root);

	}

}

class BinaryTree {
	Node root;

	public void reverseLevelOrder(Node node) {
		int height = getHeight(node);

		for (int level = height; level >= 1; level--) {

			printLevel(node, level);
			System.out.println(" ");

		}

	}
	
	public void reverseLevelOrderUsingStackAndQueue(Node node) {
		Stack<Node> stk = new Stack();
		Queue<Node> queue = new LinkedList();
		
		queue.add(node);
		
		while(!queue.isEmpty()) {
			
			Node curr = queue.poll();
			stk.push(curr);
			
			if(curr.right != null) {
				queue.add(curr.right);
			}
			if(curr.left != null) {
				queue.add(curr.left);
			}
			
		}
		
		while(!stk.isEmpty()) {
			System.out.print(stk.pop().data + " ");
		}

	}
	
	public void levelOrder(Node node) {
		int height = getHeight(node);

		for (int level = 1; level <= height; level++) {

			printLevel(node, level);
			System.out.println(" ");

		}

	}

	private void printLevel(Node node, int level) {
		if (node == null) {
			return;
		}
		if (level == 1) {
			System.out.print(node.data + " ");
		} else if (level > 1) {
			printLevel(node.left, level - 1);
			printLevel(node.right, level - 1);
		}

	}

	private int getHeight(Node node) {
		if (node == null) {
			return 0;
		} else {
			int leftHeight = getHeight(node.left);
			int rightHeight = getHeight(node.right);

			if (leftHeight > rightHeight) {
				return leftHeight + 1;
			} else {
				return rightHeight + 1;
			}
		}
	}

	public void printInorder(Node node) {
		if(node == null) {
			return;
		}
		printInorder(node.left);
		System.out.print(node.data+" ");
		printInorder(node.right);
		
	}
}

class Node {
	int data;
	Node left, right;

	Node(int item) {
		data = item;
		left = right;
	}
	
}
