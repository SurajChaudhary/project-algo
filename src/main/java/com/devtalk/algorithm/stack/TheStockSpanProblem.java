package com.devtalk.algorithm.stack;

import java.util.Arrays;
import java.util.Stack;

public class TheStockSpanProblem {
	/*
	 * We will push indexes on to stack.
	 * Starting with 0.
	 * Then will compare the price at index on top of stack and the price in array.
	 * If price at index on top of stack is less, we will keep popping
	 * till we get an index on top of stack where price is greater or stack goes empty.
	 * Span is calculated as:
	 * If stack goes empty, that means no index before the current one had greater value hence curr_Index+1
	 * else, curr_Index - index on top of stack where price was greater.
	 */

	public static void main(String[] args) {
		int price[] = {10, 4, 5, 90, 120, 80}; 
		// o/p: 1 1 2 4 5 1
        int n = price.length; 
        int S[]=new int[n]; 
          
        // Fill the span values in array S[] 
        calculateSpan(price, n, S); 
  
        // print the calculated span values 
        printArray(S); 

	}
	
	// a linear time solution for stock span problem 
    // A stack based efficient method to calculate  
    // stock span values 
    static void calculateSpan(int price[], int n, int S[]) 
    { 
        // Create a stack and push index of first element 
        // to it 
        Stack<Integer> st= new Stack();
        st.push(0);  
          
        // Span value of first element is always 1 
        S[0] = 1; 
          
        // Calculate span values for rest of the elements 
        for (int i = 1; i < n; i++) 
        { 
  
            // Pop elements from stack while stack is not  
            // empty and top of stack is smaller than  
            // price[i] 
            while (!st.empty() && price[st.peek()] <= price[i]) 
                st.pop(); 
      
            // If stack becomes empty, then price[i] is  
            // greater than all elements on left of it, i.e.,  
            // price[0], price[1],..price[i-1]. Else price[i] 
            // is greater than elements after top of stack 
            S[i] = (st.empty())? (i + 1) : (i - st.peek()); 
      
            // Push this element to stack 
            st.push(i); 
        } 
    } 
	
	// A utility function to print elements of array 
    static void printArray(int arr[]) 
    { 
        System.out.print(Arrays.toString(arr)); 
    } 

}
