package com.devtalk.algorithm.circularLinkedList;

public class InsertionTest {

	public static void main(String[] args) {
		Node root = ListUtil.getList(3,4,5,7,8);
		ListUtil.print(root);
		
		addInFront(root, 2);
		
		addAfter(root,5,6);
		
		addBefore(root,3,1);
		
		addToLast(root,9);

	}

	private static void addBefore(Node root, int i, int j) {
		if(i == root.data) {
			Node last = ListUtil.getLastNode(root);
			last.next = new Node(j);
			last.next.next = root;
			root = last.next;
			ListUtil.print(root);
			return;
		}
		Node curr = root.next;
		Node prev = root;
		
		while(curr != null && curr != root) {
			if(curr.data == i) {
				Node n = new Node(j);
				prev.next = n;
				n.next = curr;
				break;
			}
			curr = curr.next;
		}
		
		ListUtil.print(root);
		
	}

	private static void addToLast(Node root, int i) {
		Node last = ListUtil.getLastNode(root);
		Node n = new Node(i);
		last.next = n;
		n.next = root;
		ListUtil.print(root);
		
	}

	private static void addAfter(Node root, int i, int j) {
		
		Node curr = root.next;
		
		while(curr != null && curr != root) {
			if(curr.data == i) {
				Node n = new Node(j);
				n.next = curr.next;
				curr.next = n;
				break;
			}
			curr = curr.next;
		}
		
		ListUtil.print(root);
		
	}

	private static void addInFront(Node root, int i) {
		Node n = new Node(i);
		Node curr = root;
		while(curr.next != root) {
			curr = curr.next;
		}
		
		curr.next = n;
		n.next = root;
		root = n;
		
		ListUtil.print(root);
		
	}

}
