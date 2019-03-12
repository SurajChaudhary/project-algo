package com.devtalk.algorithm.binaryTree;

public class CalculateDepthOfFullBinaryTreeFromPreorder {

	public static void main(String[] args) {
		String tree = "nlnnlll";
		int n = tree.length();
		System.out.println(findDepth(tree, n));

	}

	private static int findDepth(String tree, int length) {
		int index = 0;
		return findDepthRecur(tree, length, index);
	}

	private static int findDepthRecur(String tree, int length, int index) {

		if (index >= length || tree.charAt(index) == 'l') {
			return 0;
		}
		// calc height of left subtree (In preorder left subtree is processed before right)
		index++;
		int left = findDepthRecur(tree,length,index);
		// calc height of right subtree 
		index++;
		int right = findDepthRecur(tree,length,index);
		return Math.max(left, right)+1;
		
	}

}
