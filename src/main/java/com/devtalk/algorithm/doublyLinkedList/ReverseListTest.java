package com.devtalk.algorithm.doublyLinkedList;

public class ReverseListTest {

	public static void main(String[] args) {
		Node root = ListUtil.getList(1, 2, 3, 4, 5);
		ListUtil.print(root);
		Node newRoot = reverse(root);
		ListUtil.print(newRoot);
	}

	private static Node reverse(Node root) {
		if (root == null || root.next == null) {
			return root;
		}
		Node curr = root;
		Node temp = null;
		while (curr != null) {
			temp = curr.prev;
			curr.prev = curr.next;
			curr.next = temp;
			curr = curr.prev;
		}
		root = temp.prev;
		return root;
	}

}
