package com.devtalk.algorithm.stack;

import java.util.PriorityQueue;
import java.util.Queue;

public class StackUsingPriorityQueueOrHeap {

	int count = 0;
	Queue<Pair> pq = new PriorityQueue();

	public void push(int n) {
		count++;
		pq.add(new Pair(n, count));
	}

	public Pair pop() {
		if (pq.isEmpty()) {
			System.out.println("Nothing to pop!!!");
			return null;
		}
		count--;
		return pq.poll();
	}
	
	public Pair top() {
		if (pq.isEmpty()) {
			System.out.println("Nothing to peek!!!");
			return null;
		}
		return pq.peek();
	}
	
	public boolean isEmpty() {
		return pq.isEmpty();
	}

	public static void main(String[] args) {
		StackUsingPriorityQueueOrHeap s=new StackUsingPriorityQueueOrHeap(); 
	    s.push(1); 
	    s.push(2); 
	    s.push(3); 
	    while(!s.isEmpty()){ 
	        System.out.println(s.top()); 
	        s.pop(); 
	    } 

	}

	class Pair implements Comparable<Pair> {
		int key;
		int value;

		public Pair(int key, int value) {
			super();
			this.key = key;
			this.value = value;
		}

		@Override
		public int compareTo(Pair o) {
			return o.value - this.value;
		}

		@Override
		public String toString() {
			return "Pair [key=" + key + "]";
		}
		
		
	}

}
