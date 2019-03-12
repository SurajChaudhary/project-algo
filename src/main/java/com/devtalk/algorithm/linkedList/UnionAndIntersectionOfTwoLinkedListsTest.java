package com.devtalk.algorithm.linkedList;

public class UnionAndIntersectionOfTwoLinkedListsTest {

	/*
	 * Given two Linked Lists, create union and intersection lists that contain
	 * union and intersection of the elements present in the given lists. Order of
	 * elements in output lists doesn’t matter. Example:
	 * 
	 * Input: List1: 10->15->4->20 
	 * lsit2: 8->4->2->10 
	 * Output: 
	 * Intersection List: 4->10 
	 * Union List: 2->8->20->4->15->10
	 */

	public static void main(String[] args) {
		//Solution 1
		/*
		 * Following are simple algorithms to get union and intersection lists
		 * respectively.
		 * 
		 * Intersection (list1, list2) 
		 * Initialize result list as NULL. 
		 * Traverse list1 and look for its each element in list2, 
		 * if the element is present in list2,
		 * then add the element to result.
		 * 
		 * Union (list1, list2): 
		 * Initialize result list as NULL. 
		 * Traverse list1 and add all of its elements to the result. 
		 * Traverse list2. 
		 * If an element of list2 is already present in result then do not insert it to result, otherwise insert.
		 */
		
		Node l1 = ListUtil.getList(10,15,4,20);
		Node l2 = ListUtil.getList(8,4,2,10);
		
		Node intersection = intersection(l1,l2);
		ListUtil.print(intersection);
		System.out.println("######");
		 l1 = ListUtil.getList(10,15,4,20);
		 l2 = ListUtil.getList(8,4,2,10);
		Node union = union(l1,l2);
		ListUtil.print(union);
		
		//Solution 2 Using Hashing
		/*
		 * Union (list1, list2) 
		 * Initialize the result list as NULL and create an empty hash table. 
		 * Traverse both lists one by one, for each element being visited, look the element in hash table. 
		 * If the element is not present, then insert the element to result list. 
		 * If the element is present, then ignore it.
		 * 
		 * Intersection (list1, list2) 
		 * Initialize the result list as NULL and create an empty hash table. 
		 * Traverse list1. 
		 * For each element being visited in list1, insert the element in hash table. T
		 * reverse list2, for each element being visited in list2, look the element in hash table. 
		 * If the element is present, then insert the element to result list. 
		 * If the element is not present, then ignore it.
		 */

	}

	private static Node union(Node l1, Node l2) {
		Node result = null;
		Node last = null;
		Node temp = l1;
		while (temp != null) {
			if (last == null) {
				result = temp;
				last = temp;
			} else {
				last.nextNode = temp;
				last = last.nextNode;
			}
			temp = temp.nextNode;
		}
		ListUtil.print(result);
		Node temp2 = l2;
		while (temp2 != null) {
			if (!isPresentInList(result, temp2.data)) {
				push(result,temp2.data);
			}
			temp2 = temp2.nextNode;
		}
		return result;
	}

	private static void push(Node result, int data) {
		Node curr = result;
		while(curr.nextNode != null) {
			curr = curr.nextNode;
		}
		curr.nextNode = new Node(data);
		
	}

	private static Node intersection(Node l1, Node l2) {
		Node result = null;
		Node last = null;
		Node temp = l1;
		while(temp != null) {
			if(isPresentInList(l2,temp.data)) {
				if(last == null) {
					result = temp;
					last = temp;
				}else {
					last.nextNode = temp;
					last = last.nextNode;
				}
			}
			temp = temp.nextNode;
		}
		last.nextNode = null;
		return result;
	}

	private static boolean isPresentInList(Node l2, int data) {
		Node temp = l2;
		while(temp != null) {
			if(temp.data == data) {
				return true;
			}
			temp = temp.nextNode;
		}
		return false;
	}

}
