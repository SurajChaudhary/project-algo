package com.devtalk.algorithm.binaryTree;

import java.util.Vector;

public class FindAllPossibleBinaryTreesWithGivenInorderTraversal {

	public static void main(String[] args) {
		int in[] = { 4, 5, 7 };
		int n = in.length;
		Vector<BTNode> trees = getTrees(in, 0, n - 1);
		System.out.println("Preorder traversal of different " + " binary trees are:");
		for (int i = 0; i < trees.size(); i++) {
			preOrder(trees.get(i));
			System.out.println("");
		}

	}

	private static Vector<BTNode> getTrees(int arr[], int start, int end) {
		// List to store all possible trees
		Vector<BTNode> trees = new Vector<>();

		/*
		 * if start > end then subtree will be empty so returning NULL in the list
		 */
		if (start > end) {
			trees.add(null);
			return trees;
		}

		/*
		 * Iterating through all values from start to end for constructing left and
		 * right subtree recursively
		 */
		for (int i = start; i <= end; i++) {
			/* Constructing left subtree */
			Vector<BTNode> ltrees = getTrees(arr, start, i - 1);
			/* Constructing right subtree */
			Vector<BTNode> rtrees = getTrees(arr, i + 1, end);

			/*
			 * Now looping through all left and right subtrees and connecting them to ith
			 * root below
			 */
			for (int j = 0; j < ltrees.size(); j++) {
				for (int k = 0; k < rtrees.size(); k++) {
					// Making arr[i] as root
					BTNode node = new BTNode(arr[i]);

					// Connecting left subtree
					node.left = ltrees.get(j);

					// Connecting right subtree
					node.right = rtrees.get(k);

					// Adding this tree to list
					trees.add(node);
				}
			}
		}
		return trees;
	}

	// A utility function to do preorder traversal of BST
	static void preOrder(BTNode node) {
		if (node != null) {
			System.out.print(node.data + " ");
			preOrder(node.left);
			preOrder(node.right);
		}
	}

}
