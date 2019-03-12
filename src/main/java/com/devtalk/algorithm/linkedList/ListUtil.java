package com.devtalk.algorithm.linkedList;

public class ListUtil {

	public static Node getList(int... data) {

		if (data == null || data.length == 0)
			return null;
		Node[] nodeArr = new Node[data.length];
		int index = 0;
		for (int d : data) {
			if (index < nodeArr.length) {
				Node node = new Node(d);
				nodeArr[index] = node;
				index++;
			}
		}

		if (nodeArr.length == 1) {
			return nodeArr[0];
		}
		nodeArr[0].nextNode = nodeArr[1];
		for (int i = 0; i < nodeArr.length - 1; i++) {
			nodeArr[i].nextNode = nodeArr[i + 1];
		}
		return nodeArr[0];

	}

	public static StringNode getList(String... data) {

		if (data == null || data.length == 0)
			return null;
		StringNode[] nodeArr = new StringNode[data.length];
		int index = 0;
		for (String d : data) {
			if (index < nodeArr.length) {
				StringNode node = new StringNode(d);
				nodeArr[index] = node;
				index++;
			}
		}

		if (nodeArr.length == 1) {
			return nodeArr[0];
		}
		nodeArr[0].next = nodeArr[1];
		for (int i = 0; i < nodeArr.length - 1; i++) {
			nodeArr[i].next = nodeArr[i + 1];
		}
		return nodeArr[0];

	}

	public static void print(Node root) {
		System.out.print("List : [ ");
		while (root != null) {
			System.out.print(root.data + " ");
			root = root.nextNode;
		}
		System.out.print("]");
		System.out.println("");
	}

	public static void print(StringNode root) {
		System.out.print("List : [ ");
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
		if (root.nextNode == null)
			return 1;

		Node curr = root;
		int length = 0;
		while (curr != null) {
			length++;
			curr = curr.nextNode;
		}
		return length;
	}

	public static int getLength(StringNode root) {
		if (root == null)
			return 0;
		if (root.next == null)
			return 1;

		StringNode curr = root;
		int length = 0;
		while (curr != null) {
			length++;
			curr = curr.next;
		}
		return length;
	}

	public static int getLengthRecur(Node root) {
		if (root == null) {
			return 0;
		}

		return 1 + getLengthRecur(root.nextNode);

	}

	public static Node reverseList(Node root) {
		if (root == null || root.nextNode == null) {
			return root;
		}

		Node curr = root;
		Node next = null;
		Node prev = null;

		while (curr != null) {
			next = curr.nextNode;
			curr.nextNode = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

	public static Node reverseListRecur(Node root) {
		if (root == null || root.nextNode == null) {
			return root;
		}

		Node curr = root;
		Node remaining = reverseListRecur(root.nextNode);
		curr.nextNode.nextNode = curr;
		curr.nextNode = null;
		return remaining;
	}

	public static Node copy(Node root) {
		if (root == null) {
			return root;
		}

		Node curr = root;
		Node newHead = null;
		Node last = null;
		while (curr != null) {
			if (last == null) {
				newHead = new Node(curr.data);
				last = newHead;
			} else {
				Node newNode = new Node(curr.data);
				last.nextNode = newNode;
				last = last.nextNode;
			}
			curr = curr.nextNode;
		}
		return newHead;
	}

	public static boolean equal(Node root1, Node root2) {
		if (root1 == null && root2 == null) {
			return true;
		}
		if (root1 == null || root2 == null) {
			return false;
		}

		int length1 = getLength(root1);
		int length2 = getLength(root2);

		if (length1 != length2) {
			return false;
		}

		while (root1 != null && root2 != null) {
			if (root1.data != root2.data) {
				return false;
			}
			root1 = root1.nextNode;
			root2 = root2.nextNode;
		}
		return true;

	}

}
