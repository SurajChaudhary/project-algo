package com.devtalk.algorithm.doublyLinkedList;

public class AddNode {

	public static void main(String[] args) {
		Node list = ListUtil.getList(1, 2, 3, 4, 5, 3, 3, 2, 2, 2, 2, 1, 8);
		ListUtil.print(list);

		Node l = addAtHead(list, 99);
		ListUtil.print(l);
		
		Node ll = addAtTheEnd(list, 99);
		ListUtil.print(ll);
		
		Node lll = addInMiddle(list, 99, 3);
		ListUtil.print(lll);

	}

	public static Node addAtHead(Node root, int data) {
		Node newNode = new Node(data);
		newNode.next = root;
		root.prev = newNode;
		root = newNode;
		return root;
	}

	public static Node addAtTheEnd(Node root, int data) {
		Node curr = root;
		while (curr.next != null) {
			curr = curr.next;
		}

		Node newNode = new Node(data);
		curr.next = newNode;
		newNode.prev = curr;
		return root;
	}

	public static Node addInMiddle(Node root, int data, int pos) {
		Node curr = root;
		while (curr != null) {
			if (curr.data == pos) {
				Node next = curr.next;
				Node newNode = new Node(data);
				curr.next = newNode;
				newNode.prev = curr;
				newNode.next = next;
				next.prev = newNode;
				break;
			}
			curr = curr.next;
		}
		return root;
	}

}
