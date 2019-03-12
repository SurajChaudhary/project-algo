package com.devtalk.algorithm.doublyLinkedList;

public class DeleteANode {

	public static void main(String[] args) {
		Node list = ListUtil.getList(1, 2, 3, 4, 5, 3, 3, 2, 2, 2, 2, 1, 8);
		ListUtil.print(list);

		Node l = delete(list, 3);
		ListUtil.print(l);

	}

	private static Node delete(Node list, int i) {

		if (list.data == i) {
			Node temp = list.next;
			temp.prev = null;
			return temp;
		}

		Node root = list;
		while (true) {
			if (root == null) {
				return null;
			}
			if (root.data == i) {
				Node prev = root.prev;
				Node next = root.next;
				prev.next = next;
				next.prev = prev;
				return list;

			}
			root = root.next;
		}
	}

}
