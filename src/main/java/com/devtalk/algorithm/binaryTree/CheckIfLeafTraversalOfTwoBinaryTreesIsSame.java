package com.devtalk.algorithm.binaryTree;

import java.util.Stack;

public class CheckIfLeafTraversalOfTwoBinaryTreesIsSame {

	public static void main(String[] args) {
		// Let us create trees in above example 1
		Node root1 = new Node(1);
		root1.left = new Node(2);
		root1.right = new Node(3);
		root1.left.left = new Node(4);
		root1.right.left = new Node(6);
		root1.right.right = new Node(7);

		Node root2 = new Node(0);
		root2.left = new Node(1);
		root2.right = new Node(5);
		root2.left.right = new Node(4);
		root2.right.left = new Node(6);
		root2.right.right = new Node(7);

		if (isSame(root1, root2))
			System.out.println("Same");
		else
			System.out.println("Not Same");

	}

	private static boolean isSame(Node a, Node b) {

		Stack<Node> s1 = new Stack<>();
		Stack<Node> s2 = new Stack<>();

		s1.push(a);
		s2.push(b);

		while (!s1.isEmpty() || !s2.isEmpty()) {

			// If one of the stacks is empty means other
			// stack has extra leaves so return false
			if (s1.isEmpty() || s2.isEmpty()) {
				return false;
			}

			Node temp1 = s1.pop();
			while (temp1 != null && !isLeaf(temp1)) {
				// Push right and left children of temp1.
				// Note that right child is inserted
				// before left
				if (temp1.right != null) {
					s1.push(temp1.right);
				}
				if (temp1.left != null) {
					s1.push(temp1.left);
				}
				temp1 = s1.pop();
			}

			Node temp2 = s2.pop();
			while (temp2 != null && !isLeaf(temp2)) {
				// Push right and left children of temp1.
				// Note that right child is inserted
				// before left
				if (temp2.right != null) {
					s2.push(temp2.right);
				}
				if (temp2.left != null) {
					s2.push(temp2.left);
				}
				temp2 = s2.pop();
			}

			// If one is null and other is not, then
			// return false
			if (temp1 == null && temp2 != null)
				return false;
			if (temp1 != null && temp2 == null)
				return false;

			// If both are not null and data is not
			// same return false
			if (temp1 != null && temp2 != null) {
				if (temp1.data != temp2.data)
					return false;
			}
		}
		// If control reaches this point, all leaves
		// are matched
		return true;
	}

	private static boolean isLeaf(Node temp1) {
		if (temp1 == null) {
			return false;
		}
		if (temp1.left == null && temp1.right == null) {
			return true;
		}
		return false;
	}

}
