package com.devtalk.algorithm.number;

public class SwapTwoNumbersTest {

	public static void main(String[] args) {
		swapNumbers(10, 20);
		System.out.println("##############");
		swapNumbersWithoutTemp(10, 20);
		System.out.println("##############");
		swapNumbersWithXOR(10, 20);
	}

	public static void swapNumbers(int a, int b) {

		System.out.println("a : " + a + " b : " + b);
		int temp = a;
		a = b;
		b = temp;
		System.out.println("a : " + a + " b : " + b);
	}

	public static void swapNumbersWithoutTemp(int a, int b) {

		System.out.println("a : " + a + " b : " + b);
		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println("a : " + a + " b : " + b);
	}

	public static void swapNumbersWithXOR(int a, int b) {

		System.out.println("a : " + a + " b : " + b);
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		System.out.println("a : " + a + " b : " + b);
	}

}
