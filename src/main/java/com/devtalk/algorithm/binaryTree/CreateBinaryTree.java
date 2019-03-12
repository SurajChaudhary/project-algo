package com.devtalk.algorithm.binaryTree;

public class CreateBinaryTree {
	public static void main(String[] args) {
		BTNode root = BTUtil.getTree(1, 2, 3);
		BTUtil.print(root);
		System.out.println("*********");
		BTUtil.addNode(root, new BTNode(4));
		BTUtil.addNode(root, new BTNode(5));
		BTUtil.addNode(root, new BTNode(6));
		BTUtil.addNode(root, new BTNode(7));
		BTUtil.addNode(root, new BTNode(8));
		BTUtil.print(root);
		System.out.println("***********");
		BTUtil.deleteNode(root, 2);
		BTUtil.print(root);
	}
}
