package com.devtalk.algorithm.linkedList;

public class DeleteNodeTest {

	public static void main(String[] args) {
		Node root = ListUtil.getList(1, 2, 3, 4, 5);
		ListUtil.print(root);
		
		Node res = delete(root, 9);
		ListUtil.print(res);

	}

	private static Node delete(Node root, int data) {
		
		if(root.data == data) {
			root = root.nextNode;
			return root;
		}
		Node curr = root;
		Node prev = null;
		while(curr.nextNode != null) {
			if(curr.data == data) {
				prev.nextNode = curr.nextNode;
				return root;
			}
			prev = curr;
			curr = curr.nextNode;
		}
		
		if(curr.data == data) {
			prev.nextNode = null;
		}
		return root;
	}

}
