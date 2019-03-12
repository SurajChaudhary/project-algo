package com.devtalk.algorithm.linkedList;

import java.util.Stack;

public class SumOfLastkNodesTest {

	/*
	 * Input : 10->6->8->4->12, n = 2 Output : 16 Sum of last two nodes: 12 + 4 = 16
	 */

	public static void main(String[] args) {
		Node root = ListUtil.getList(10, 6, 8, 4, 12);
		ListUtil.print(root);

		int k = 2;
		int sum = getSumOfLastKNodes(root, k);
		System.out.println("Sum is :" + sum);

		root = ListUtil.getList(11, 6, 8, 4, 12);
		int sum1 = getSumOfLastKNodesRev(root, k);
		System.out.println("Sum is :" + sum1);
		
//		root = ListUtil.getList(10, 6, 8, 4, 12);
//		int sum2 = getSumOfLastKNodesRecurr(root, k);
//		System.out.println("Sum is :" + sum2);
		
		// Another approach, use stack and return sum of top two elements.
		
		root = ListUtil.getList(10, 6, 8, 4, 12);
		int sum2 = getSumOfLastKNodesStack(root, k);
		System.out.println("Sum is :" + sum2);

	}

	private static int getSumOfLastKNodesStack(Node root, int k) {
		Stack<Integer> stk = new Stack<Integer>();
		Node curr = root;
		while (curr != null) {
			stk.push(curr.data);
			curr = curr.nextNode;
		}
		int sum = 0;
		for (int i = 0; i < k; i++) {
			sum = sum + stk.pop();
		}
		return sum;
	}

	private static int getSumOfLastKNodes(Node root, int k) {
		Node curr = root;
		Node n = root;

		for (int i = 0; i < k; i++) {
			if (curr == null) {
				return 0;
			}
			curr = curr.nextNode;
		}

		while (curr != null) {
			n = n.nextNode;
			curr = curr.nextNode;
		}

		int sum = 0;
		while (n != null) {
			sum = sum + n.data;
			n = n.nextNode;
		}
		return sum;
	}

	private static int getSumOfLastKNodesRev(Node root, int k) {
		Node curr = ListUtil.reverseList(root);
		int sum = 0;
		for (int i = 0; i < k; i++) {
			sum = sum + curr.data;
			curr = curr.nextNode;
		}
		return sum;
	}
	
//	private static int getSumOfLastKNodesRecurr(Node root, int k) {
//		
//		if(k == 0) {
//			return 0;
//		}
//		
//		Integer sum = new Integer(0);
//		return getSumOfLastKNodesRecurrUtil(root,k);
//	}

//	private static int getSumOfLastKNodesRecurrUtil(Node root, int k) {
//		if(root == null) {
//			return 0;
//		}
//		int res = getSumOfLastKNodesRecurrUtil(root.nextNode, k);
//		if(k > 0) {
//			res = res + root.data;
//			k--;
//		}
//		return res;
//	}

}
