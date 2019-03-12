package com.devtalk.algorithm.binaryTree;

public class FindNthNodeOfInorderTraversal {
	static int count = 0;

	public static void main(String[] args) {
		BTNode root = new BTNode(10);
		root.left = new BTNode(20);
		root.right = new BTNode(30);
		root.left.left = new BTNode(40);
		root.left.right = new BTNode(50);

		int n = 4; // 10

		NthInorder(root, n);

	}

	private static void NthInorder(BTNode root, int n) {
		if (root == null) {
			return;
		}
		if (count <= n) {

			NthInorder(root.left, n);
			count++;
			if (count == n) {
				System.out.println(root.data);
			}
			NthInorder(root.right, n);
		}
	}

}
