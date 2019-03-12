package com.devtalk.algorithm.linkedList;

public class GivenOnlyAPointerToNodeToBeDeletedInAListDeleteTheNodeTest {

	public static void main(String[] args) {
		Node l1 = new Node(1);
		Node l2 = new Node(2);
		Node l3 = new Node(3);
		Node l4 = new Node(4);
		Node l5 = new Node(5);

		l1.nextNode = l2;
		l2.nextNode = l3;
		l3.nextNode = l4;
		l4.nextNode = l5;

		delete(l3);

		ListUtil.print(l1);

	}

	private static void delete(Node l3) {

		Node next = l3.nextNode;
		if (next != null) {
			l3.data = next.data;
			l3.nextNode = next.nextNode;
		}

	}

}
