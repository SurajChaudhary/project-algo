package com.devtalk.algorithm.doublyLinkedList;

public class SwapKthNodeFromFrontWithKthNodeFromLastTest {

	public static void main(String[] args) {
		Node root = ListUtil.getList(1, 2, 3, 4, 5);
		ListUtil.print(root);

		int k = 2;

		swapNodes(root, k);

	}

	private static void swapNodes(Node root, int k) {
		int length = ListUtil.getLength(root);
		if (length < k) {
			return;
		}
		if ((2 * k - 1) == length) {
			return;
		}

		// Find the kth node from beginning of linked list.
		// We also find previous of kth node because we need
		// to update next pointer of the previous.
		Node x = root;
		Node x_prev = null;
		for (int i = 1; i < k; i++) {
			x_prev = x;
			x = x.next;
		}

		// Similarly, find the kth node from end and its
		// previous. kth node from end is (n-k+1)th node
		// from beginning
		Node y = root;
		Node y_prev = null;
		for (int i = 1; i < length - k + 1; i++) {
			y_prev = y;
			y = y.next;
		}

		// If x_prev exists, then new next of it will be y.
		// Consider the case when y->next is x, in this case,
		// x_prev and y are same. So the statement
		// "x_prev->next = y" creates a self loop. This self
		// loop will be broken when we change y->next.
		if (x_prev != null)
			x_prev.next = y;

		// Same thing applies to y_prev
		if (y_prev != null)
			y_prev.next = x;

		// Swap next pointers of x and y. These statements
		// also break self loop if x->next is y or y->next
		// is x
		Node temp = x.next;
		x.next = y.next;
		y.next = temp;

		// Change head pointers when k is 1 or n
		if (k == 1)
			root = y;

		if (k == length)
			root = x;

	}

}
