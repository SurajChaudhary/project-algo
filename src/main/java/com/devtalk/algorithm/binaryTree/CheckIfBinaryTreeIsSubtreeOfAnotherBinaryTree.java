package com.devtalk.algorithm.binaryTree;

public class CheckIfBinaryTreeIsSubtreeOfAnotherBinaryTree {

	public static void main(String[] args) {
		CNode T = new CNode('a'); 
        T.left = new CNode('b'); 
        T.right = new CNode('d'); 
        T.left.left = new CNode('c'); 
        T.right.right = new CNode('e'); 
  
        CNode S = new CNode('a'); 
        S.left = new CNode('b'); 
        S.right = new CNode('d'); 
        S.left.left = new CNode('c');
        S.right.right = new CNode('e');
  
        if (isSubTree(T, S)) { 
            System.out.println("Yes , S is a subtree of T"); 
        } else { 
            System.out.println("No, S is not a subtree of T"); 
        } 

	}

	private static boolean isSubTree(CNode a, CNode b) {

		if (a == null && b == null) {
			return true;
		}
		if (a == null || b == null) {
			return false;
		}

		if (((a.data == b.data) && (isSubTree(a.left, b.left) && isSubTree(a.right, b.right)))
				|| (isSubTree(a.left, b) || isSubTree(a.right, b))) {
			return true;
		}
		return false;
	}

}
