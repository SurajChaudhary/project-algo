package com.devtalk.algorithm.binaryTree;

public class GivenLevelOrderTraversalOfBinaryTreeCheckIfTheTreeIsAMinHeap {

	public static void main(String[] args) {
		// Level order traversal
		int[] level = new int[] { 10, 15, 14, 25, 30 };

		if (isMinHeap(level))
			System.out.println("True");
		else
			System.out.println("False");

	}

	private static boolean isMinHeap(int[] level) {
		for (int i = 0; i < level.length / 2; i++) {
			int index1 = 2 * i + 1;
			int index2 = 2 * i + 2;
			if (index1 <= level.length && level[i] > level[index1]) {
				return false;
			}
			if (index2 <= level.length && level[i] > level[index2]) {
				return false;
			}
		}
		return true;
	}

}
