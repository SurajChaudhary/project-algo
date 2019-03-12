package com.devtalk.algorithm.circularLinkedList;

public class SortedInsert {

	public static void main(String[] args) {
		Node root = ListUtil.getList(3, 7, 9, 11);
		ListUtil.print(root);

		add(root, 10);
		add(root, 15);
		add(root, 2);
		add(null,20);

	}

	private static void add(Node root, int data) {
		
		if(root == null) {
			root = new Node(data);
			root.next = root;
			ListUtil.print(root);
			return;
		}
		
		Node curr = root;
		Node prev = null;

		Node lastNode = ListUtil.getLastNode(curr);

		while (curr.next != root) {
			if (data < curr.data) {
				if (prev == null) {
					lastNode.next = new Node(data);
					lastNode.next.next = curr;
					root = lastNode.next;
					ListUtil.print(root);
					return;
				} else {
					prev.next = new Node(data);
					prev.next.next = curr;
					ListUtil.print(root);
					return;
				}
			}
			prev = curr;
			curr = curr.next;
		}
		if (data < curr.data) {
			prev.next = new Node(data);
			prev.next.next = curr;
		} else {
			curr.next = new Node(data);
			curr.next.next = root;
		}
		ListUtil.print(root);

	}

}
