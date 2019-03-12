package com.devtalk.algorithm.binaryTree;

public class InorderSuccessorOfANodeInBinaryTree {
	// Temporary node for case 2
	static BTNode temp = new BTNode();

	public static void main(String[] args) {
		BTNode root = new BTNode(1);
		root.left = new BTNode(2);
		root.right = new BTNode(3);
		root.left.left = new BTNode(4);
		root.left.right = new BTNode(5);
		root.right.right = new BTNode(6);

		// Case 1
		inorderSuccesor(root, root.right);

		// case 2
		inorderSuccesor(root, root.left.left);

		// case 3
		inorderSuccesor(root, root.right.right);

	}

	private static void inorderSuccesor(BTNode root, BTNode x) {
		// Case1: If right child is not null
		if (x.right != null) {
			BTNode inorderSucc = leftMostNode(x.right);
			System.out.print("Inorder Successor of " + x.data + " is ");
			System.out.print(inorderSucc.data + "\n");
		}
		// Case2: If right child is null
		if (x.right == null) {
			BTNode rightMost = rightMostNode(root);
			// case3: If x is the right most node
			if (rightMost == x) {
				System.out.print("No inorder successor! Right most node.\n");
			} else {
				findInorderRecursive(root, x);
			}
		}

	}

	// recursive function to find the Inorder Scuccessor
	// when the right child of node x is null
	static BTNode findInorderRecursive(BTNode root, BTNode x) {
		if (root == null) {
			return null;
		}
		if (root == x || (temp = findInorderRecursive(root.left, x)) != null
				|| (temp = findInorderRecursive(root.right, x)) != null) {
			if (temp != null) {

				if (root.left == temp) {
					System.out.print("Inorder Successor of " + x.data);
					System.out.print(" is " + root.data + "\n");
					return null;
				}
			}

			return root;

		}
		return null;
	}

	// function to find left most node in a tree
	static BTNode leftMostNode(BTNode node) {
		while (node != null && node.left != null)
			node = node.left;
		return node;
	}

	// function to find right most node in a tree
	static BTNode rightMostNode(BTNode node) {
		while (node != null && node.right != null)
			node = node.right;
		return node;
	}

}
