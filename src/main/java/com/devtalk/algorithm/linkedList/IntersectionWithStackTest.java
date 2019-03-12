package com.devtalk.algorithm.linkedList;

import java.util.Stack;

import com.devtalk.algorithm.doublyLinkedList.ListUtil;
import com.devtalk.algorithm.doublyLinkedList.Node;

public class IntersectionWithStackTest {

	public static void main(String[] args) {
		Node firstRoot = ListUtil.getList(1, 2, 3, 4, 5);
		Node secondRoot = ListUtil.getList(6, 7, 8);

		Node commonRoot = ListUtil.getList(9, 10, 11, 12);
		ListUtil.print(commonRoot);

		Node curr = firstRoot;
		while (curr.next != null) {
			curr = curr.next;
		}
		curr.next = commonRoot;
		ListUtil.print(firstRoot);

		Node temp = secondRoot;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = commonRoot;
		ListUtil.print(secondRoot);

		System.out.println("Intersection node point : " + getIntersectionNodeWithStacks(firstRoot, secondRoot));

	}

	private static Node getIntersectionNodeWithStacks(Node firstRoot, Node secondRoot) {
		Stack<Node> firstStack = new Stack<Node>();
		Stack<Node> secondStack = new Stack<Node>();

		Node firstcurr = firstRoot;
		while (firstcurr != null) {
			firstStack.push(firstcurr);
			firstcurr = firstcurr.next;
		}

		Node secondcurr = secondRoot;
		while (secondcurr != null) {
			secondStack.push(secondcurr);
			secondcurr = secondcurr.next;
		}
		
		Node temp = null;
		while (!firstStack.isEmpty() && !secondStack.isEmpty()) {
			Node one = firstStack.pop();
			Node two = secondStack.pop();
			if (one.equals(two)) {
				temp = one;
			} else {
				break;
			}
		}
		return temp;
	}

}
