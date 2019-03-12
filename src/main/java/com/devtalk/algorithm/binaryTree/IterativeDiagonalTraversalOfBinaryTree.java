package com.devtalk.algorithm.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class IterativeDiagonalTraversalOfBinaryTree {

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
		     * 8 10 14 
		     * 3 6 7 13 
		     * 1 4
		     */

	}

	private static void diagonalPrint(Node root) {
		if(root == null) {
			return;
		}
		Queue<Node> q = new LinkedList();
		q.add(root);
		q.add(null);
		
		while(!q.isEmpty()) {
			Node curr = q.poll();
			if(curr == null) {
				if(q.isEmpty()) {
					return;
				}
				System.out.println(" ");
				q.add(null);
			}else {
				while(curr != null) {
					System.out.print(curr.data+ " ");
					if(curr.left != null) {
						q.add(curr.left);
					}
					curr = curr.right;
				}
			}
			
		}
		
	}

}
