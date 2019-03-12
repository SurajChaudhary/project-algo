package com.devtalk.algorithm.linkedList;


public class RotateAroundNodeTest {

	public static void main(String[] args) {
		Node root = ListUtil.getList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		ListUtil.print(root);

		Node rotatedHead = rotateAroundNode(root, 5);
		ListUtil.print(rotatedHead);

	}

	private static Node rotateAroundNode(Node root, int data) {
		Node curr = root;
		while (curr != null) {
			if (curr.data == data) {
				break;
			}
			curr = curr.nextNode;
		}

		if (curr != null && curr.nextNode != null) {
			Node newRoot = curr.nextNode;
			curr.nextNode = null;
			Node temp = newRoot;
			while (temp.nextNode != null) {
				temp = temp.nextNode;
			}
			temp.nextNode = root;
			return newRoot;
		}
		return root;
	}

}
