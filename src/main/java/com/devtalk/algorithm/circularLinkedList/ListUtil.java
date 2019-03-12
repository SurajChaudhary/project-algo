package com.devtalk.algorithm.circularLinkedList;

public class ListUtil {

	public static Node getList(int... values) {
		if (values == null || values.length == 0) {
			return null;
		}

		Node head = null;
		Node last = null;

		for (int data : values) {
			if (last == null) {
				head = new Node(data);
				last = head;
			} else {
				last.next = new Node(data);
				last = last.next;
			}
		}
		last.next = head;
		return head;

	}

	public static void print(Node root) {

		Node curr = root;
		Node first = root;
		System.out.print("List : [");
		do {
			System.out.print(curr.data + " ");
			curr = curr.next;
		} while (curr != first);
		System.out.print("]");
		System.out.println("");

	}

	public static Node push(Node root, int data) {
		Node curr = root;
		while (curr.next != root) {
			curr = curr.next;
		}
		Node n = new Node(data);
		curr.next = n;
		n.next = root;
		return root;
	}

	public static Node getMiddleElement(Node root) {
		Node curr = root;

		Node slow = root;
		Node fast = root;

		while (fast.next != curr && fast.next.next != curr) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;

	}

	public static void sliptInTwo(Node root) {
		Node first = null;

		Node middle = getMiddleElement(root);
		Node next = middle.next;
		middle.next = null;
		first = root;
		middle.next = first;

		System.out.println("First List : ");
		print(first);

		Node temp = next;
		while (temp.next != root) {
			temp = temp.next;
		}
		temp.next = next;

		System.out.println("Second List : ");
		print(next);
	}

	public static Node getLastNode(Node root) {

		Node curr = root;
		while (curr.next != root) {
			curr = curr.next;
		}
		return curr;

	}

	public static boolean isListCircular(Node root) {
		Node curr = root.next;

		while (curr != null && curr != root) {
			curr = curr.next;
		}
		if (curr.equals(root)) {
			return true;
		}
		return false;
	}

	public static int getNodeCount(Node root) {
		if (root == null) {
			return 0;
		}
		if (root.next == root) {
			return 1;
		}
		int count = 1;
		Node curr = root.next;
		while (curr != root) {
			count++;
			curr = curr.next;
		}
		return count;

	}
	
	public static void print(com.devtalk.algorithm.doublyLinkedList.Node root) {
		com.devtalk.algorithm.doublyLinkedList.Node curr = root;
		System.out.print("List : [");
		while (curr.next != root) {
			System.out.print(curr.data + " ");
			curr = curr.next;
		}
		if(curr != null) {
			System.out.print(curr.data + " ");
		}
		System.out.print("]");
		System.out.println("");

	}

}
