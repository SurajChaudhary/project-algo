package com.devtalk.algorithm.binaryTree;

import java.util.Stack;

public class ModifyBinaryTreeToGetPreorderTraversalUsingRightPointerOnly {

	public static void main(String[] args) {
		Node root = new Node(10);  
	    root.left = new Node(8);  
	    root.right = new Node(2);  
	    root.left.left = new Node(3);  
	    root.left.right = new Node(5);  
	  
	    modifytree(root);  
	    printpre(root);  

	}

	private static void printpre(Node root) {
		while(root != null) {
			System.out.print(root.data + " ");
			root = root.right;
		}
		
	}

	private static void modifytree(Node root) {
		if(root == null) {
			return;
		}
		
		Stack<Node> st = new Stack();
		Node prev = null;
		st.push(root);
		
		while(!st.isEmpty()) {
			Node curr = st.pop();
			if(curr.right != null) {
				st.push(curr.right);
			}
			if(curr.left != null) {
				st.push(curr.left);
			}
			if(prev != null) {
				prev.right = curr;
			}
			prev = curr;
		}
		
	}

}
