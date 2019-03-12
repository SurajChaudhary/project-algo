package com.devtalk.algorithm.linkedList;

public class MiddleNodeTest {

	public static void main(String[] args) {
		Node root = ListUtil.getList(15, 18, 5, 8, 11, 12,13,14);
		ListUtil.print(root);

		System.out.println(" Middle node is : " + getMiddleNode(root));

	}

	private static Node getMiddleNode(Node root) {
		Node fast = root;
		Node slow = root;

		while (fast != null && fast.nextNode != null) {
			fast = fast.nextNode.nextNode;
			slow = slow.nextNode;
		}
		return slow;
	}

}
