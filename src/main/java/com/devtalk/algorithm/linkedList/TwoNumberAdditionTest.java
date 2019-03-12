package com.devtalk.algorithm.linkedList;

public class TwoNumberAdditionTest {

	public static void main(String[] args) {
		Node numberOne = ListUtil.getList(9, 6, 9);
		ListUtil.print(numberOne);

		Node numberTwo = ListUtil.getList(9, 9);
		ListUtil.print(numberTwo);

		Node result = addList(numberOne, numberTwo);
		ListUtil.print(result);

	}

	private static Node addList(Node numberOne, Node numberTwo) {
		Node revOne = ListUtil.reverseList(numberOne);
		ListUtil.print(revOne);
		Node revTwo = ListUtil.reverseList(numberTwo);
		ListUtil.print(revTwo);

		int lengthOne = ListUtil.getLength(revOne);
		int lengthTwo = ListUtil.getLength(revTwo);

		if (lengthOne > lengthTwo) {
			int diff = Math.abs(lengthOne - lengthTwo);
			Node temp = revTwo;
			while (temp.nextNode != null) {
				temp = temp.nextNode;
			}
			for (int i = 0; i < diff; i++) {
				Node newNode = new Node(0);
				temp.nextNode = newNode;
				temp = temp.nextNode;
			}
		} else if (lengthTwo > lengthOne) {
			int diff = Math.abs(lengthTwo - lengthOne);
			Node temp = revOne;
			while (temp.nextNode != null) {
				temp = temp.nextNode;
			}
			for (int i = 0; i < diff; i++) {
				Node newNode = new Node(0);
				temp.nextNode = newNode;
				temp = temp.nextNode;
			}
		}
		Node res = null;
		int carry = 0;
		Node last = null;
		while (revOne != null && revTwo != null) {
			int sum = revOne.data + revTwo.data;
			if (carry > 0) {
				sum = sum + carry;
			}
			if (sum > 9) {
				carry = sum / 10;
				sum = sum % 10;
			}
			if (res == null) {
				res = new Node(sum);
				last = res;
			} else {
				last.nextNode = new Node(sum);
				last = last.nextNode;
			}
			revOne = revOne.nextNode;
			revTwo = revTwo.nextNode;

		}
		if (carry > 0) {
			last.nextNode = new Node(carry);
			last = last.nextNode;
		}
		return ListUtil.reverseList(res);
	}

}
