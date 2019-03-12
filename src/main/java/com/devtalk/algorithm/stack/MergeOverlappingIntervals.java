package com.devtalk.algorithm.stack;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class MergeOverlappingIntervals {

	public static void main(String[] args) {
		Interval arr[] = new Interval[4];
		arr[0] = new Interval(6, 8);
		arr[1] = new Interval(1, 9);
		arr[2] = new Interval(2, 4);
		arr[3] = new Interval(4, 7);
		mergeIntervals(arr);

	}

	private static void mergeIntervals(Interval[] arr) {
		// Test if the given set has at least one interval
		if (arr.length <= 0)
			return;

		// Create an empty stack of intervals
		Stack<Interval> stack = new Stack();

		// sort the intervals in increasing order of start time
		Arrays.sort(arr, new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2) {
				return i1.start - i2.start;
			}
		});

		// Push the first interval on to a stack.
		stack.push(arr[0]);
		/*
		 * For each interval do the following 
		 * a. If the current interval does not overlap with the stack top, push it. 
		 * b. If the current interval overlaps with stack top and ending time of current interval is more than that of stack top,
		 * update stack top with the ending time of current interval. 
		 * 4. At the end stack contains the merged intervals.
		 */
		// Start from the next interval and merge if necessary  
        for (int i = 1 ; i < arr.length; i++){  
        	Interval top = stack.peek();
        	if(top.end < arr[i].start) {
        		stack.push(arr[i]);
        	}else if(top.end < arr[i].end){
        		top.end = arr[i].end;
        		stack.pop();
        		stack.push(top);
        	}
        }
        
        while(!stack.isEmpty()) {
        	System.out.println(stack.pop());
        }

	}

}

class Interval {
	int start, end;

	Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public String toString() {
		return "Interval [start=" + start + ", end=" + end + "]";
	}
	
	
}
