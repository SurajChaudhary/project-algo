package com.devtalk.algorithm.linkedList;

public class IntersectionWithLengthTest {

	public static void main(String[] args) {
		Node firstRoot = ListUtil.getList(1, 2, 3, 4, 5);
		Node secondRoot = ListUtil.getList(6, 7, 8);

		Node commonRoot = ListUtil.getList(9, 10, 11, 12);
		ListUtil.print(commonRoot);

		Node curr = firstRoot;
		while (curr.nextNode != null) {
			curr = curr.nextNode;
		}
		curr.nextNode = commonRoot;
		ListUtil.print(firstRoot);

		Node temp = secondRoot;
		while (temp.nextNode != null) {
			temp = temp.nextNode;
		}
		temp.nextNode = commonRoot;
		ListUtil.print(secondRoot);

		System.out.println("Intersection node point : " + getIntersectionNodeWithLength(firstRoot, secondRoot));

	}

	private static Node getIntersectionNodeWithLength(Node firstRoot, Node secondRoot) {
		int lenghtOne = ListUtil.getLength(firstRoot);
		int lengthTwo = ListUtil.getLength(secondRoot);

		int diff = Math.abs(lenghtOne - lengthTwo);

		for (int i = 0; i < diff; i++) {
			firstRoot = firstRoot.nextNode;
		}

		while (firstRoot != null && secondRoot != null) {
			if (firstRoot == secondRoot) {
				return firstRoot;
			}
			firstRoot = firstRoot.nextNode;
			secondRoot = secondRoot.nextNode;

		}
		return null;
	}

}
