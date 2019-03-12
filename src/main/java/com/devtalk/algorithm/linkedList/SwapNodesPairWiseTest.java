package com.devtalk.algorithm.linkedList;

public class SwapNodesPairWiseTest {

	public static void main(String[] args) {
		Node root = ListUtil.getList(1, 2, 3, 4, 5, 6, 7);
		ListUtil.print(root);

		Node swappedRoot = swapNodesInPair(root);
		ListUtil.print(swappedRoot);

		System.out.println("##########");

		root = ListUtil.getList(1, 2, 3, 4, 5, 6, 7);
		Node swappedRootRecur = swapNodesInPairRecur(root);
		ListUtil.print(swappedRootRecur);

	}

	private static Node swapNodesInPair(Node root) {
		Node p = root;
		Node newRoot = p.nextNode;
		while (true) {
			Node q = p.nextNode;
			Node temp = q.nextNode;
			q.nextNode = p;
			if (temp == null || temp.nextNode == null) {
				p.nextNode = temp;
				break;
			}
			p.nextNode = temp.nextNode;
			p = temp;
		}
		return newRoot;
	}

	private static Node swapNodesInPairRecur(Node root) {

		if (root == null || root.nextNode == null) {
			return root;
		}

		// Store head of list after two nodes
		Node remainingList = root.nextNode.nextNode;

		// Change head
		Node newRoot = root.nextNode;

		// Change next of second node
		root.nextNode.nextNode = root;

		// Recur for remaining list and change next of head
		root.nextNode = swapNodesInPairRecur(remainingList);

		return newRoot;
	}

}
