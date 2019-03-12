package com.devtalk.algorithm.linkedList;

public class LongestPalindromeListInList {

	public static void main(String[] args) {
		// Input : List = 2->3->7->3->2->12->24
		// Output : 5
		Node root = ListUtil.getList(2, 3, 7, 3, 2, 12, 24);
		//Node root = ListUtil.getList(2, 3, 2);

		int count = getLongestPalindromeList(root);
		System.out.println("Count : " + count);

	}

	private static int getLongestPalindromeList(Node root) {
		if (root == null || root.nextNode == null) {
			return 1;
		}
		int count = 0;
		int length = ListUtil.getLength(root);
		for (int i = 1; i <= length; i++) {
			Node curr = root;
			Node last = curr;
			for (int j = 1; j < i; j++) {
				last = last.nextNode;
			}
			Node start = null;
			Node prev = null;
			if (curr == last) {
				start = new Node(curr.data);
				prev = start;
			} else {
				for (int k = 1; k <= i; k++) {
					if (start == null) {
						start = new Node(curr.data);
						prev = start;
					} else {
						prev.nextNode = new Node(curr.data);
						prev = prev.nextNode;
					}
					curr = curr.nextNode;
				}
			}
			Node temp = start;
			Node copy = null;
			Node copyLast = null;
			while(temp != null) {
				if (copy == null) {
					copy = new Node(temp.data);
					copyLast = copy;
				} else {
					copyLast.nextNode = new Node(temp.data);
					copyLast = copyLast.nextNode;
				}
				temp = temp.nextNode;
			}
			Node rev = ListUtil.reverseList(copy);
			if (isListEqual(start, rev)) {
				int c = ListUtil.getLength(rev);
				if (c > count) {
					count = c;
				}
			}
		}
		return count;
	}
	
	private static boolean isListEqual(Node a, Node b) {
		if(a == null && b == null) {
			return true;
		}
		
		int alength = ListUtil.getLength(a);
		int blength = ListUtil.getLength(b);
		
		if(alength != blength) {
			return false;
		}
		
		while(a != null && b != null) {
			if(a.data != b.data) {
				return false;
			}
			a = a.nextNode;
			b = b.nextNode;
		}
		return true;
		
	}

}
