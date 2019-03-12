package com.devtalk.algorithm.linkedList;

/*
 * Move all occurrences of an element to end in a linked list
	Given a linked list and a key in it, the task is to move all occurrences 
	of given key to end of linked list, keeping order of all other elements same.
	Input  : 1 -> 2 -> 2 -> 4 -> 3
         key = 2 
	Output : 1 -> 4 -> 3 -> 2 -> 2
	
	Input  : 6 -> 6 -> 7 -> 6 -> 3 -> 10
	         key = 6
	Output : 7 -> 3 -> 10 -> 6 -> 6 -> 6
 */
public class MoveAllOccurrencesToEndTest {

	public static void main(String[] args) {
		Node root = ListUtil.getList(6,6,7,6,3,10);
		ListUtil.print(root);
		int key = 6;
		moveToEndII(root, key);
		
	}

	private static void moveToEnd(Node root, int key) {
		Node curr = root;
		
		Node last = curr;
		
		while(last.nextNode != null) {
			last = last.nextNode;
		}
		
		Node tail = last;
		
		Node prev = null;
		
		while(curr != last) {
			if(curr.data == key) {
				if(prev == null) {
					Node temp = curr;
					curr = curr.nextNode;
					tail.nextNode = temp;
					tail = tail.nextNode;
					tail.nextNode = null;
					root = curr;
				}else {
					Node temp = curr;
					curr = curr.nextNode;
					prev.nextNode = curr;
					
					tail.nextNode = temp;
					tail = tail.nextNode;
					tail.nextNode = null;
					
				}
				
			}else {
				prev = curr;
				curr = curr.nextNode;
			}
			
		}
		
		ListUtil.print(root);

	}
	
	private static void moveToEndII(Node root, int key) {
		Node curr = root;
		Node prev = null;
		Node keyList = null;
		Node tail = null;
		
		while(curr != null) {
			if(curr.data == key) {
				if(keyList == null) {
					keyList = new Node(curr.data);
					tail = keyList;
				}else {
					tail.nextNode = new Node(curr.data);
					tail = tail.nextNode;
				}
				
				if(prev == null) {
					curr = curr.nextNode;
					root = curr;
					prev = curr;
				}else {
					curr = curr.nextNode;
					prev.nextNode = curr;
				}
				
			}else {
			curr = curr.nextNode;
			}
			
		}
		
		
		
		ListUtil.print(root);

	}

}
