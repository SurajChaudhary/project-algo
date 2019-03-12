package com.devtalk.algorithm.number;

public class PrimeNumberTest {

	public static void main(String[] args) {

		long start = System.currentTimeMillis();
		System.out.println("Is 2 a prime : " + isPrimeByDivision(2));
		System.out.println("Is 121 a prime : " + isPrimeByDivision(121));
		System.out.println("Is 3 a prime : " + isPrimeByDivision(3));
		System.out.println("Is 29 a prime : " + isPrimeByDivision(29));
		System.out.println("Time taken1 :"+ (System.currentTimeMillis() - start));
		System.out.println("###################");
		start = System.currentTimeMillis();
		System.out.println("Is 2 a prime : " + isPrimeBySqrt(2));
		System.out.println("Is 121 a prime : " + isPrimeBySqrt(121));
		System.out.println("Is 3 a prime : " + isPrimeBySqrt(3));
		System.out.println("Is 29 a prime : " + isPrimeBySqrt(29));
		System.out.println("Time taken2 :"+ (System.currentTimeMillis() - start));
		System.out.println("###################");
		start = System.currentTimeMillis();
		System.out.println("Is 2 a prime : " + isPrimeBySchoolMethod(2));
		System.out.println("Is 121 a prime : " + isPrimeBySchoolMethod(121));
		System.out.println("Is 3 a prime : " + isPrimeBySchoolMethod(3));
		System.out.println("Is 29 a prime : " + isPrimeBySchoolMethod(29));
		System.out.println("Time taken3 :"+ (System.currentTimeMillis() - start));

	}

	public static boolean isPrimeByDivision(int number) {
		if (number < 1) {
			return false;
		}

		int count = 2;
		int flag = number;
		while (count < flag) {
			if ((number % count) == 0) {
				return false;
			}
			count++;
		}
		return true;

	}

	public static boolean isPrimeBySqrt(int number) {
		if (number < 1) {
			return false;
		}

		int flag = (int) Math.floor(Math.sqrt(number));
		for (int i = 2; i <= flag; i++) {
			if ((number % i) == 0) {
				return false;
			}
		}

		return true;

	}

	public static boolean isPrimeBySchoolMethod(int number) {
		if (number <= 1) {
			return false;
		}
		if (number <= 3) {
			return true;
		}

		if (number % 2 == 0 || number % 3 == 0) {
			return false;
		}

		for (int i = 5; i * i <= number; i = i + 6) {
			if (number % i == 0 || number % (i + 2) == 0) {
				return false;
			}
		}

		return true;

	}

}
