package com.devtalk.algorithm.binaryTree;

import java.util.HashMap;
import java.util.Map;

public class ConstructTreeFromGivenInorderAndPreorderTraversals {
	static int preIndex = 0; 

	public static void main(String[] args) {
		char inOrder[] = new char[] { 'D', 'B', 'E', 'A', 'F', 'C' };
		char preOrder[] = new char[] { 'A', 'B', 'D', 'E', 'C', 'F' };

		int len = inOrder.length;
		CharNode root = buildTree(inOrder, preOrder, 0, len - 1);

		// building the tree by printing inorder traversal
		System.out.println("Inorder traversal of constructed tree is : ");
		printInorder(root);
		Map<Character,Integer> indexMap = new HashMap();
		for(int i = 0; i<len;i++) {
			indexMap.put(inOrder[i],i);
		}
		preIndex = 0;
		
		CharNode effRoot = buildTreeWithMap(inOrder, preOrder, 0, len - 1,indexMap);
		System.out.println("Inorder traversal of constructed tree is : ");
		printInorder(effRoot);

	}

	private static void printInorder(CharNode root) {
		if (root == null) {
			return;
		}

		printInorder(root.left);
		System.out.print(root.data + " ");
		printInorder(root.right);

	}

	/*
	 * Recursive function to construct binary of size len from Inorder traversal
	 * inOrder[] and Preorder traversal preOrder[].
	 * Initial values of inStrt and inEnd should be 0 and len -1. 
	 * The function doesn't do any error checking for cases where
	 * inorder and preorder do not form a tree
	 */
	/*
	 * Algorithm: buildTree()
		1) Pick an element from Preorder. Increment a Preorder Index Variable (preIndex in below code) to pick next element in next recursive call.
		2) Create a new tree node tNode with the data as picked element.
		3) Find the picked element’s index in Inorder. Let the index be inIndex.
		4) Call buildTree for elements before inIndex and make the built tree as left subtree of tNode.
		5) Call buildTree for elements after inIndex and make the built tree as right subtree of tNode.
		6) return tNode.
	 */
	private static CharNode buildTree(char[] inOrder, char[] preOrder, int inStart, int inEnd) {

		if (inStart > inEnd) {
            return null; 
		}
		
		/* Pick current node from Preorder traversal using preIndex 
        and increment preIndex */
		CharNode tNode = new CharNode(preOrder[preIndex++]); 
		
		/* If this node has no children then return */
        if (inStart == inEnd) {
            return tNode; 
        }
        
        /* Else find the index of this node in Inorder traversal */
        int inIndex = search(inOrder, inStart, inEnd, tNode.data); 
        
        /* Using index in Inorder traversal, construct left and 
        right subtress */
        tNode.left = buildTree(inOrder, preOrder, inStart, inIndex - 1); 
        tNode.right = buildTree(inOrder, preOrder, inIndex + 1, inEnd); 
		return tNode;
	}

	private static int search(char arr[], int strt, int end, int value) 
    { 
        int i; 
        for (i = strt; i <= end; i++) { 
            if (arr[i] == value) 
                return i; 
        } 
        return i; 
    }
	
	static class CharNode {
		char data;
		CharNode left, right;

		public CharNode(char item) {
			data = item;
			left = right;
		}
	}
	
	
	private static CharNode buildTreeWithMap(char[] inOrder, char[] preOrder, int inStart, int inEnd, Map<Character,Integer> indexMap) {

		if (inStart > inEnd) {
            return null; 
		}
		
		/* Pick current node from Preorder traversal using preIndex 
        and increment preIndex */
		CharNode tNode = new CharNode(preOrder[preIndex++]); 
		
		/* If this node has no children then return */
        if (inStart == inEnd) {
            return tNode; 
        }
        
        /* Else find the index of this node in Inorder traversal */
        int inIndex = indexMap.get(tNode.data); 
        
        /* Using index in Inorder traversal, construct left and 
        right subtress */
        tNode.left = buildTree(inOrder, preOrder, inStart, inIndex - 1); 
        tNode.right = buildTree(inOrder, preOrder, inIndex + 1, inEnd); 
		return tNode;
	}


}
