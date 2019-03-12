package com.devtalk.algorithm.linkedList;

public class PlaindromeTest {

	public static void main(String[] args) {
		Node list1 = ListUtil.getList(1, 2, 3, 4, 5, 3, 3, 2, 2, 2, 2, 1, 8);
		System.out.println("Is List1 a palindrome : " + isPalirome(list1));

		Node list2 = ListUtil.getList(1, 2, 3, 2, 1);
		System.out.println("Is List2 a palindrome : " + isPalirome(list2));

	}

	private static boolean isPalirome(Node root) {
		Node curr = root;
		ListUtil.print(curr);
		Node temp = ListUtil.copy(curr);
		Node recCurr = ListUtil.reverseListRecur(temp);
		ListUtil.print(recCurr);

		return ListUtil.equal(root, recCurr);
	}

}
