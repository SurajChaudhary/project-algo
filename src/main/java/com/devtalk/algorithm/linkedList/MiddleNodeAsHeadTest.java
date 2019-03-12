package com.devtalk.algorithm.linkedList;

public class MiddleNodeAsHeadTest {

	public static void main(String[] args) {
		// Input : 1 2 3 4 5
		// Output : 3 1 2 4 5
		Node root = ListUtil.getList(1, 2, 3, 4, 5);
		ListUtil.print(root);

		Node result = makeMiddleAsHead(root);
		ListUtil.print(result);

	}

	private static Node makeMiddleAsHead(Node root) {
		if (root == null || root.nextNode == null) {
			return root;
		}

		Node slow = root;
		Node fast = root;

		Node prev = null;

		while (fast != null && fast.nextNode != null) {
			prev = slow;
			slow = slow.nextNode;
			fast = fast.nextNode.nextNode;

		}

		prev.nextNode = prev.nextNode.nextNode;
		slow.nextNode = root;
		root = slow;
		return root;
	}

}
