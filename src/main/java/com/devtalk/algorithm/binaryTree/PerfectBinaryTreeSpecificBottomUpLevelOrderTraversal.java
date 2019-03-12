package com.devtalk.algorithm.binaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PerfectBinaryTreeSpecificBottomUpLevelOrderTraversal {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);

		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);

		tree.root.left.left.left = new Node(8);
		tree.root.left.left.right = new Node(9);
		tree.root.left.right.left = new Node(10);
		tree.root.left.right.right = new Node(11);
		tree.root.right.left.left = new Node(12);
		tree.root.right.left.right = new Node(13);
		tree.root.right.right.left = new Node(14);
		tree.root.right.right.right = new Node(15);

		tree.root.left.left.left.left = new Node(16);
		tree.root.left.left.left.right = new Node(17);
		tree.root.left.left.right.left = new Node(18);
		tree.root.left.left.right.right = new Node(19);
		tree.root.left.right.left.left = new Node(20);
		tree.root.left.right.left.right = new Node(21);
		tree.root.left.right.right.left = new Node(22);
		tree.root.left.right.right.right = new Node(23);
		tree.root.right.left.left.left = new Node(24);
		tree.root.right.left.left.right = new Node(25);
		tree.root.right.left.right.left = new Node(26);
		tree.root.right.left.right.right = new Node(27);
		tree.root.right.right.left.left = new Node(28);
		tree.root.right.right.left.right = new Node(29);
		tree.root.right.right.right.left = new Node(30);
		tree.root.right.right.right.right = new Node(31);

		System.out.println("Specific Bottom Up Level Order traversal of binary" + "tree is ");
		printSpecificBottomUpLevelOrder(tree.root);
//16 31 17 30 18 29 19 28 20 27 21 26 22 25 23 24 8 15 9 14 10 13 11 12 4 7 5 6 2 3 1

	}

	private static void printSpecificBottomUpLevelOrder(Node root) {
		if(root == null) {
			return;
		}
		Stack<Node> stk = new Stack();
		stk.push(root);
		if(root.left == null) {
			System.out.println(root.data);
			return;
		}
		
		stk.push(root.right);
		stk.push(root.left);
		Queue<Node> q = new LinkedList();
		if(root.left.left != null) {
			q.add(root.left);
			q.add(root.right);
			
			// We process two nodes at a time, so we 
		    // need two variables to store two front 
		    // items of queue 
		    Node first = null;
		    Node second = null;
		    
		    while(!q.isEmpty()) {
		    	first = q.poll();
		    	second = q.poll();
		    	 // Push first and second node's chilren 
		        // in reverse order 
		    	stk.push(second.left);
		    	stk.push(first.right);
		    	stk.push(second.right);
		    	stk.push(first.left);
		    	
		    	// If first and second have grandchildren, 
		        // enqueue them in specific order
		    	if(first.left.left != null) {
		    		q.add(first.right);
		    		q.add(second.left);
		    		q.add(first.left);
		    		q.add(second.right);
		    		
		    	}
		    }
		}
		
		while(!stk.isEmpty()) {
			System.out.print(stk.pop().data+" ");
		}
		
	}

}
