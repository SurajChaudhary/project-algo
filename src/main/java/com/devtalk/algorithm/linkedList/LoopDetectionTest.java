package com.devtalk.algorithm.linkedList;

public class LoopDetectionTest {

	public static void main(String[] args) {

		Node one = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		Node five = new Node(5);
		Node six = new Node(6);
		Node seven = new Node(7);
		Node eight = new Node(8);
		Node nine = new Node(9);

		one.nextNode = two;
		two.nextNode = three;
		three.nextNode = four;
		four.nextNode = five;
		five.nextNode = six;
		six.nextNode = seven;
		seven.nextNode = eight;
		eight.nextNode = nine;
		nine.nextNode = five;

		Node loopNode = loopNode(one);
		if (loopNode != null) {
			Node loopStartNode = getStartOfLoop(one, loopNode);
			System.out.println(loopStartNode);
			System.out.println("Loop count : " + getloopCount(loopNode));
			removeLoop(one, loopNode);
		}
		ListUtil.print(one);

	}

	private static int getloopCount(Node loopNode) {
		int count = 1;

		Node p = loopNode.nextNode;
		while (p != loopNode) {
			p = p.nextNode;
			count++;
		}

		return count;
	}

	private static void removeLoop(Node one, Node loopNode) {
		Node p = one;
		Node q = loopNode;
		while (p.nextNode != q.nextNode) {
			p = p.nextNode;
			q = q.nextNode;
		}
		q.nextNode = null;

	}

	private static Node getStartOfLoop(Node one, Node loopNode) {
		Node p = one;
		Node q = loopNode;

		while (p != q) {
			p = p.nextNode;
			q = q.nextNode;
		}
		return p;
	}

	private static Node loopNode(Node one) {
		Node slow = one;
		Node fast = one;

		while (fast != null && fast.nextNode != null) {

			slow = slow.nextNode;
			fast = fast.nextNode.nextNode;
			if (slow == fast) {
				System.out.println("Loop present at Node : " + slow);
				return slow;
			}
		}
		return null;
	}
}
