package com.devtalk.algorithm.linkedList;

public class LinkedListInZigZagFashionTest {

	public static void main(String[] args) {
		Node root = ListUtil.getList(1,2,3,4);
		ListUtil.print(root);

		rearrange(root);

		ListUtil.print(root);

	}

	private static void rearrange(Node root) {
		boolean flag = true;

		Node curr = root;

		while (curr.nextNode != null) {

			if (flag) {

				if (curr.data > curr.nextNode.data) {
					int temp = curr.nextNode.data;
					curr.nextNode.data = curr.data;
					curr.data = temp;
				}

			} else {

				if (curr.data < curr.nextNode.data) {
					int temp = curr.nextNode.data;
					curr.nextNode.data = curr.data;
					curr.data = temp;
				}

			}

			curr = curr.nextNode;
			flag = !flag;
		}

	}

}
