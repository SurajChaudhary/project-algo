package com.devtalk.algorithm.queue;

import java.util.LinkedList;
import java.util.Queue;

public class GenerateBinaryNumbersFromOneToN {

	public static void main(String[] args) {
		int n = 10;
		generatePrintBinary(n);
	}

	private static void generatePrintBinary(int n) {

		Queue<String> q = new LinkedList<String>();
		q.add("1");
		
		while(n-- > 0) {
			
			String s1 = q.remove();
			System.out.println(s1);
			
			String s2 = s1;
			
			q.add(s2+"0");
			q.add(s2+"1");
			
		}

	}

}
