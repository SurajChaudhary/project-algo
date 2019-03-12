package com.devtalk.algorithm.matrix;

import java.util.Arrays;
import java.util.List;

public class BoogleDictionary {
	/*
	 * If board expands to lets say 4*4 or 6*6, then possible move for ROW and COL arrays will also increase accordingly.following array
	 * will change :
	 * static int[] ROW = { -1,-1,-1,0,0,1,1,1 };
	 * static int[] COL = {  0,1,-1,-1,1,-1,0,1 };
	 * Above array shows possible (x,y) coordinates, where a word can move to form a new word. 
	 */

	static int[] ROW = { -1,-1,-1,0,0,1,1,1 };
	static int[] COL = {  0,1,-1,-1,1,-1,0,1 };
	
	static final int ROWS = 3;
	static final int COLS = 3;
	

	public static void main(String[] args) {
		String[][] board = { 
								{ "F", "O", "B" }, 
								{ "O", "A", "E" }, 
								{ "K", "S", "C" }
							};
		boolean[][] visited = { { false, false, false }, { false, false, false }, { false, false, false } };
		List<String> dictionary = Arrays.asList("FACE", "BOOK", "ACE", "BOOKS", "ACES","LOOK","LOOT","SLAK");

		String word = "";

		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col < COLS; col++) {
				visited[row][col] = true;
				findWords(board, visited, row, col, word + board[row][col], dictionary);
				visited[row][col] = false;
			}
		}

	}

	private static void findWords(String[][] board, boolean[][] visited, int row, int col, String word,
			List<String> dictionary) {
		
		if (dictionary.contains(word)) {
			System.out.println(word);
		}
		if (ROWS * COLS == word.length()) {
			return;
		}
		for (int i = 0; i < ROW.length; i++) {

			int newRow = row + ROW[i];
			int newCol = col + COL[i];
			{
				if (isValidPosition(newRow, newCol, visited)) {
					visited[newRow][newCol] = true;
					findWords(board, visited, newRow, newCol, word + board[newRow][newCol], dictionary);
					visited[newRow][newCol] = false;
				}
			}

		}

	}

	private static boolean isValidPosition(int row, int col, boolean[][] visited) {
		return row >= 0 && col >= 0 && row < ROWS && col < COLS && !visited[row][col];
	}

}
