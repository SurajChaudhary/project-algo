package com.devtalk.algorithm.linkedList;

public class PalindromeTestWithSplitingListFromMiddle {

	public static void main(String[] args) {
		Node list1 = ListUtil.getList(1, 2, 3, 4, 5, 3, 3, 2, 2, 2, 2, 1, 8);
		System.out.println("Is List1 a palindrome : " + isPalirome(list1));

		Node list2 = ListUtil.getList(1, 2, 1);
		System.out.println("Is List2 a palindrome : " + isPalirome(list2));


	}

	private static boolean isPalirome(Node list) {
		
		if(list == null || list.nextNode == null) {
			return true;
		}
		
		Node secondStart = null;
		Node p = list;
		Node q = list;
		
		while(true) {
			p = p.nextNode.nextNode;
			if(p == null) {
				secondStart = q.nextNode;
				break;
			}
			if(p.nextNode == null) {
				secondStart = q.nextNode.nextNode;
				break;
			}
			q = q.nextNode;
			
			
		}
		q.nextNode = null;
		
		Node revSec = ListUtil.reverseList(secondStart);
		return ListUtil.equal(list, revSec);
	}

}
