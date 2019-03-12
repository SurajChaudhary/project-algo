package com.devtalk.algorithm.linkedList;

public class PointToNextHigherValueNodeWithArbitraryPointerTest {

	public static void main(String[] args) {
		ArbitaryNode root = new ArbitaryNode(5);
		root.next = new ArbitaryNode(10);
		root.next.next = new ArbitaryNode(2);
		root.next.next.next = new ArbitaryNode(3);

		assignArbitaryPointersToNextHigherValue(root);

		root = new ArbitaryNode(5);
		root.next = new ArbitaryNode(10);
		root.next.next = new ArbitaryNode(2);
		root.next.next.next = new ArbitaryNode(3);
		System.out.println("#############");
		assignArbitaryPointersToNextGreatestValue(root);

		System.out.println("O(n) solution for assigning arbitary pointer to highest element to the right.");
		
		/*
		 * An Efficient Solution can work in O(n) time. Below are steps.
		 * 
		 * Reverse given linked list. 
		 * Start traversing linked list and store maximum value node encountered so far. 
		 * Make arbitary pointer of every node to point to max. 
		 * If the data in current node is more than max node so far, update max. 
		 * Reverse modified linked list and return head.
		 * 
		 */
		
		root = new ArbitaryNode(5);
		root.next = new ArbitaryNode(10);
		root.next.next = new ArbitaryNode(2);
		root.next.next.next = new ArbitaryNode(3);
		System.out.println("#############");
		
		ArbitaryNode rev = reverse(root);
		
		ArbitaryNode max = rev;
		ArbitaryNode temp = rev.next;
		while(temp != null) {
			temp.arb = max;
			
			if(max.data < temp.data) {
				max = temp;
			}
			temp = temp.next;
		}
		
		ArbitaryNode rev1 = reverse(rev);
		System.out.println(rev1.data);
	}

	private static ArbitaryNode reverse(ArbitaryNode root) {

		ArbitaryNode curr = root;
		ArbitaryNode next = null;
		ArbitaryNode prev = null;
		
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

	private static void assignArbitaryPointersToNextHigherValue(ArbitaryNode root) {
		ArbitaryNode curr = root;
		while (curr.next != null) {
			ArbitaryNode temp = curr.next;
			while (temp != null) {
				if (temp.data > curr.data) {
					curr.arb = temp;
					break;
				}
				temp = temp.next;
			}
			curr = curr.next;
		}
		ArbitaryNode last = root;
		while (last != null) {
			if (last.data > curr.data) {
				curr.arb = last;
				break;
			}
			last = last.next;
		}

		while (root != null) {
			System.out.println("Data : " + root.data);
			if (root.next != null)
				System.out.println("Next : " + root.next.data);
			if (root.arb != null)
				System.out.println("Arbitary : " + root.arb.data);
			root = root.next;
		}

	}

	private static void assignArbitaryPointersToNextGreatestValue(ArbitaryNode root) {
		ArbitaryNode curr = root;
		while (curr != null) {
			ArbitaryNode temp = curr.next;
			ArbitaryNode max = null;
			int num = 0;
			while (temp != null) {
				if (temp.data > num) {
					max = temp;
					num = temp.data;
				}
				temp = temp.next;
			}
			if (max != null) {
				curr.arb = max;
			}
			curr = curr.next;
		}

		while (root != null) {
			System.out.println("Data : " + root.data);
			if (root.next != null)
				System.out.println("Next : " + root.next.data);
			if (root.arb != null)
				System.out.println("Arbitary : " + root.arb.data);
			root = root.next;
		}

	}

}

class ArbitaryNode {
	int data;
	ArbitaryNode arb;
	ArbitaryNode next;

	public ArbitaryNode(int data) {
		super();
		this.data = data;
		this.arb = null;
		this.next = null;
	}

}
