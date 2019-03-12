package com.devtalk.algorithm.binaryTree;

public class ChangeBinaryTreeSoThatEveryNodeStoresSumOfAllNodesInLeftSubtree {

	public static void main(String[] args) {
		/*
		 * Let us construct below tree 1 / \ 2 3 / \ \ 4 5 6
		 */
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.right = new Node(6);

		updatetree(root);

		System.out.println("Inorder traversal of the modified tree is");
		inorder(root);
		
		//Inorder traversal of the modified tree is
		//4 6 5 12 3 6

	}

	private static void inorder(Node root) {
		if (root == null) {
			return;
		}

		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);

	}

	private static int updatetree(Node root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return root.data;
		}

		int leftSum = updatetree(root.left);
		int rightSum = updatetree(root.right);

		root.data = root.data + leftSum;

		return root.data + rightSum;

	}

}
