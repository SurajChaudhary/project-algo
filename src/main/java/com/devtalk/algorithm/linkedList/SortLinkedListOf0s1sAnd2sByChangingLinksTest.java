package com.devtalk.algorithm.linkedList;

public class SortLinkedListOf0s1sAnd2sByChangingLinksTest {

	public static void main(String[] args) {
		Node root = ListUtil.getList(2,1,2,1,1,2,0,1,0);
		ListUtil.print(root);
		
		Node head = sort(root);
		ListUtil.print(head);
		

	}

	private static Node sort(Node head) {
		// Sort a linked list of 0s, 1s and 2s 
		// by changing pointers. 
		    if (!(head != null) || !(head.nextNode != null)) 
		        return head; 
		  
		    // Initialize current pointers for three 
		    // lists and whole list. 
		    Node zero = null;
		    Node lastZero = null;
		    Node one = null;
		    Node lastOne = null;
		    Node two = null;
		    Node lastTwo = null;
		  
		    // Traverse list 
		    Node curr = head; 
		    while (curr != null) { 
		        if (curr.data == 0) {
					if (lastZero == null) {
						zero = new Node(curr.data);
						lastZero = zero;
					} else {
						lastZero.nextNode = new Node(curr.data);
						lastZero = lastZero.nextNode;
					}
				} else if (curr.data == 1) {
					if (lastOne == null) {
						one = new Node(curr.data);
						lastOne = one;
					} else {
						lastOne.nextNode = new Node(curr.data);
						lastOne = lastOne.nextNode;
					}
				} else {
					if (lastTwo == null) {
						two = new Node(curr.data);
						lastTwo = two;
					} else {
						lastTwo.nextNode = new Node(curr.data);
						lastTwo = lastTwo.nextNode;
					}

				}
		        curr = curr.nextNode;
		    } 
		  
		    // Attach three lists 
		    lastZero.nextNode = one; 
		    lastOne.nextNode = two; 
		    lastTwo.nextNode = null; 
		  
		    // Updated head 
		    head = zero; 
		  
		    return head; 
		} 
		


}
