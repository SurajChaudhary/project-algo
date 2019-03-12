package com.devtalk.algorithm.circularLinkedList;

public class FindMinimumAndMaximumElementsTest {

	public static void main(String[] args) {
		/*
		 * Input : List = 99->11->22->33->44->55->66 
		 * Output : Minimum = 11, Maximum = 99
		 */
		
		Node root = ListUtil.getList(99,11,22,33,44,55,66);
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		Node curr = root;
		while(curr.next != root) {
			if(curr.data < min) {
				min = curr.data;
			}
			if(curr.data > max) {
				max=  curr.data;
			}
			curr = curr.next;
		}
		
		System.out.println("Minimum : "+ min + " Maximum : "+ max);

	}

}
