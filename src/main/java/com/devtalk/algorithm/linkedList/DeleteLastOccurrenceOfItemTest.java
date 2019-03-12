package com.devtalk.algorithm.linkedList;

public class DeleteLastOccurrenceOfItemTest {
	/**
	 * Given a liked list and a key to be deleted. Delete last occurrence of key
	 * from linked. The list may have duplicates.
	 * 
	 * Examples:
	 * 
	 * Input: 1->2->3->5->2->10, key = 2 Output: 1->2->3->5->10
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		Node root = ListUtil.getList(2, 1, 3, 5, 10);
		ListUtil.print(root);

		int key = 2;
		deleteLastOccuredKey(root, key);
		root = ListUtil.getList(2, 1, 3, 5, 10);
		deleteLastOccuredKey1(root, key);

	}

	private static void deleteLastOccuredKey(Node root, int key) {
		Node curr = root;
		Node last = null;
		Node prev = null;
		Node keyNode = null;

		while (curr != null) {
			if (key == curr.data) {
				keyNode = curr;
				prev = last;
			}
			last = curr;
			curr = curr.nextNode;
		}
		if (keyNode != null) {
			if (prev == null) {
				root = root.nextNode;
			} else {
				prev.nextNode = keyNode.nextNode;
			}
		}

		ListUtil.print(root);

	}

	private static void deleteLastOccuredKey1(Node root, int key) {
		Node curr = root;
		Node prev = null;
		Node keyNode = null;

		if (key == curr.data) {
			keyNode = curr;
			prev = null;
		}

		while (curr.nextNode != null) {
			if (key == curr.nextNode.data) {
				keyNode = curr.nextNode;
				prev = curr;
			}
			curr = curr.nextNode;
		}
		if (keyNode != null) {
			if(prev == null) {
				keyNode = keyNode.nextNode;
				root = keyNode;
			}else {
			prev.nextNode = prev.nextNode.nextNode;
			}
		}

		ListUtil.print(root);

	}

}
