package com.devtalk.algorithm.stack;

import java.util.Stack;

public class LargestRectangularAreaInHistogram {

	public static void main(String[] args) {
		int hist[] = { 6, 2, 5, 4, 5, 1, 6 }; 
        System.out.println("Maximum area is " + getMaxArea(hist, hist.length)); 

	}

	private static int getMaxArea(int[] hist, int length) {
		Stack<Integer> st = new Stack();
		
		int max_area = 0;
		int top;
		int areaWithTop;
		
		int i=0;
		
		while(i < length) {
			
			if(st.isEmpty() || hist[st.peek()] <= hist[i]) {
				st.push(i);
				i++;
			}else {
				top = st.peek();
				st.pop();
				
				areaWithTop = hist[top] * (st.isEmpty() ? i : i-st.peek()-1);
				
				if(max_area < areaWithTop) {
					max_area = areaWithTop;
				}
			}
		}
		
		while(!st.isEmpty()) {
			top = st.peek();
			st.pop();
			
			areaWithTop = hist[top] * (st.isEmpty() ? i : i-st.peek()-1);
			
			if(max_area < areaWithTop) {
				max_area = areaWithTop;
			}
		}
		return max_area;
	}

}
