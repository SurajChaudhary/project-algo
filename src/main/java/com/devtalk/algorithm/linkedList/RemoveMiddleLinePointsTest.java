package com.devtalk.algorithm.linkedList;

public class RemoveMiddleLinePointsTest {

	/*
	 * We maintain two pointers, prev and temp. If these two have either x or y
	 * same, we move forward till the equality holds and keep deleting the nodes in
	 * between. The node from which the equality started, we adjust the next pointer
	 * of that node.
	 */

	public static void main(String[] args) {

		PointNode first = new PointNode(0, 10);
		PointNode second = new PointNode(1, 10);
		PointNode third = new PointNode(5, 10);
		PointNode fourth = new PointNode(7, 10);
		PointNode fifth = new PointNode(7, 5);
		PointNode sixth = new PointNode(20, 5);
		PointNode seventh = new PointNode(40, 5);

		first.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		fifth.next = sixth;
		sixth.next = seventh;
		seventh.next = null;

		PointNode.print(first);

		removeMiddleLinePoint(first);

		PointNode.print(first);

	}

	private static void removeMiddleLinePoint(PointNode first) {

		PointNode prev = first;
		PointNode curr = prev.next;

		while (curr != null) {

			if (prev.x == curr.x) {

				PointNode temp = prev;
				prev = curr;
				curr = curr.next;

				while (curr != null && prev.x == curr.x) {
					temp.next = curr;
					prev.next = null;
					prev = curr;
					curr = curr.next;
				}

			} else if (prev.y == curr.y) {

				PointNode temp = prev;
				prev = curr;
				curr = curr.next;

				while (curr != null && prev.y == curr.y) {
					temp.next = curr;
					prev.next = null;
					prev = curr;
					curr = curr.next;
				}

			} else {
				prev = curr;
				curr = curr.next;
			}
		}

	}

}

class PointNode {
	int x;
	int y;
	PointNode next;

	public PointNode(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		this.next = null;
	}

	public static void print(PointNode node) {
		System.out.print("Point List :[ ");
		while (node != null) {
			System.out.print(node);
			node = node.next;
		}
		System.out.print("]");
		System.out.println("");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((next == null) ? 0 : next.hashCode());
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PointNode other = (PointNode) obj;
		if (next == null) {
			if (other.next != null)
				return false;
		} else if (!next.equals(other.next))
			return false;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "[x=" + x + ", y=" + y + "]";
	}

}
