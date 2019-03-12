package com.devtalk.algorithm.linkedList;

public class DeleteAlternateNodeTest {

	public static void main(String[] args) {
		Node root = ListUtil.getList(1, 2, 1, 2, 3, 4, 5);
		ListUtil.print(root);

		deleteAlternateNodes(root);
		ListUtil.print(root);

	}

	private static void deleteAlternateNodes(Node root) {
		if (root == null || root.nextNode == null) {
			return;
		}

		Node curr = root;

		int index = 1;
		Node prev = null;

		while (curr != null) {
			if (index % 2 == 0) {
				prev.nextNode = curr.nextNode;
			}
			prev = curr;
			curr = curr.nextNode;
			index++;
		}

	}

}
