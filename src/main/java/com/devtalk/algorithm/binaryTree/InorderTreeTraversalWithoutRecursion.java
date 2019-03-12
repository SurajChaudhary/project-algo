package com.devtalk.algorithm.binaryTree;

import java.util.Stack;

public class InorderTreeTraversalWithoutRecursion {

	public static void main(String[] args) {
		BTNode root = new BTNode(3);
		root.left = new BTNode(2);
		root.right = new BTNode(4);
		root.left.left = new BTNode(1);
		root.left.right = new BTNode(3);
		root.right.right = new BTNode(5);
		
		inorderTraversal(root);

	}

	private static void inorderTraversal(BTNode root) {
		if(root == null) {
			return;
		}
		
		Stack<BTNode> st = new Stack();
		BTNode curr = root;
		
		while(curr != null || !st.isEmpty()) {
			while(curr != null) {
				st.push(curr);
				curr = curr.left;
			}
			curr = st.pop();
			System.out.print(curr.data + " "); 
			curr = curr.right;
		}
		
		
		
	}

}
