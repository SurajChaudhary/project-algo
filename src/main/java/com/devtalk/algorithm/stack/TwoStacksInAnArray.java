package com.devtalk.algorithm.stack;

public class TwoStacksInAnArray {

	int top1;
	int top2;
	int arr[];
	int size;

	public TwoStacksInAnArray(int n) {
		arr = new int[n];
		size = n;
		top1 = -1;
		top2 = size;
	}

	public void push1(int data) {
		if (top1 < top2 - 1) {
			top1++;
			arr[top1] = data;
		} else {
			System.out.println("Overflow in stack 1!!!");
		}
	}

	public void push2(int data) {
		if (top1 < top2 - 1) {
			top2--;
			arr[top2] = data;
		} else {
			System.out.println("Overflow in stack 2!!!");
		}
	}
	
	public int pop1() {
		if(top1 > 0) {
			return arr[top1--];
		}else {
			System.out.println("Stack1 underflow!!");
			return -1;
		}
	}
	
	public int pop2() {
		if(top2 < size) {
			return arr[top2++];
		}else {
			System.out.println("Stack2 underflow!!");
			return -1;
		}
	}


	public static void main(String[] args) {
		TwoStacksInAnArray ts = new TwoStacksInAnArray(5); 
        ts.push1(5); 
        ts.push2(10); 
        ts.push2(15); 
        ts.push1(11); 
        ts.push2(7); 
        System.out.println("Popped element from" + 
                           " stack1 is " + ts.pop1()); 
        ts.push2(40); 
        System.out.println("Popped element from" + 
                         " stack2 is " + ts.pop2()); 

	}

}
