package com.devtalk.algorithm.linkedList;

public class RemoveDuplicateFromSortedListTest {

	public static void main(String[] args) {
		Node root = ListUtil.getList(1, 2, 2, 3, 3, 3, 4, 5, 6, 6, 6, 6, 6, 7, 8, 9, 9, 10, 10);
		ListUtil.print(root);

		Node result = removeDuplicates(root);
		ListUtil.print(result);

	}

	private static Node removeDuplicates(Node root) {

		if (root == null || root.nextNode == null) {
			return root;
		}

		Node curr = root;

		while (curr != null && curr.nextNode != null) {
			if (curr.data == curr.nextNode.data) {
				Node next = curr.nextNode.nextNode;
				curr.nextNode = null;
				curr.nextNode = next;
			} else {
				curr = curr.nextNode;
			}

		}
		return root;
	}

}
