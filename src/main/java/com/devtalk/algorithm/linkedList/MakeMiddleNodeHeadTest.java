package com.devtalk.algorithm.linkedList;

public class MakeMiddleNodeHeadTest {
	/*
	 * Given a singly linked list, find middle of the linked list and set middle
	 * node of the linked list at beginning of the linked list.
	 * 
	 * Examples:
	 * 
	 * Input : 1 2 3 4 5 Output : 3 1 2 4 5
	 * 
	 * Input : 1 2 3 4 5 6 Output : 4 1 2 3 5 6
	 */

	public static void main(String[] args) {
		Node root = ListUtil.getList(1,2,3,4,5,6);
		ListUtil.print(root);
		
		Node list = makeMiddleNodeHead(root);
		ListUtil.print(list);

	}

	private static Node makeMiddleNodeHead(Node root) {
		Node slow = root;
		Node fast = root;
		Node prev = null;
		
		while(fast != null && fast.nextNode != null) {
			prev = slow;
			slow = slow.nextNode;
			fast = fast.nextNode.nextNode;
		}
		
		Node middleNode = slow;
		prev.nextNode = slow.nextNode;
		middleNode.nextNode = root;
		return middleNode;
	}

}
