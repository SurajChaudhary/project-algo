package com.devtalk.algorithm.linkedList;

public class EvenOddNodesTogetherTest {

	public static void main(String[] args) {
		Node list = ListUtil.getList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		ListUtil.print(list);

		Node root = sesgregateEvenOddNodesTogether(list);
		ListUtil.print(root);
	}

	private static Node sesgregateEvenOddNodesTogether(Node list) {
		Node root = null;
		Node even = null;
		Node odd = null;

		Node evenLast = null;
		Node oddLast = null;

		Node curr = list;
		while (curr != null) {
			if (curr.data % 2 == 0) {
				if (even == null) {
					even = new Node(curr.data);
					evenLast = even;
				} else {
					evenLast.nextNode = new Node(curr.data);
					evenLast = evenLast.nextNode;
				}

			} else {
				if (odd == null) {
					odd = new Node(curr.data);
					oddLast = odd;
				} else {
					oddLast.nextNode = new Node(curr.data);
					oddLast = oddLast.nextNode;
				}
			}
			curr = curr.nextNode;

		}

		oddLast.nextNode = even;
		root = odd;
		return root;
	}

}
