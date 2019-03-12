package com.devtalk.algorithm.stack;

public class StackWithLinkedList {
	int top;
	LL head;
	int max;
	
	public StackWithLinkedList(int max) {
		this.max = max;
		this.top = 0;
	}
	
	public boolean isEmpty() {
		return head == null ? true : false;
	}
	
	public  void push(int data) {
		if(top >= max) {
			System.out.println("Overflow!!!");
			return;
		}
		if (head == null) {
			head = new LL(data);
		} else {
			LL node = new LL(data);
			node.next = head;
			head = node;
		}
		top++;
	}
	
	public int pop() {
		if(isEmpty()) {
			System.out.println("Underflow!!!!");
			return 0;
		}
		int node = head.data;
		head = head.next;
		top--;
		return node;
	}
	
	public int size() {
		LL temp = head;
		int count = 0;
		while (temp != null) {
			count++;
			temp = temp.next;
		}
		return count;
	}

	public int peek() {
		if (isEmpty()) {
			System.out.println("Stack is empty");
			return 0;
		} else {
			return head.data;
		}
	}
	

	

}

class LL {
	int data;
	LL next;

	public LL(int data) {
		this.data = data;
		this.next = null;
	}

	@Override
	public String toString() {
		return "LL [data=" + data + "]";
	}

}
