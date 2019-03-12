package com.devtalk.algorithm.string;

public class PermutationOfString {

	public static void main(String[] args) {
		String str = "ABC"; 
        int n = str.length(); 
        permute(str, 0, n-1); 

	}

	private static void permute(String str, int start, int end) {
		if (start == end) {
            System.out.println(str);
		}else {
			for (int i = start; i <= end; i++) {
				str = swap(str,start,i);
				permute(str, start+1, end);
				str = swap(str,start,i);
			}
		}
		
	}

	private static String swap(String str, int start, int i) {
		char[] charArray = str.toCharArray();
        char temp = charArray[start] ; 
        charArray[start] = charArray[i]; 
        charArray[i] = temp; 
        return String.valueOf(charArray); 
	}

}
