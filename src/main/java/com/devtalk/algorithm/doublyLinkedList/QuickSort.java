package com.devtalk.algorithm.doublyLinkedList;

public class QuickSort {

	public static void main(String[] args) {
		Node root = ListUtil.getList(15, 12, 8, 4, 2);

		Node start = root;
		Node last = ListUtil.getLastNode(root);

		sort(start, last);
		ListUtil.print(root);

	}

	private static void sort(Node start, Node last) {
		if (start != null && start != last && start != last.next) {
			Node partition = partitionList(start, last);
			if (partition != null && partition.prev != null)
				sort(start, partition.prev);
			if (partition != null && partition.next != null)
				sort(partition.next, last);
		}
	}

	private static Node partitionList(Node start, Node last) {

		int pivot = last.data;

		Node partitionNode = start.prev;
		for (Node i = start; i != last; i = i.next) {
			if (i.data < pivot) {
				partitionNode = (partitionNode == null) ? start : partitionNode.next;
				int temp = i.data;
				i.data = partitionNode.data;
				partitionNode.data = temp;
			}
		}

		partitionNode = (partitionNode == null) ? start : partitionNode.next;
		int temp = last.data;
		last.data = partitionNode.data;
		partitionNode.data = temp;

		return partitionNode;

	}

}
