package com.devtalk.algorithm.linkedList;

public class MergeSortedListsTest {

	public static void main(String[] args) {
		Node list1 = ListUtil.getList(10, 30, 50, 70, 90);
		ListUtil.print(list1);

		Node list2 = ListUtil.getList(20, 40, 60, 80, 100, 110, 130, 140);
		ListUtil.print(list2);

		Node root = merge(list1, list2);
		ListUtil.print(root);

	}

	private static Node merge(Node list1, Node list2) {
		Node root = null;
		Node last = null;
		while (list1 != null && list2 != null) {
			if (list1.data < list2.data) {
				if (last == null) {
					root = new Node(list1.data);
					last = root;
				} else {
					last.nextNode = new Node(list1.data);
					last = last.nextNode;
				}

				list1 = list1.nextNode;
			} else {
				if (last == null) {
					root = new Node(list2.data);
					last = root;
				} else {
					last.nextNode = new Node(list2.data);
					last = last.nextNode;
				}

				list2 = list2.nextNode;
			}

		}
		if (list1 != null) {
			last.nextNode = list1;
		}
		if (list2 != null) {
			last.nextNode = list2;
		}
		return root;
	}

}
