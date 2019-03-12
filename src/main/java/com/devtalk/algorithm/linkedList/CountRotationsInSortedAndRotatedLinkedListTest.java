package com.devtalk.algorithm.linkedList;

public class CountRotationsInSortedAndRotatedLinkedListTest {

	public static void main(String[] args) {
		// Input : 1 2 3 4 5
		// Output : 3 1 2 4 5
		Node root = ListUtil.getList(15, 18, 5, 8, 11, 12);
		ListUtil.print(root);

		System.out.println(" Rotation count : " + getRotationCount(root));

	}

	private static int getRotationCount(Node root) {
		int count = 0;
		if (root == null) {
			return 0;
		}

		Node curr = root;
		while (curr != null && curr.nextNode != null) {
			if (curr.data > curr.nextNode.data) {
				break;
			}
			count++;
			curr = curr.nextNode;
		}
		return count;
	}

}
