package com.devtalk.algorithm.doublyLinkedList;

public class ReverseDoublyListInGroupsOfKTest {

	public static void main(String[] args) {
		Node root = ListUtil.getList(10, 8, 4, 2, 6, 7);
		ListUtil.print(root);

		int k = 4;
		Node start = reverseInKGroupSize(root, k);
		ListUtil.print(start);

	}

	private static Node reverseInKGroupSize(Node head, int k) {
		Node current = head;
		Node next = null;
		Node new_start = null;
		int count = 0;
		if (ListUtil.getLength(current) < k) {
			return current;
		}
		while (current != null && count < k) {
			next = current.next;
			new_start = push(new_start, current);
			current = next;
			count++;
		}
		if (next != null) {
			head.next = reverseInKGroupSize(next, k);
			head.next.prev = head;
		}
		return new_start;
	}

	static Node push(Node new_start, Node new_node) {
		// since we are adding at the begining,
		// prev is always NULL
		new_node.prev = null;

		// link the old list off the new node
		new_node.next = new_start;

		// change prev of head node to new node
		if (new_start != null)
			new_start.prev = new_node;

		// move the head to point to the new node
		new_start = new_node;
		return new_start;
	}

}
