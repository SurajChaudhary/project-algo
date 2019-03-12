package com.devtalk.algorithm.linkedList;

public class MergeListIntoAnotherAtAlternatePositionsTest {

	public static void main(String[] args) {
		Node list1 = ListUtil.getList(1,3,5,7,9);
		Node list2 = ListUtil.getList(2,4,6,8,10);
		
		Node curr = list1;
		while(curr != null && list2 != null) {
			Node currNext = curr.nextNode;
			Node list2Next = list2.nextNode;
			
			curr.nextNode = list2;
			list2.nextNode = currNext;
			list2 = list2Next;
			curr = curr.nextNode.nextNode;
		}
		
		ListUtil.print(list1);
	}

}
