package com.devtalk.algorithm.linkedList;

public class TwoNumberSubtractionTest {

	public static void main(String[] args) {
		Node numberOne = ListUtil.getList(9, 0 ,0);
		//ListUtil.print(numberOne);

		Node numberTwo = ListUtil.getList(9, 9);
		//ListUtil.print(numberTwo);

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
			System.out.println("Can not subtract larger number from smaller.");
			return null;
		}
		Node res = null;
		int carry = 0;
		Node last = null;
		while (revOne != null && revTwo != null) {
			int sub = 0;
			revOne.data = revOne.data - carry;
			if (revOne.data >= revTwo.data) {
				sub = revOne.data - revTwo.data;
			} else {
				revOne.data = revOne.data + 10;
				carry++;
				sub = revOne.data - revTwo.data;
			}

			if (res == null) {
				res = new Node(sub);
				last = res;
			} else {
				last.nextNode = new Node(sub);
				last = last.nextNode;
			}
			revOne = revOne.nextNode;
			revTwo = revTwo.nextNode;

		}
		return ListUtil.reverseList(res);
	}

}
