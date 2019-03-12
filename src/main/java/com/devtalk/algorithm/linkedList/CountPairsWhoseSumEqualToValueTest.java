package com.devtalk.algorithm.linkedList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class CountPairsWhoseSumEqualToValueTest {

	/*
	 * Given two linked lists(can be sorted or unsorted) of size n1 and n2 of
	 * distinct elements. Given a value x. The problem is to count all pairs from
	 * both lists whose sum is equal to the given value x.
	 * 
	 * Note: The pair has an element from each linked list.
	 * 
	 * Examples:
	 * 
	 * Input : list1 = 3->1->5->7 list2 = 8->2->5->3 x = 10 Output : 2 The pairs
	 * are: (5, 5) and (7, 3)
	 * 
	 * Input : list1 = 4->3->5->7->11->2->1 list2 = 2->3->4->5->6->8-12 x = 9 Output
	 * : 5
	 */

	public static void main(String[] args) {
		Node list1 = ListUtil.getList(3, 1, 5, 7);
		Node list2 = ListUtil.getList(8, 2, 5, 3);

		int value = 10;

		int pairCount = getPairCountUsingSet(list1, list2, value);
		System.out.println("Pair count : " + pairCount);

		list1 = ListUtil.getList(4, 3, 5, 7, 11, 2, 1);
		list2 = ListUtil.getList(2, 3, 4, 5, 6, 8, 12);

		value = 9;

		pairCount = getPairCountUsingSet(list1, list2, value);
		System.out.println("Pair count : " + pairCount);

		/*
		 * Method 2 (Sorting): Sort the 1st linked list in ascending order and the 2nd
		 * linked list in descending order using merge sort technique. Now traverse both
		 * the lists from left to right in the following way:
		 * 
		 * Algorithm:
		 * 
		 * countPairs(list1, list2, x) 
		 * Initialize count = 0 
		 * 	while list != NULL and list2!= NULL 
		 * 		if (list1->data + list2->data) == x 
		 * 			list1 = list1->next 
		 * 			list2 =list2->next 
		 * 			count++ 
		 * 		else if (list1->data + list2->data) > x 
		 * 			list2 =list2->next 
		 * 		else 
		 * 			list1 = list1->next
		 * 
		 * return count
		 */
		
		list1 = ListUtil.getList(4, 3, 5, 7, 11, 2, 1);
		list2 = ListUtil.getList(2, 3, 4, 5, 6, 8, 12);

		value = 9;

		pairCount = getPairCountUsingSorting(list1, list2, value);
		System.out.println("Pair count : " + pairCount);


	}
	
	private static int getPairCountUsingSorting(Node list1, Node list2, int value) {
		int pairCount = 0;
		List<Integer> head1 = new ArrayList();
		while(list1 != null) {
			head1.add(list1.data);
			list1 = list1.nextNode;
		}
		
		List<Integer> head2 = new ArrayList();
		while(list2 != null) {
			head2.add(list2.data);
			list2 = list2.nextNode;
		}
		// sort head1 in ascending order and 
        // head2 in descending order 
        Collections.sort(head1); 
        Collections.sort(head2,Collections.reverseOrder());
        
     // traverse both the lists from left to right 
        Iterator<Integer> itr1 = head1.iterator(); 
        Iterator<Integer> itr2 = head2.iterator(); 
          
        Integer num1 = itr1.hasNext() ? itr1.next() : null; 
        Integer num2 = itr2.hasNext() ? itr2.next() : null; 
          
        while(num1 != null && num2 != null) {
        	// if this sum is equal to 'x', then move both  
            // the lists to next nodes and increment 'count' 
              
            if ((num1 + num2) == value) 
            { 
                num1 = itr1.hasNext() ? itr1.next() : null; 
                num2 = itr2.hasNext() ? itr2.next() : null; 
                  
                pairCount++;  
            }  
              
            // if this sum is greater than x, then 
            // move itr2 to next node 
            else if ((num1 + num2) > value) 
                num2 = itr2.hasNext() ? itr2.next() : null; 
              
            // else move itr1 to next node  
            else
                num1 = itr1.hasNext() ? itr1.next() : null; 
        	
        }
		return pairCount;
	}

	private static int getPairCountUsingSet(Node list1, Node list2, int value) {
		Node curr1 = list1;
		Node curr2 = list2;

		Set<Integer> valueSet = new HashSet<Integer>();

		while (curr1 != null) {
			valueSet.add(curr1.data);
			curr1 = curr1.nextNode;
		}
		int pairCount = 0;
		while (curr2 != null) {
			int diff = value - curr2.data;
			if (valueSet.contains(diff)) {
				pairCount++;
			}
			curr2 = curr2.nextNode;
		}
		return pairCount;
	}

}
