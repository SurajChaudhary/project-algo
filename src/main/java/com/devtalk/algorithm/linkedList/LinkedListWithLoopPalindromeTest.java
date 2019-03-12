package com.devtalk.algorithm.linkedList;

import java.util.Stack;

public class LinkedListWithLoopPalindromeTest {
//Given a linked list with a loop, the task is to find whether it is palindrome or not. You are not allowed to remove the loop.
	/*
	 * Input : 1 2 3 2 1 Output: Palindrome
	 * 
	 */
	public static void main(String[] args) {
		Node one = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(2);
		Node five = new Node(1);

		one.nextNode = two;
		two.nextNode = three;
		three.nextNode = four;
		four.nextNode = five;
		five.nextNode = two;

		Node loopNode = detectAndGetLoopNode(one);

		boolean result = isPalindrome(one, loopNode);
		System.out.println("List is palindrome : " + result);

	}

	private static boolean isPalindrome(Node one, Node loopNode) {
		int count = 0;
		Stack<Node> stk = new Stack<Node>();
		Node temp = one;
		while (temp != loopNode || count != 1) {
			stk.push(temp);
			if (temp == loopNode) {
				count = 1;
			}
			temp = temp.nextNode;

		}

		temp = one;
		count = 0;
		while (temp != loopNode || count != 1) {

			if (temp.data == stk.peek().data) {
				stk.pop();
			} else {
				return false;
			}

			if (temp == loopNode) {
				count = 1;
			}
			temp = temp.nextNode;

		}

		return true;
	}

	private static Node detectAndGetLoopNode(Node one) {
		Node slow = one;
		Node fast = one;

		Node res = null;

		while (fast != null && fast.nextNode != null) {
			slow = slow.nextNode;
			fast = fast.nextNode.nextNode;

			if (fast == slow) {
				res = fast;
				break;
			}
		}

		Node curr = one;
		while (curr != res) {
			curr = curr.nextNode;
			res = res.nextNode;
		}
		return curr;
	}

}
