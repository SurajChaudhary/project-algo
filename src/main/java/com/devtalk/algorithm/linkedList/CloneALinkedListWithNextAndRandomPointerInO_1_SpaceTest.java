package com.devtalk.algorithm.linkedList;

public class CloneALinkedListWithNextAndRandomPointerInO_1_SpaceTest {

	public static void main(String[] args) {
		MyNode l1 = new MyNode(1);
		MyNode l2 = new MyNode(2);
		MyNode l3 = new MyNode(3);
		MyNode l4 = new MyNode(4);
		MyNode l5 = new MyNode(5);

		l1.next = l2;
		l1.random = l3;

		l2.next = l3;
		l2.random = l1;

		l3.next = l4;
		l3.random = l5;

		l4.next = l5;
		l4.random = l5;

		l5.next = null;
		l5.random = l2;

		MyNode.print(l1);

		clone(l1);

	}

	private static void clone(MyNode l1) {
		MyNode curr = l1;
		MyNode temp = null;

		// insert additional node after
		// every node of original list
		while (curr != null) {
			temp = curr.next;
			curr.next = new MyNode(curr.data);
			curr.next.next = temp;
			curr = temp;

		}

		curr = l1;
		
		// adjust the random pointers of the 
	    // newly added nodes
		while (curr != null) {
			if(curr.next != null) {
				curr.next.random = curr.random != null ? curr.random.next : curr.random;
			}
			
			// move to the next newly added node by 
	        // skipping an original node 
			curr = curr.next != null?curr.next.next:curr.next;
		}
		
		MyNode original = l1;
		MyNode copy = l1.next; 
		  
	    // save the start of copied linked list 
		temp = copy;
		
		// now separate the original list and copied list 
	    while (original != null && copy != null) 
	    { 
	        original.next = 
	         original.next != null ? original.next.next : original.next; 
	  
	        copy.next = copy.next != null ?copy.next.next:copy.next; 
	        original = original.next; 
	        copy = copy.next; 
	    } 
	  System.out.println("#######################");
	    MyNode.print(temp);


	}

}

class MyNode {
	int data;
	MyNode next;
	MyNode random;

	public MyNode(int data) {
		super();
		this.data = data;
		this.next = null;
		this.random = null;
	}

	public static void print(MyNode start) {
		while (start != null) {
			System.out.println(" Data : " + start.data);
			if (start.random != null)
				System.out.println(" Random : " + start.random.data);
			if (start.next != null)
				System.out.println(" Next : " + start.next.data);

			start = start.next;

		}
	}

}
