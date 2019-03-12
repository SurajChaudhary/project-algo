package com.devtalk.algorithm.linkedList;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedListTest {

	/*
	 * Given k sorted linked lists each of size n, merge them and print the sorted
	 * output.
	 * 
	 * Examples:
	 * 
	 * Input: k = 3, n = 4 
	 * list1 = 1->3->5->7->NULL 
	 * list2 = 2->4->6->8->NULL 
	 * list3 = 0->9->10->11
	 * 
	 * Output: 0->1->2->3->4->5->6->7->8->9->10->11
	 */
	public static void main(String[] args) {
		Node list1 = ListUtil.getList(1,3,5,7);
		Node list2 = ListUtil.getList(2,4,6,8);
		Node list3 = ListUtil.getList(0,9,10,11);
		
		Node[] lists = new Node[3];
		lists[0] = list1;
		lists[1] = list2;
		lists[2] = list3;
		
		Node root = mergeLists(lists,3);
		ListUtil.print(root);

	}

	private static Node mergeLists(Node[] lists, int k) {
		Queue<Node> heap = new PriorityQueue<>(new NodeComparator());
		for(Node node: lists) {
			heap.offer(node);
		}
		
		Node start = null;
		Node prev = null;
		while(!heap.isEmpty()) {
			Node curr = heap.poll();
			
			if(curr.nextNode != null) {
				heap.offer(curr.nextNode);
			}
			if (start == null) {
				start = new Node(curr.data);
				prev = start;
			} else {
				prev.nextNode = new Node(curr.data);
				prev = prev.nextNode;
			}
		}
		return start;
	}

}

class NodeComparator implements Comparator<Node>{

	@Override
	public int compare(Node o1, Node o2) {
		return o1.data - o2.data;
	}
	
}
