package com.devtalk.algorithm.string;

public class PermutationOfStringUsingRecursion {

	public static void main(String[] args) {
		char[] characters = "ABCDEFG".toCharArray();
		int[] count = new int[characters.length];
		for (int i = 0; i < count.length; i++) {
			count[i] = 1;
		}
		char[] result = new char[characters.length];
		permute(characters, count, result, 0);

	}

	private static void permute(char[] characters, int[] count, char[] result, int level) {
		// If level of recursion becomes equal to size of result array, that means
		// permutation is
		// achieved for that recursion flow/stack, hence print it.
		if (level == result.length) {
			for (char c : result) {
				System.out.print(c);
			}
			System.out.println(" ");
			return;
		}
		// generate permutation for each character in input array
		for (int i = 0; i < characters.length; i++) {
			// check for count of the character, if its zero then skip that character
			if (count[i] == 0) {
				continue;
			} else {
				// populate result array withat character at given level of recursion
				result[level] = characters[i];
				count[i]--;
				permute(characters, count, result, level + 1);
				// restore count post recursion
				count[i]++;
			}
		}

	}
}
