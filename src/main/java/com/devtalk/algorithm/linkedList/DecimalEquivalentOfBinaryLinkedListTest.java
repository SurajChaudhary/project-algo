package com.devtalk.algorithm.linkedList;

public class DecimalEquivalentOfBinaryLinkedListTest {

	/**
	 * Given a singly linked list of 0s and 1s find its decimal equivalent.
	 * 
	 * Input : 0->0->0->1->1->0->0->1->0 Output : 50
	 * 
	 * Input : 1->0->0 Output : 4
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		Node root = ListUtil.getList(0, 0, 0, 1, 1, 0, 0, 1, 0);

		ListUtil.print(root);

		System.out.println(getDecimalEquivalent(root));

	}

	private static int getDecimalEquivalent(Node root) {
		// Initialize result as 0. Traverse the linked list and for each node, multiply
		// the result by 2 and add node’s data to it.

		int sum = 0;
		Node curr = root;
		while (curr != null) {
			sum = (sum << 1) + curr.data;
			curr = curr.nextNode;
		}
		return sum;
	}

}
