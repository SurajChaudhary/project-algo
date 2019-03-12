package com.devtalk.algorithm.doublyLinkedList;

public class MergeSort {

	public static void main(String[] args) {
		Node root = ListUtil.getList(10,8,4,2);
		Node sortedList = sort(root);
		ListUtil.print(sortedList);

	}

	private static Node sort(Node root) {
		if(root == null || root.next == null) {
			return root;
		}
		
		Node middleNode = ListUtil.getMiddleNode(root);
		Node secondList = middleNode.next;
		middleNode.next = null;
		
		Node left = sort(root);
		Node right = sort(secondList);
		
		return merge(left,right);
		
	}

	private static Node merge(Node left, Node right) {
		if(left == null) {
			return right;
		}
		if(right == null) {
			return left;
		}
		
		while(left != null && right != null) {
			if(left.data < right.data) {
				left.next = merge(left.next,right);
				left.next.prev = left;
				left.prev = null;
				return left;
			}else {
				right.next = merge(left,right.next);
				right.next.prev = right;
				right.prev = null;
				return right;
			}
		}
		
		return left != null ? left : right;
	}

}
