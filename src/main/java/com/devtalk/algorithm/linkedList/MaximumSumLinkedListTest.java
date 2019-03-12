package com.devtalk.algorithm.linkedList;

public class MaximumSumLinkedListTest {

	/*
	 * Given two sorted linked lists, construct a linked list that contains maximum
	 * sum path from start to end. The result list may contain nodes from both input
	 * lists. When constructing the result list, we may switch to the other input
	 * list only at the point of intersection (which mean the two node with the same
	 * value in the lists). You are allowed to use O(1) extra space.
	 * 
	 * Input: List1 = 1->3->30->90->120->240->511 List2 =
	 * 0->3->12->32->90->125->240->249
	 * 
	 * Output: Following is maximum sum linked list out of two input lists list =
	 * 1->3->12->32->90->125->240->511 we switch at 3 and 240 to get above maximum
	 * sum linked list
	 */

	public static void main(String[] args) {

		Node list1 = ListUtil.getList(1, 3, 30, 90, 120, 240, 511);
		Node list2 = ListUtil.getList(0, 3, 12, 32, 90, 125, 240, 249);

		Node root = getMaximumSumList(list1, list2);
		ListUtil.print(root);

	}

	private static Node getMaximumSumList(Node a, Node b) {
		Node start = null;

		Node currA = a;
		Node prevA = a;

		Node currB = b;
		Node prevB = b;

		while (currA != null && currB != null) {
			// Keeping 2 local variables at the start of every
			// loop run to keep track of the sum between pre
			// and cur reference elements.
			int sum1 = 0, sum2 = 0;

			while (currA != null && currB != null && currA.data != currB.data) {

				if (currA.data < currB.data) {
					sum1 += currA.data;
					currA = currA.nextNode;
				} else {
					sum2 += currB.data;
					currB = currB.nextNode;
				}

			}

			// If either of current pointers becomes null
			// carry on the sum calculation for other one.
			if (currA == null) {
				while (currB != null) {
					sum2 += currB.data;
					currB = currB.nextNode;
				}
			}
			if (currB == null) {
				while (currA != null) {
					sum1 += currA.data;
					currA = currA.nextNode;
				}
			}

			// First time adjustment of resultant head based on
			// the maximum sum.
			if (prevA == a && prevB == b)
				start = (sum1 > sum2) ? prevA : prevB;

			// If pre1 and pre2 don't contain the head refernces of
			// lists adjust the next pointers of previous pointers.
			else {
				if (sum1 > sum2)
					prevB.nextNode = prevA.nextNode;
				else
					prevA.nextNode = prevB.nextNode;
			}

			// Adjusting previous pointers
			prevA = currA;
			prevB = currB;

			// If curr1 is not NULL move to the next.
			if (currA != null)
				currA = currA.nextNode;

			// If curr2 is not NULL move to the next.
			if (currB != null)
				currB = currB.nextNode;
		}
		return start;
	}

}
