package com.devtalk.algorithm.stack;

public class StackWithOperationsOnMiddleElement {
	int top;
	LL head;
	int max;
	
	public StackWithOperationsOnMiddleElement(int max) {
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
	
	public int getMiddle() {
		LL temp = head;
		LL slow = temp;
		LL fast = temp;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow.data;
	}
	
	public void removeMiddle() {
		LL temp = head;
		LL slow = temp;
		LL fast = temp;
		LL prev = null;
		
		while(fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		prev.next = prev.next.next;
	}
	

	public static void main(String[] args) {
		StackWithOperationsOnMiddleElement ob = new StackWithOperationsOnMiddleElement(10); 
        ob.push( 11); 
        ob.push( 22); 
        ob.push( 33); 
        ob.push( 44); 
        ob.push( 55); 
        ob.push( 66); 
        ob.push( 77); 
          
        System.out.println("Item popped is " + ob.pop()); 
        System.out.println("Item popped is " + ob.pop()); 
        System.out.println("Middle Element is " + ob.getMiddle()); 

	}

}
