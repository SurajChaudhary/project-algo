package com.devtalk.algorithm.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

import com.devtalk.algorithm.linkedList.ListUtil;
import com.devtalk.algorithm.linkedList.Node;

public class ConstructCompleteBinaryTreeFromItsLinkedListRepresentation {

	public static void main(String[] args) {

		Node head = ListUtil.getList(36, 30, 25, 15, 12, 10);
		TreeNode root = convertList2Binary(head);
		System.out.println("Inorder Traversal of the" + " constructed Binary Tree is:");
		inorderTraversal(root);

	}

	private static void inorderTraversal(TreeNode root) {
		if (root == null) {
			return;
		}
		inorderTraversal(root.left);
		System.out.print(root.data + " ");
		inorderTraversal(root.right);

	}

	private static TreeNode convertList2Binary(Node head) {
		if (head == null) {
			return null;
		}

		Queue<TreeNode> q = new LinkedList();
		TreeNode root = new TreeNode(head.data);
		q.add(root);

		head = head.nextNode;

		while (head != null) {
			TreeNode parent = q.poll();
			TreeNode left = new TreeNode(head.data);
			q.add(left);
			head = head.nextNode;
			parent.left = left;
			if (head != null) {
				TreeNode right = new TreeNode(head.data);
				q.add(right);
				head = head.nextNode;
				parent.right = right;
			}

		}
		return root;
	}

}

class TreeNode {
	int data;
	TreeNode left, right;

	public TreeNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}
