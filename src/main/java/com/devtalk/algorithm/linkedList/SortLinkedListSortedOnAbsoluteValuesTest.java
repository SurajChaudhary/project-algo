package com.devtalk.algorithm.linkedList;

public class SortLinkedListSortedOnAbsoluteValuesTest {

	public static void main(String[] args) {
		Node root = ListUtil.getList(1, -2, -3, 4, -5);
		ListUtil.print(root);

		// Input : 1 -> -2 -> -3 -> 4 -> -5
		// output: -5 -> -3 -> -2 -> 1 -> 4

		ListUtil.print(sort(root));

	}

	private static Node sort(Node root) {

		Node curr = root;
		Node next = curr.nextNode;

		while (next != null) {

			if (next.data < curr.data) {
				curr.nextNode = next.nextNode;
				next.nextNode = root;
				root = next;
				next = curr;
			} else {
				curr = next;
				next = next.nextNode;
			}
		}
		return root;

	}

}
