package com.devtalk.algorithm.linkedList;


public class AddNodeTest {

	public static void main(String[] args) {
		Node root = ListUtil.getList(1, 2, 3, 4, 5);
		ListUtil.print(root);
		
		root = ListUtil.getList(1, 2, 3, 4, 5);
		Node l = addAtHead(root, 99);
		ListUtil.print(l);
		
		root = ListUtil.getList(1, 2, 3, 4, 5);
		Node ll = addAtTheEnd(root, 99);
		ListUtil.print(ll);
		
		root = ListUtil.getList(1, 2, 3, 4, 5);
		Node lll = addInMiddle(root, 99, 3);
		ListUtil.print(lll);

	}
	
	public static Node addAtHead(Node root, int data) {
		Node newNode = new Node(data);
		newNode.nextNode = root;
		root = newNode;
		return root;
	}

	public static Node addAtTheEnd(Node root, int data) {
		Node curr = root;
		while (curr.nextNode != null) {
			curr = curr.nextNode;
		}

		Node newNode = new Node(data);
		curr.nextNode = newNode;
		return root;
	}

	public static Node addInMiddle(Node root, int data, int pos) {
		Node curr = root;
		while (curr != null) {
			if (curr.data == pos) {
				Node next = curr.nextNode;
				Node newNode = new Node(data);
				curr.nextNode = newNode;
				newNode.nextNode = next;
				break;
			}
			curr = curr.nextNode;
		}
		return root;
	}

}
