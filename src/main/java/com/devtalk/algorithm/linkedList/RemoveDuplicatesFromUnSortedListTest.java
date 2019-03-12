package com.devtalk.algorithm.linkedList;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesFromUnSortedListTest {

	public static void main(String[] args) {
		Node root = ListUtil.getList(1, 2, 3, 4, 5, 3, 3, 2, 2, 2, 2, 1, 8);
		ListUtil.print(root);

		Node result = removeDuplicates(root);
		ListUtil.print(result);

	}

	private static Node removeDuplicates(Node root) {
		Node curr = root;
		Node last = curr;

		Set<Integer> dataSet = new HashSet<Integer>();
		while (curr != null) {

			if (dataSet.add(curr.data)) {
				last = curr;
				curr = curr.nextNode;
			} else {
				Node temp = curr.nextNode;
				curr.nextNode = null;
				curr = temp;
				last.nextNode = curr;
			}

		}
		return root;
	}

}
