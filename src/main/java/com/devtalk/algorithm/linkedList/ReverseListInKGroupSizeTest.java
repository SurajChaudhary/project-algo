package com.devtalk.algorithm.linkedList;

public class ReverseListInKGroupSizeTest {
	
	public static void main(String[] args) {
		test(1);
		test(1,2);
		test(1,2,3);
		test(1,2,3,4);
		test(1,2,3,4,5);
		test(1,2,3,4,5,6);

	}


	public static void test(int... args) {
		Node root = ListUtil.getList(args);
		ListUtil.print(root);

		// Input : 1 ->2 ->3 ->4 ->5 ->6 ->7 ->8 ->9 ->null
		// Output: 3 ->2 ->1 ->6 ->5 ->4 ->9 ->8 ->7 ->null

		Node result = reverseByKGroupSize(root, 2);
		ListUtil.print(result);

	}

	private static Node reverseByKGroupSize(Node root, int k) {
		Node curr = root;
		int length = ListUtil.getLength(curr);
		if (length < k) {
			return root;
		}
		if (length == k) {
			return ListUtil.reverseList(root);
		}
		for (int i = 1; i < k; i++) {
			curr = curr.nextNode;
		}
		Node p = curr;
		Node newStart = p;
		Node q = newStart;

		Node temp = null;

		while (true) {
			p = root;
			temp = q.nextNode;
			if (temp == null) {
				ListUtil.reverseList(p);
				return newStart;
			}
			q.nextNode = null;
			q = temp;
			root = temp;
			int count = 1;

			while (count != k) {
				if (temp.nextNode == null) {
					ListUtil.reverseList(p);
					p.nextNode = q;
					return newStart;
				}
				temp = temp.nextNode;
				count++;
			}
			ListUtil.reverseList(p);
			p.nextNode = temp;
			q = temp;
		}
	}

}
