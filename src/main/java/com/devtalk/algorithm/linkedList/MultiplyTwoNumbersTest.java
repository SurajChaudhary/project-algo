package com.devtalk.algorithm.linkedList;

public class MultiplyTwoNumbersTest {

	/*
	 * Input : 
	 * 9->4->6 
	 * 8->4 
	 * Output : 79464
	 */

	public static void main(String[] args) {
		Node num1 = ListUtil.getList(9,4,6);
		Node num2 = ListUtil.getList(8,4);
		
		int result = multiply(num1,num2);
		System.out.println("Multiplication is : "+ result);

	}

	private static int multiply(Node first, Node second) {
		int num1 = 0, num2 = 0; 
		while (first != null || second != null) 
	    { 
	        if (first != null) 
	        { 
	            num1 = num1*10 + first.data; 
	            first = first.nextNode; 
	        } 
	        if (second != null) 
	        { 
	            num2 = num2*10 + second.data; 
	            second = second.nextNode; 
	        } 
	    } 
	  
	    // Return multiplication of  
	    // two numbers 
	    return num1*num2; 
	}

}
