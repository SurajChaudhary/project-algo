package com.devtalk.algorithm.binaryTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DiagonalTraversalOfBinaryTree {

	public static void main(String[] args) {
		Node root = new Node(8);
		root.left = new Node(3);
		root.right = new Node(10);
		root.left.left = new Node(1);
		root.left.right = new Node(6);
		root.right.right = new Node(14);
		root.right.right.left = new Node(13);
		root.left.right.left = new Node(4);
		root.left.right.right = new Node(7);

		diagonalPrint(root);
		/*
		 * Diagonal Traversal of binary tree : 
		 * 8 10 14 
		 * 3 6 7 13 
		 * 1 4
		 */

	}

	private static void diagonalPrint(Node root) {
		// create a map of vectors to store Diagonal elements
		Map<Integer, List<Integer>> diagonalPrint = new HashMap();
		diagonalPrintUtil(root, 0, diagonalPrint);

		System.out.println("Diagonal Traversal of Binnary Tree");
		for (Map.Entry<Integer, List<Integer>> entry : diagonalPrint.entrySet()) {
			System.out.println(entry.getValue());
		}

	}

	private static void diagonalPrintUtil(Node root, int d, Map<Integer, List<Integer>> diagonalMap) {
		if (root == null) {
			return;
		}
		// get the list at the particular d value
		List<Integer> k = diagonalMap.get(d);

		// k is null then create a vector and store the data
		if (k == null) {
			k = new LinkedList<>();
		} 
		// k is not null then update the list
		k.add(root.data);

		// Store all nodes of same line together as a vector
		diagonalMap.put(d, k);

		// Increase the vertical distance if left child
		diagonalPrintUtil(root.left, d + 1, diagonalMap);

		// Vertical distance remains same for right child
		diagonalPrintUtil(root.right, d, diagonalMap);

	}

}
