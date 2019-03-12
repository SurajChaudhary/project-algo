package com.devtalk.algorithm.linkedList;

public class NodeSwapWithoutData {

	public static void main(String[] args) {
		Node root = ListUtil.getList(15, 18, 5, 8, 11, 12);
		ListUtil.print(root);

		Node result = swapNodes(root, 8, 15);// 15 -> 11 -> 5 -> 8 -> 18 -> 12
		ListUtil.print(result);

	}

	private static Node swapNodes(Node root, int x, int y) {
		Node currX = root;

		Node X = root;
		Node prevX = null;

		while (currX != null && currX.data != x) {
			prevX = currX;
			currX = currX.nextNode;

		}

		X = currX;

		Node Y = root;
		Node prevY = null;
		Node currY = root;

		while (currY != null && currY.data != y) {
			prevY = currY;
			currY = currY.nextNode;

		}

		Y = currY;
		
		if(prevX == null) {
			Node temp = Y.nextNode;
			Node newHead = Y;
			Y.nextNode = X.nextNode;
			prevY.nextNode = X;
			X.nextNode = temp;
			return newHead;
			
		}
		
		if(prevY == null) {
			Node temp = X.nextNode;
			Node newHead = X;
			X.nextNode = Y.nextNode;
			prevX.nextNode = Y;
			Y.nextNode = temp;
			return newHead;
			
		}

		if (prevX != null && prevY != null) {
			Node temp = Y.nextNode;
			prevX.nextNode = Y;
			Y.nextNode = X.nextNode;
			X.nextNode = temp;
			prevY.nextNode = X;
		}
		return root;

	}

}
