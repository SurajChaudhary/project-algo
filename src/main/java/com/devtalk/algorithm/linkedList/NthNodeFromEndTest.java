package com.devtalk.algorithm.linkedList;

public class NthNodeFromEndTest {

	public static void main(String[] args) {
		Node root = ListUtil.getList(15, 18, 5, 8, 11, 12);
		ListUtil.print(root);
		int n = 3;

		System.out.println(" " + n + "th node from end is : " + getNodeFromEnd(root, n));

	}

	private static Node getNodeFromEnd(Node root, int n) {

		Node first = root;
		Node second = root;

		int count = 1;
		while (count <= n) {
			first = first.nextNode;
			count++;
		}

		while (first != null) {
			first = first.nextNode;
			second = second.nextNode;
		}

		return second;
	}

}
