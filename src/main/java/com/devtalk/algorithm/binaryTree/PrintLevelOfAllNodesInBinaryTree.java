package com.devtalk.algorithm.binaryTree;

public class PrintLevelOfAllNodesInBinaryTree {

	public static void main(String[] args) {
		Node root = null; 
	       
        /* Constructing tree given in the  
              above figure */
        root = new Node(3); 
        root.left = new Node(2); 
        root.right = new Node(5); 
        root.left.left = new Node(1); 
        root.left.right = new Node(4); 
       
        printLevel(root,0);

	}

	private static void printLevel(Node root, int level) {
		if(root == null) {
			return;
		}
		System.out.println("Node Value :"+ root.data+" level :"+level);
		printLevel(root.left, level+1);
		printLevel(root.right, level+1);
		
	}

}
