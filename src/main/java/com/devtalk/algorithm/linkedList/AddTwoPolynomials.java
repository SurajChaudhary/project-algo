package com.devtalk.algorithm.linkedList;

public class AddTwoPolynomials {

	/*
	 * Adding two polynomials using Linked List Given two polynomial numbers
	 * represented by a linked list. Write a function that add these lists means add
	 * the coefficients who have same variable powers.
	 * 
	 * Example:
	 * 
	 * Input: 1st number = 5x^2 + 4x^1 + 2x^0 2nd number = 5x^1 + 5x^0 Output:
	 * 5x^2+9x^1 + 7x^0
	 * 
	 * Input: 1st number = 5x^3 + 4x^2 + 2x^0 2nd number = 5x^1 + 5x^0 
	 * Output: 5x^3 + 4x^2 + 5x^1 + 7x^0
	 */

	public static void main(String[] args) {
		PolyNode firstNumber = new PolyNode(5, 3);
		PolyNode x = new PolyNode(4, 2);
		firstNumber.next = x;
		x.next = new PolyNode(2, 0);
		
		PolyNode secondNumber = new PolyNode(5, 1);
		secondNumber.next = new PolyNode(5, 0);
		PolyNode res = null;
		PolyNode last = null;
		while (firstNumber != null && secondNumber != null) {
			if (firstNumber.pow == secondNumber.pow) {
				if (res == null) {
					res = new PolyNode(firstNumber.data + secondNumber.data, firstNumber.pow);
					last = res;
				} else {
					last.next = new PolyNode(firstNumber.data + secondNumber.data, firstNumber.pow);
					last = last.next;
				}
				firstNumber = firstNumber.next;
				secondNumber = secondNumber.next;
			} else if (firstNumber.pow > secondNumber.pow) {
				if (res == null) {
					res = new PolyNode(firstNumber.data, firstNumber.pow);
					last = res;
				} else {
					last.next = new PolyNode(firstNumber.data, firstNumber.pow);
					last = last.next;
				}
				firstNumber = firstNumber.next;
			} else {
				if (res == null) {
					res = new PolyNode(secondNumber.data, secondNumber.pow);
					last = res;
				} else {
					last.next = new PolyNode(secondNumber.data, secondNumber.pow);
					last = last.next;
				}
				secondNumber = secondNumber.next;
			}

		}
		
		if(firstNumber != null) {
			last.next = firstNumber;
			
		}
		if(secondNumber != null) {
			last.next = secondNumber;
			
		}
		PolyNode curr = res;
		while(curr != null) {
			System.out.println("Data : "+ curr.data + " x^"+curr.pow);
			curr = curr.next;
		}
	}

}

class PolyNode {
	int data;
	int pow;
	PolyNode next;

	public PolyNode(int data, int pow) {
		super();
		this.data = data;
		this.pow = pow;
		this.next = null;
	}

}
