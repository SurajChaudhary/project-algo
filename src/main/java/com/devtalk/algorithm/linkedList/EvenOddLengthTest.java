package com.devtalk.algorithm.linkedList;


public class EvenOddLengthTest {

	public static void main(String[] args) {
		Node oddRoot = ListUtil.getList(1, 2, 3, 4, 5);
		System.out.print(isListEvenLengthOrOdd(oddRoot));
		ListUtil.print(oddRoot);
		System.out.println("Length is : " + ListUtil.getLength(oddRoot));
		
		System.out.println("");
		
		Node evenRoot = ListUtil.getList(1, 2, 3, 4, 5, 6);
		System.out.print(isListEvenLengthOrOdd(evenRoot));
		ListUtil.print(evenRoot);
		System.out.println("Length is : " + ListUtil.getLength(evenRoot));

	}

	public static String isListEvenLengthOrOdd(Node root) {
		String result = "";
		Node curr = root;
		while (true) {
			if (curr == null) {
				result = "Even";
				break;
			}
			if (curr.nextNode == null) {
				result = "Odd";
				break;
			}
			curr = curr.nextNode.nextNode;
		}
		return result;
	}

}
