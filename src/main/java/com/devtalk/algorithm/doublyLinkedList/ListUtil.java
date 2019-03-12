package com.devtalk.algorithm.doublyLinkedList;

public class ListUtil {

	public static Node getList(int... data) {

		if (data == null || data.length == 0)
			return null;
		Node[] nodeArr = new Node[data.length];
		int index = 0;
		for (int d : data) {
			Node node = new Node(d);
			nodeArr[index] = node;
			index++;
		}

		nodeArr[0].next = nodeArr[1];
		for (int i = 0; i < nodeArr.length - 1; i++) {
			nodeArr[i].next = nodeArr[i + 1];
			nodeArr[i + 1].prev = nodeArr[i];
		}
		return nodeArr[0];

	}

	public static void print(Node root) {
		System.out.print(" List : [ ");
		while (root != null) {
			System.out.print(root.data + " ");
			root = root.next;
		}
		System.out.print("]");
		System.out.println("");
	}

	public static int getLength(Node root) {
		if (root == null)
			return 0;
		if (root.next == null)
			return 1;

		Node curr = root;
		int length = 0;
		while (curr != null) {
			length++;
			curr = curr.next;
		}
		return length;
	}

	public static Node getLastNode(Node root) {
		if (root == null || root.next == null) {
			return root;
		}

		Node temp = root;

		while (temp.next != null) {
			temp = temp.next;
		}
		return temp;
	}

	public static Node getMiddleNode(Node root) {
		if (root == null || root.next == null) {
			return root;
		}

		Node fast = root;
		Node slow = root;

		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}

}
