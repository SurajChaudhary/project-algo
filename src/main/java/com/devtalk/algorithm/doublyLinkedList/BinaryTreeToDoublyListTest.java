package com.devtalk.algorithm.doublyLinkedList;

import java.util.LinkedList;
import java.util.Queue;

import com.devtalk.algorithm.binaryTree.BTNode;

public class BinaryTreeToDoublyListTest {

	public static void main(String[] args) {
		BTNode root = new BTNode(1);
		root.left = new BTNode(2);
		root.right = new BTNode(3);
		root.left.left = new BTNode(4);
		root.left.right = new BTNode(5);
		root.right.left = new BTNode(6);
		root.right.right = new BTNode(7);

		Node head = getList(root);
		ListUtil.print(head);

	}

	private static Node getList(BTNode root) {
		Queue<BTNode> queue = new LinkedList<BTNode>();
		Node head = null;
		Node prev = null;
		BTNode temp = root;
		queue.add(temp);
		while (!queue.isEmpty()) {
			temp = queue.poll();
			Node curr = new Node(temp.data);
			if (prev == null) {
				head = curr;
			} else {
				prev.next = curr;
				curr.prev = prev;
			}
			prev = curr;

			if (temp.left != null) {
				queue.add(temp.left);
			}
			if (temp.right != null) {
				queue.add(temp.right);
			}

		}
		return head;
	}

}
