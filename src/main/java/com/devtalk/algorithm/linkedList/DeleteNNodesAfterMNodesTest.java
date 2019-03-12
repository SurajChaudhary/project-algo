package com.devtalk.algorithm.linkedList;

public class DeleteNNodesAfterMNodesTest {

	// Given a linked list and two integers M and N.
	// Traverse the linked list such
	// that you retain M nodes then delete next N nodes, continue the same till end
	// of the linked list.

	// Input:
	/*
	 * M = 2, N = 2 Linked List: 1->2->3->4->5->6->7->8 Output: Linked List:
	 * 1->2->5->6
	 * 
	 * Input: M = 3, N = 2 Linked List: 1->2->3->4->5->6->7->8->9->10 
	 * Output: Linked List: 1->2->3->6->7->8
	 * 
	 * Input: M = 1, N = 1 Linked List: 1->2->3->4->5->6->7->8->9->10 
	 * Output: Linked List: 1->3->5->7->9
	 */

	public static void main(String[] args) {
		int m = 1;
		int n = 1;

		Node root = ListUtil.getList(1, 2, 3, 4, 5, 6, 7, 8,9,10);
		ListUtil.print(root);

		deleteNNodesAfterMNodes(root, m, n);

	}

	private static void deleteNNodesAfterMNodes(Node root, int m, int n) {

		Node curr = root;

		while (true) {
			int count = 1;
			while (curr != null && count < m) {
				curr = curr.nextNode;
				count++;
			}
			int i = 1;

			while (curr != null && curr.nextNode != null && i <= n) {
				curr.nextNode = curr.nextNode.nextNode;
				i++;
			}
			curr = curr.nextNode;
			if (curr == null) {
				break;
			}
		}
		ListUtil.print(root);

	}

}
