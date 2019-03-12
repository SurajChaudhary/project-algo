package com.devtalk.algorithm.circularLinkedList;

public class DeletionTest {

	public static void main(String[] args) {
		Node root = ListUtil.getList(3, 4, 5, 7, 8);
		ListUtil.print(root);
		System.out.println("Number of nodes : "+ ListUtil.getNodeCount(root));
		root = ListUtil.getList(3, 4, 5, 7, 8);
		deleteFront(root);
		root = ListUtil.getList(3, 4, 5, 7, 8);
		deleteAfter(root, 5);
		root = ListUtil.getList(3, 4, 5, 7, 8);
		deleteBefore(root, 5);
		root = ListUtil.getList(3, 4, 5, 7, 8);
		delete(root, 7);
		root = ListUtil.getList(3, 4, 5, 7, 8);
		deleteLast(root);

	}


	private static void deleteLast(Node root) {
		Node secondLast = getSecondLastNode(root);
		secondLast.next = root;
		ListUtil.print(root);
		
	}


	private static void delete(Node root, int i) {
		if(root.data == i) {
			Node last = ListUtil.getLastNode(root);
			Node next = root.next;
			last.next = next;
			root = next;
			ListUtil.print(root);
			return;
		}
		
		Node curr = root.next;
		Node prev = root;
		while (curr != root) {
			if (curr.data == i) {
				prev.next = curr.next;
				break;
			}
			prev = curr;
			curr = curr.next;
		}
		ListUtil.print(root);

		
	}


	private static void deleteAfter(Node root, int i) {
		if (root.data == i) {
			root.next = root.next.next;
			ListUtil.print(root);
			return;
		}
		Node curr = root.next;
		while (curr != null && curr != root) {
			if (curr.data == i) {
				curr.next = curr.next.next;
				break;
			}
			curr = curr.next;
		}
		ListUtil.print(root);

	}

	private static void deleteFront(Node root) {
		Node last = ListUtil.getLastNode(root);
		Node next = root.next;
		last.next = next;
		root = next;
		ListUtil.print(root);

	}

	private static void deleteBefore(Node root, int i) {
		if (i == root.data) {
			Node secondLast = getSecondLastNode(root);
			secondLast.next = root;
			ListUtil.print(root);
			return;
		}
		Node curr = root.next;

		while (curr != root) {
			if (curr.data == i) {
				break;
			}
			curr = curr.next;
		}
		
		Node temp = curr.next;
		Node prev = null;
		while (temp.next != curr) {
			prev = temp;
			temp = temp.next;
		}
		
		if(prev != null) {
			prev.next = prev.next.next;
		}

		ListUtil.print(root);

	}

	public static Node getSecondLastNode(Node root) {

		Node curr = root;
		while (curr.next.next != root) {
			curr = curr.next;
		}
		return curr;

	}

}
