package com.devtalk.algorithm.binaryTree;

import java.util.Vector;

public class ReplaceEachNodeInBinaryTreeWithTheSumOfItsInorderPredecessorAndSuccessor {

	public static void main(String[] args) {
		// binary tree formation
		BTNode root = getNode(1); // 1
		root.left = getNode(2); // / \
		root.right = getNode(3); // 2 3
		root.left.left = getNode(4); // / \ / \
		root.left.right = getNode(5); // 4 5 6 7
		root.right.left = getNode(6);
		root.right.right = getNode(7);

		System.out.println("Preorder Traversal before tree modification:");
		preorderTraversal(root);

		replaceNodeWithSumUtil(root);

		System.out.println("\nPreorder Traversal after tree modification:");
		preorderTraversal(root);

	}

	private static void replaceNodeWithSumUtil(BTNode root) {
		// if tree is empty 
	    if (root==null) {
	        return;
	    }
	   
	    Vector<Integer> arr= new Vector<Integer>(); 
	   
	    // store the value of inorder predecessor 
	    // for the leftmost leaf 
	    arr.add(0); 
	    
	 // store the inoder traversal of the tree in 'arr' 
	    storeInorderTraversal(root, arr); 
	   
	    // store the value of inorder successor 
	    // for the rightmost leaf 
	    arr.add(0); 
	    
	 // replace each node with the required sum 
	    INT i = new INT(); 
	      
	    i.data=1; 
	      
	    replaceNodeWithSum(root, arr, i); 
		
	}
	
	
	// function to replace each node with the sum of its 
	// inorder predecessor and successor 
	static void replaceNodeWithSum( BTNode root, 
	                        Vector<Integer> arr, INT i) 
	{ 
	    // if root is null 
	    if (root==null) 
	        return; 
	   
	    // first recur on left child 
	    replaceNodeWithSum(root.left, arr, i); 
	   
	    // replace node's data with the sum of its 
	    // inorder predecessor and successor 
	    root.data = arr.get(i.data - 1) + arr.get(i.data + 1); 
	   
	    // move 'i' to point to the next 'arr' element 
	    i.data++; 
	   
	    // now recur on right child 
	    replaceNodeWithSum(root.right, arr, i); 
	} 

	// function to store the inorder traversal 
	// of the binary tree in 'arr' 
	static void storeInorderTraversal( BTNode root,  
	                                Vector<Integer> arr) 
	{ 
	    // if root is null 
	    if (root==null) 
	        return; 
	   
	    // first recur on left child 
	    storeInorderTraversal(root.left, arr); 
	   
	    // then store the root's data in 'arr' 
	    arr.add(root.data); 
	   
	    // now recur on right child 
	    storeInorderTraversal(root.right, arr); 
	} 

	private static void preorderTraversal(BTNode root) {
		if(root == null) {
			return;
		}
		System.out.print(root.data+" ");
		preorderTraversal(root.left);
		preorderTraversal(root.right);
		
	}

	private static BTNode getNode(int i) {
		return new BTNode(i);
	}
	
	//INT class 
	static class INT 
	{ 
	    int data; 
	} 

}
