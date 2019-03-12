package com.devtalk.algorithm.binaryTree;

class CNode { 
	  
    char data; 
    CNode left, right; 
  
    CNode(char item) { 
        data = item; 
        left = right = null; 
    } 
} 

class CBinaryTree {
	CNode root;
	
	public void printInorder(CNode node) {
		if(node == null) {
			return;
		}
		printInorder(node.left);
		System.out.print(node.data+" ");
		printInorder(node.right);
		
	}
}

public class ReverseAlternateLevelsOfAPerfectBinaryTree {

	public static void main(String[] args) {
		CBinaryTree tree = new CBinaryTree(); 
        tree.root = new CNode('a'); 
        tree.root.left = new CNode('b'); 
        tree.root.right = new CNode('c'); 
        tree.root.left.left = new CNode('d'); 
        tree.root.left.right = new CNode('e'); 
        tree.root.right.left = new CNode('f'); 
        tree.root.right.right = new CNode('g'); 
        tree.root.left.left.left = new CNode('h'); 
        tree.root.left.left.right = new CNode('i'); 
        tree.root.left.right.left = new CNode('j'); 
        tree.root.left.right.right = new CNode('k'); 
        tree.root.right.left.left = new CNode('l'); 
        tree.root.right.left.right = new CNode('m'); 
        tree.root.right.right.left = new CNode('n'); 
        tree.root.right.right.right = new CNode('o'); 
        System.out.println("Inorder Traversal of given tree"); 
        tree.printInorder(tree.root); 
  
        reverseAlternate(tree.root); 
        System.out.println(""); 
        System.out.println(""); 
        System.out.println("Inorder Traversal of modified tree"); 
        tree.printInorder(tree.root); 
        
        //Inorder Traversal of given tree
        //h d i b j e k a l f m c n g o 

        //Inorder Traversal of modified tree
        //o d n c m e l a k f j b i g h 

	}

	private static void reverseAlternate(CNode root) {
		preOrder(root.left,root.right,0);
		
	}

	private static void preOrder(CNode left, CNode right, int level) {
		if(left == null || right == null) {
			return;
		}
		
		if(level%2 == 0) {
			char temp = left.data;
			left.data = right.data;
			right.data = temp;
		}
		preOrder(left.left, right.right, level+1);
		preOrder(left.right, right.left, level+1);
		
		
	}

}
