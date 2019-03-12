package com.devtalk.algorithm.linkedList;

public class InsertNodeInSortedWayTest {

	public static void main(String[] args) {
		Node root = ListUtil.getList(2, 5, 7, 10, 15);
		ListUtil.print(root);

		int key = 20;

		Node start = insertKey(root, key);
		ListUtil.print(start);

	}

	private static Node insertKey(Node root, int key) {

		if (root == null) {
			root = new Node(key);
			return root;
		}

		if (key <= root.data) {
			Node newNode = new Node(key);
			newNode.nextNode = root;
			root = newNode;
			return root;
		}
		Node curr = root;
		while (curr != null && curr.nextNode != null) {
			if(key < curr.nextNode.data) {
				Node next = curr.nextNode;
				curr.nextNode = new Node(key);
				curr.nextNode.nextNode = next;
				break;
			}
			curr = curr.nextNode;
		}
		if(key > curr.data) {
			curr.nextNode = new Node(key);
		}
		return root;

	}

}
