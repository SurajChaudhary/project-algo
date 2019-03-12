package com.devtalk.algorithm.linkedList;

public class NodesSwapWithDataTest {

	public static void main(String[] args) {
		Node root = ListUtil.getList(15, 18, 5, 8, 11, 12);
		ListUtil.print(root);

		Node result = swapNodes(root, 15, 12);
		ListUtil.print(result);

	}

	private static Node swapNodes(Node root, int data1, int data2) {
		Node curr = root;

		Node first = null;
		Node second = null;

		while (curr != null) {
			if (first != null && second != null) {
				break;
			}
			if (curr.data == data1) {
				first = curr;
				curr = curr.nextNode;
				continue;
			}
			if (curr.data == data2) {
				second = curr;
				curr = curr.nextNode;
				continue;
			}
			curr = curr.nextNode;

		}

		int temp = first.data;
		first.data = second.data;
		second.data = temp;
		return root;
	}

}
