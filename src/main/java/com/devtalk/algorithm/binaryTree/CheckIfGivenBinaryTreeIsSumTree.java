package com.devtalk.algorithm.binaryTree;

public class CheckIfGivenBinaryTreeIsSumTree {

	public static void main(String[] args) {
		Node root = new Node(26);
		root.left = new Node(10);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(6);
		root.right.right = new Node(3);

		if (isSumTree(root))
			System.out.println("The given tree is a sum tree");
		else
			System.out.println("The given tree is not a sum tree");

	}

	private static boolean isSumTree(Node root) {
		if (root == null) {
			return true;
		}
		if (root.left == null && root.right == null) {
			return true;
		}

		if (root.data == (sum(root.left) + sum(root.right)) 
				&& isSumTree(root.left) 
				&& isSumTree(root.right)) {
			return true;
		}
		return false;
	}
	
	static int sum(Node node)  
    { 
        if (node == null) 
            return 0; 
        return sum(node.left) + node.data + sum(node.right); 
    } 

}
