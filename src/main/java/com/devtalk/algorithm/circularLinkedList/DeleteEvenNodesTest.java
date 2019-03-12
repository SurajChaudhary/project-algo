package com.devtalk.algorithm.circularLinkedList;

public class DeleteEvenNodesTest {

	public static void main(String[] args) {
		/*
		 * Input : 57->11->2->56->12->61 
		 * Output : List after deletion : 57 -> 11 -> 61
		 */
		
		Node root = ListUtil.getList(57,11,2,56,12,61);
		ListUtil.print(root);
		
		Node curr = root.next;
		Node prev = root;
		while(curr != root) {
			if(curr.data % 2 == 0) {
				prev.next = curr.next;
				curr = prev.next;
			}else {
			prev = curr;
			curr = curr.next;
			}
		}
		if(curr.data % 2 == 0) {
			prev.next = curr.next;
			root = prev.next;
		}
		
		ListUtil.print(root);

	}

}
