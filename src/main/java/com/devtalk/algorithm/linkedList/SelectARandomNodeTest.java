package com.devtalk.algorithm.linkedList;

import java.util.UUID;

public class SelectARandomNodeTest {
	/*
	 * Given a singly linked list, select a random node from linked list (the
	 * probability of picking a node should be 1/N if there are N nodes in list).
	 * You are given a random number generator.
	 * 
	 * 
	 * The idea is to use Reservoir Sampling. Following are the steps. This is a
	 * simpler version of Reservoir Sampling as we need to select only one key
	 * instead of k keys.
	 * 
	 * (1) Initialize result as first node 
	 * 		result = head->key 
	 * (2) Initialize n = 2
	 * (3) Now one by one consider all nodes from 2nd node onward. 
	 * 		(3.a) Generate a random number from 0 to n-1. 
	 * 		Let the generated random number is j. 
	 * 		(3.b) If j is equal to 0 (we could choose other fixed number between 0 to n-1),
	 * 			 then replace result with current node. 
	 * 		(3.c) n = n+1 
	 * 		(3.d) current = current->next
	 */

	public static void main(String[] args) {
		Node root = ListUtil.getList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18);
		ListUtil.print(root);
		
		printRandomNode(root);

	}

	private static void printRandomNode(Node root) {
		if (root == null) {
			System.out.println("List is empty.");
			return;
		}

		// Initialize result as first node
		int result = root.data;

		// Use a different seed value so that we don't get
		// same result each time we run this program
		Math.abs(UUID.randomUUID().getMostSignificantBits());

		// Iterate from the (k+1)th element to nth element
		Node current = root;
		int n;
		for (n = 2; current != null; n++) {
			// change result with probability 1/n
			if (Math.random() % n == 0) {
				result = current.data;
			}
			// Move to next node
			current = current.nextNode;
		}

		System.out.println("Randomly selected key is " + result);

	}

}
