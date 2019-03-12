package com.devtalk.algorithm.binaryTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PrintBinaryTreeInVerticalOrder {

	public static void main(String[] args) {
		Node root = new Node(1); 
        root.left = new Node(2); 
        root.right = new Node(3); 
        root.left.left = new Node(4); 
        root.left.right = new Node(5); 
        root.right.left = new Node(6); 
        root.right.right = new Node(7); 
        root.right.left.right = new Node(8); 
        root.right.right.right = new Node(9); 
        System.out.println("Vertical Order traversal is"); 
        Map<Integer,List<Integer>> map = new HashMap();
        printVerticalOrder(root,0,map); 
        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
        	System.out.println(entry.getValue());
        }
	}

	private static void printVerticalOrder(Node root, int d, Map<Integer, List<Integer>> map) {
		if (root == null) {
			return;
		}
		if (map.containsKey(d)) {
			map.get(d).add(root.data);
		} else {
			List<Integer> l = new LinkedList<>();
			l.add(root.data);
			map.put(d, l);
		}
		printVerticalOrder(root.left, d - 1, map);

		printVerticalOrder(root.right, d + 1, map);
	}

}
