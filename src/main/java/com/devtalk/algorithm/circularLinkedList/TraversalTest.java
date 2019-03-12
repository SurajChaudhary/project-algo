package com.devtalk.algorithm.circularLinkedList;

public class TraversalTest {

	public static void main(String[] args) {
		Node root = ListUtil.getList(1,2,3,4);
		ListUtil.print(root);
		
		Node middle = ListUtil.getMiddleElement(root);
		System.out.println(middle);
		
		ListUtil.sliptInTwo(root);

	}

}
