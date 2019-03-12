package com.devtalk.algorithm.binaryTree;

public class CheckIfTwoNodesAreCousinsInBinaryTree {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.right.right = new Node(15);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.right.left.right = new Node(8);

		Node Node1, Node2;
		Node1 = root.left.left;
		Node2 = root.right.right;
		if (isCousin(root, Node1, Node2))
			System.out.println("Yes");
		else
			System.out.println("No");

	}

	private static boolean isCousin(Node root, Node node1, Node node2) {
		// 1. The two Nodes should be on the same level 
        //       in the binary tree. 
        // 2. The two Nodes should not be siblings (means 
        //    that they should not have the same parent 
        //    Node).
		if ((level(root, node1, 1) == level(root, node2, 1)) && (!isSiblings(root, node1, node2))) {
			return true;
		}
		return false;
	}

	private static int level(Node root, Node node2, int level) {
		if (root == null) {
			return 0;
		}
		if (root.data == node2.data) {
			return level;
		}
		int l = level(root.left, node2, level + 1);
		if (l != 0) {
			return l;
		}
		return level(root.right, node2, level + 1);
	}

	private static boolean isSiblings(Node root, Node node1, Node node2) {
		if (root == null) {
			return false;
		}
		if (root.left == null || root.right == null){
			return false;
		}

		if ((root.left.data == node1.data && root.right.data == node2.data)
				|| (root.left.data == node2.data && root.right.data == node1.data)
				|| isSiblings(root.left, node1, node2) || isSiblings(root.right, node1, node2)) {
			return true;

		}
		return false;
	}

}
