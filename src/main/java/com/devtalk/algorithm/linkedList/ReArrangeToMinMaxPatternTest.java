package com.devtalk.algorithm.linkedList;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class ReArrangeToMinMaxPatternTest {

	// Given a list of integers, rearrange the list such that it consists of
	// alternating minimum maximum elements using only list operations. The first
	// element of the list should be minimum and second element should be maximum of
	// all elements present in the list. Similarly, third element will be next
	// minimum element and fourth element is next maximum element and so on. Use of
	// extra space is not permitted.

	/*
	 * Examples:
	 * 
	 * Input: [1 3 8 2 7 5 6 4] Output: [1 8 2 7 3 6 4 5]
	 * 
	 * Input: [1 2 3 4 5 6 7] Output: [1 7 2 6 3 5 4]
	 * 
	 * Input: [1 6 2 5 3 4] Output: [1 6 2 5 3 4]
	 */

	public static void main(String[] args) {
		Node root = ListUtil.getList(1, 3, 8, 2, 7, 5, 6, 4);
		ListUtil.print(root);
		rearrange(root);
		System.out.println("");
		root = ListUtil.getList(1, 2, 3, 4, 5, 6, 7);
		ListUtil.print(root);
		rearrange(root);
		System.out.println("");
		root = ListUtil.getList(1, 6, 2, 5, 3, 4);
		ListUtil.print(root);
		rearrange(root);

		// input list
		Integer arr[] = { 1, 3, 8, 2, 7, 5, 6, 4 };

		// convert array to LinkedList
		LinkedList<Integer> ll = new LinkedList<Integer>(Arrays.asList(arr));

		// rearrange the given list
		alternateSort(ll);

	}

	// Function to rearrange a given list such that it
	// consists of alternating minimum maximum elements
	// using LinkedList
	// The idea is to sort the list in ascending order first. Then we start popping
	// elements from the end of the list and insert them into their correct position
	// in the list.
	public static void alternateSort(LinkedList<Integer> ll) {
		Collections.sort(ll);

		for (int i = 1; i < (ll.size() + 1) / 2; i++) {
			Integer x = ll.getLast();
			ll.removeLast();
			ll.add(2 * i - 1, x);
		}

		System.out.println(ll);
	}

	private static void rearrange(Node root) {
		boolean flag = true;

		Node temp = root;
		while (temp != null && temp.nextNode != null) {
			if (flag) {
				if (temp.data > temp.nextNode.data) {
					int t = temp.data;
					temp.data = temp.nextNode.data;
					temp.nextNode.data = t;
				}
			} else {
				if (temp.data < temp.nextNode.data) {
					int t = temp.data;
					temp.data = temp.nextNode.data;
					temp.nextNode.data = t;
				}
			}
			flag = !flag;
			temp = temp.nextNode;
		}

		ListUtil.print(root);

	}

}
