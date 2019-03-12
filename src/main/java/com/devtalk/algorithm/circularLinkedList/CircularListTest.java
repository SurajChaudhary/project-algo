package com.devtalk.algorithm.circularLinkedList;

public class CircularListTest {

	public static void main(String[] args) {
		Node root = ListUtil.getList(1,2,3,4,5);
		ListUtil.print(root);
		
		String res = ListUtil.isListCircular(root) ? "Yes" : "No";
		System.out.println("Is list circular : " + res);

	}

}
