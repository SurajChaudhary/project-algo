package com.devtalk.algorithm.binaryTree;

import java.util.HashMap;
import java.util.Map;

public class ConstructTreeFromInorderAndLevelOrderTraversals {
	static int levelIndex = 0;

	public static void main(String[] args) {
		int inOrder[] = { 4, 8, 10, 12, 14, 20, 22 };
		int level[] = { 20, 8, 22, 4, 12, 10, 14 };

		int len = inOrder.length;

		Map<Integer, Integer> indexMap = new HashMap();
		for (int i = 0; i < len; i++) {
			indexMap.put(inOrder[i], i);
		}

		Node root = buildTree(null, inOrder, level, 0, len - 1);
		printInorder(root);

	}

	private static Node buildTree(Node startNode, int[] inOrder, int[] level, int start, int end) {
		if (start > end) {
			return null;
		}
		if (start == end)
			return new Node(inOrder[start]);
		
		boolean found = false; 
        int index = 0; 
   
        // it represents the index in inOrder array of element that 
        // appear first in levelOrder array. 
        for (int i = 0; i < level.length - 1; i++)  
        { 
            int data = level[i]; 
            for (int j = start; j < end; j++)  
            { 
                if (data == inOrder[j])  
                { 
                    startNode = new Node(data); 
                    index = j; 
                    found = true; 
                    break; 
                } 
            } 
            if (found == true) 
                break; 
        } 

		

		startNode.left = buildTree(startNode,inOrder, level, start, index - 1);
		startNode.right = buildTree(startNode,inOrder, level, index + 1, end);

		return startNode;
	}

	private static void printInorder(Node root) {
		if (root == null) {
			return;
		}

		printInorder(root.left);
		System.out.print(root.data + " ");
		printInorder(root.right);

	}

}
