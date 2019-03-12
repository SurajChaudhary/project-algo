package com.devtalk.algorithm.queue;

public class ImplementStackUsingSingleQueue {
	
	

	public static void main(String[] args) {
		Stack s = new Stack(); 
        s.push(10); 
        s.push(20); 
        System.out.println("Top element :" + s.top()); 
        s.pop(); 
        s.push(30); 
        s.pop(); 
        System.out.println("Top element :" + s.top()); 

	}
	
	static class Stack {

		Node front;

		public Stack() {
			this.front = null;
		}

		public Node top() {
			return this.front;
		}

		public Node pop() {
			if (this.front == null) {
				System.out.println("Underflow!!!");
				return null;
			} else {
				Node item = this.front;
				this.front = this.front.next;
				return item;
			}

		}

		public void push(int item) {
			if (this.front == null) {
				this.front = new Node(item);
			} else {
				Node frontNode = new Node(item);
				frontNode.next = this.front;
				this.front = frontNode;
			}

		}

		static class Node {
			int data;
			Node next;

			public Node(int data) {
				this.data = data;
				this.next = null;
			}

			@Override
			public String toString() {
				return " " + data + " ";
			}
			
			

		}
	}

}
