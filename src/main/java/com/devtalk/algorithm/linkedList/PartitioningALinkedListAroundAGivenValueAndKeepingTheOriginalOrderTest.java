package com.devtalk.algorithm.linkedList;

public class PartitioningALinkedListAroundAGivenValueAndKeepingTheOriginalOrderTest {

	/*
	 * Given a linked list and a value x, partition it such that all nodes less than
	 * x come first, then all nodes with value equal to x and finally nodes with
	 * value greater than or equal to x. The original relative order of the nodes in
	 * each of the three partitions should be preserved. The partition must work
	 * in-place.
	 */

	/*
	 * Examples:
	 * 
	 * Input : 1->4->3->2->5->2->3, 
	 * x = 3 
	 * Output: 1->2->2->3->3->4->5
	 * 
	 * Input : 1->4->2->10 
	 * x = 3 
	 * Output: 1->2->4->10
	 * 
	 * Input : 10->4->20->10->3 
	 * x = 3 
	 * Output: 3->10->4->20->10
	 */
	public static void main(String[] args) {
		Node root = ListUtil.getList(1,4,3,2,5,2,3);
		ListUtil.print(root);
		System.out.println("######################");
		int x = 3;
		Node list = partitionList(root,x);
		ListUtil.print(list);

	}

	

	/*
	 * Below is the algorithm to solve this problem :
	 * 
	 * Initialize first and last nodes of below three linked lists as NULL. 
	 * Linked list of values smaller than x. 
	 * Linked list of values equal to x. 
	 * Linked list of values greater than x. 
	 * Now iterate through the original linked list. 
	 * If a node’s value is less than x then append it at the end of smaller list. 
	 * If the value is equal to x, then at the end of equal list. And if value is greater,
	 * then at the end of greater list. 
	 * Now concatenate three lists.
	 */
	private static Node partitionList(Node root, int x) {
		Node curr = root;

		Node small = null;
		Node smallLast = null;

		Node equal = null;
		Node equalLast = null;

		Node bigger = null;
		Node biggerLast = null;

		while (curr != null) {
			if (curr.data < x) {
				if (smallLast == null) {
					small = new Node(curr.data);
					smallLast = small;
				} else {
					smallLast.nextNode = new Node(curr.data);
					smallLast = smallLast.nextNode;
				}
			} else if (curr.data == x) {
				if (equalLast == null) {
					equal = new Node(curr.data);
					equalLast = equal;
				} else {
					equalLast.nextNode = new Node(curr.data);
					equalLast = equalLast.nextNode;
				}
			} else {
				if (biggerLast == null) {
					bigger = new Node(curr.data);
					biggerLast = bigger;
				} else {
					biggerLast.nextNode = new Node(curr.data);
					biggerLast = biggerLast.nextNode;
				}

			}
			curr = curr.nextNode;
		}
		
		// Connect three lists 
		  
	    // If smaller list is empty 
	    if (small == null) 
	    { 
	        if (equal == null) {
	            return bigger; 
	        }
	        equal.nextNode = bigger; 
	        return equal; 
	    } 
	  
	    // If smaller list is not empty 
	    // and equal list is empty 
	    if (equal == null) 
	    { 
	        small.nextNode = bigger; 
	        return small; 
	    } 
	  
	    // If both smaller and equal list 
	    // are non-empty 
	    smallLast.nextNode = equal; 
	    equalLast.nextNode = bigger; 
	    return  small; 
	}

}
