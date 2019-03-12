package com.devtalk.algorithm.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class CheckWhetherAGivenBinaryTreeIsCompleteOrNot {

	public static void main(String[] args) {
		/* Let us construct the following Binary Tree which 
        is not a complete Binary Tree 
              1 
            /   \ 
           2     3 
          / \     \ 
         4   5     6 
      */
     
      Node root = new Node(1); 
      root.left = new Node(2); 
      root.right = new Node(3); 
      root.left.left = new Node(4); 
      root.left.right = new Node(5); 
      root.right.right = new Node(6); 
        
      if(isCompleteBT(root) == true) 
          System.out.println("Complete Binary Tree"); 
      else
          System.out.println("NOT Complete Binary Tree"); 

	}

	static boolean isCompleteBT(Node root) {
		if (root == null) {
			return true;
		}

		Queue<Node> q = new LinkedList<Node>();

		q.add(root);
		// Create a flag variable which will be set true
		// when a non full node is seen
		boolean flag = false;

		while (!q.isEmpty()) {
			Node n = q.poll();

			if (n.left != null) {
				// If we have seen a non full node, and we see a node
				// with non-empty left child, then the given tree is not
				// a complete Binary Tree
				if (flag) {
					return false;
				}
				q.add(n.left);

			} else {// If this a non-full node, set the flag as true
				flag = true;
			}

			if (n.right != null) {
				// If we have seen a non full node, and we see a node
				// with non-empty right child, then the given tree is not
				// a complete Binary Tree
				if (flag) {
					return false;
				}
				q.add(n.right);
			} else {
				flag = true;
			}

		}
		// If we reach here, then the tree is complete Bianry Tree
		return true;
	}

}
