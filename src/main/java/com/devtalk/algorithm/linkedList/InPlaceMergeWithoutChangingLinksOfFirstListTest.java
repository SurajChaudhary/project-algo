package com.devtalk.algorithm.linkedList;

public class InPlaceMergeWithoutChangingLinksOfFirstListTest {

	/*
	 * Given two sorted singly linked lists having n and m elements each, merge them
	 * using constant space. First n smallest elements in both the lists should
	 * become part of first list and rest elements should be part of second list.
	 * Sorted order should be maintained. We are not allowed to change pointers of
	 * first linked list.
	 * 
	 * For example,
	 * 
	 * Input: First List: 2->4->7->8->10 Second List: 1->3->12
	 * 
	 * Output: First List: 1->2->3->4->7 Second List: 8->10->12
	 */
	public static void main(String[] args) {
		Node l1 = ListUtil.getList(2,4,7,8,10);
		Node l2 = ListUtil.getList(1,3,12);
		
		Node c1 = l1;
		Node c2 = l2;
		while(c1 != null && c2 != null) {
			//Swapping data of l1 and l2 if l1.data > l2.data
			if(c1.data > c2.data) {
				int temp  = c2.data;
				c2.data = c1.data;
				c1.data = temp;
				c1 = c1.nextNode;
				//Checking if after swapping, l2 remains sorted.
				if(c2.data > c2.nextNode.data) {
					Node curr = c2;
					while(curr.nextNode != null) {
						if(curr.data > curr.nextNode.data) {
							int t  = curr.nextNode.data;
							curr.nextNode.data = curr.data;
							curr.data = t;
						}
						curr = curr.nextNode;
					}
				}
			}else {
				c1 = c1.nextNode;
				c2 = c2.nextNode;
			}
		}
		
		ListUtil.print(l1);
		ListUtil.print(l2);

	}

}
