package com.devtalk.algorithm.stack;

import java.util.ListIterator;
import java.util.Stack;

public class SortStackUsingRecursion {

	public static void main(String[] args) {
		Stack<Integer> s = new Stack();
        s.push(30); 
        s.push(-5); 
        s.push(18); 
        s.push(14); 
        s.push(-3); 
       
        System.out.println("Stack elements before sorting: "); 
        printStack(s); 
       
        sortStack(s); 
       
        System.out.println(" \n\nStack elements after sorting:"); 
        printStack(s); 
        
        reverse(s);
        

	}
	private static void reverse(Stack<Integer> st) {
		if(st.isEmpty()) {
			return;
		}
		int c = st.pop();
		reverse(st);
		System.out.println("#####");
		System.out.println(c);
		
	}
	
	private static void sortStack(Stack<Integer> s) {
		if(!s.isEmpty()) {
			int t = s.pop();
			sortStack(s);
			sortedInsert(t,s);
		}
		
	}

	private static void sortedInsert(int t, Stack<Integer> s) {
		if(s.isEmpty() || t > s.peek()) {
			s.push(t);
			return;
		}
		int temp = s.pop();
		sortedInsert(t, s);
		s.push(temp);
		
	}

	// Utility Method to print contents of stack 
    static void printStack(Stack<Integer> s) 
    { 
       ListIterator<Integer> lt = s.listIterator(); 
         
       // forwarding 
       while(lt.hasNext()) 
           lt.next(); 
         
       // printing from top to bottom 
       while(lt.hasPrevious()) 
           System.out.print(lt.previous()+" "); 
    } 

}
