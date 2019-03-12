package com.devtalk.algorithm.linkedList;

public class RemoveEveryKthNodeTest {

	/*
	 * Given a singly linked list, Your task is to remove every K-th node of the
	 * linked list. Assume that K is always less than or equal to length of Linked
	 * List. 
	 * Input : 1->2->3->4->5->6->7->8 
	 * k = 3 
	 * Output : 1->2->4->5->7->8
	 */

	public static void main(String[] args) {
		Node root = ListUtil.getList(1,2,3,4,5,6,7,8);
		ListUtil.print(root);
		
		int k = 1;
		removeEveryKthNodeTest(root,k);

	}

	private static void removeEveryKthNodeTest(Node root, int k) {
		if(k < 1) {
			return;
		}
		if(k == 1) {
			root = null;
			ListUtil.print(root);
			return;
		}
		if(root == null) {
			ListUtil.print(root);
			return;
		}
		int length = ListUtil.getLength(root);
		if(k > length) {
			ListUtil.print(root);
			return;
		}
		if(k == length) {
			Node last = root;
			Node prev = null;
			while(last.nextNode != null) {
				prev = last;
				last = last.nextNode;
			}
			prev.nextNode = null;
			ListUtil.print(root);
			return;
		}
		Node curr = root;
		while(true) {
			if(curr == null) {
				break;
			}
			Node prev = null;
			for(int i=1; i < k && curr.nextNode != null; i++) {
				prev = curr;
				curr = curr.nextNode;
			}
			Node next = curr.nextNode;
			prev.nextNode = next;
			curr = next;
			int remLength = ListUtil.getLength(curr);
			if(k > remLength) {
				break;
			}
			
		}
		ListUtil.print(root);
		
	}

}
