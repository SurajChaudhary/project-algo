package com.devtalk.algorithm.stack;

import java.util.Stack;

public class InorderTreeTraversalWithoutRecursion {

	public static void main(String[] args) {
		Node root = new Node(1); 
        root.left = new Node(2); 
        root.right = new Node(3); 
        root.left.left = new Node(4); 
        root.left.right = new Node(5); 
        inorder(root);

	}

	private static void inorder(Node root) {
		Stack<Node> stk = new Stack();
		Node curr = root;
		while(curr != null || stk.size() > 0) {
			
			while(curr != null) {
				stk.push(curr);
				curr = curr.left;
			}
			
			curr = stk.pop();
			System.out.println(curr.data + " ");
			
			curr = curr.right;
			
		}
		
	}

}

class Node 
{ 
    int data; 
    Node left, right; 
  
    public Node(int item) 
    { 
        data = item; 
        left = right = null; 
    } 
} 
