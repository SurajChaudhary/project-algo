package com.devtalk.algorithm.matrix;

public class NQueenProblem {

	public static void main(String[] args) {
		boolean[][] board = { 
								{ false, false, false, false, false, false, false, false },
								{ false, false, false, false, false, false, false, false },
								{ false, false, false, false, false, false, false, false },
								{ false, false, false, false, false, false, false, false },
								{ false, false, false, false, false, false, false, false },
								{ false, false, false, false, false, false, false, false },
								{ false, false, false, false, false, false, false, false },
								{ false, false, false, false, false, false, false, false } 
							};
		placeQueen(board, -1);
	}

	private static boolean placeQueen(boolean[][] board, int row) {

		if (row == board.length - 1) {
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board.length; j++) {
					System.out.print(board[i][j] + " ");
				}
				System.out.println(" ");
			}
			return true;
		} else {
			for (int col = 0; col < board.length; col++) {
				int newRow = row + 1;
				if (canPlace(board, newRow, col)) {
					board[newRow][col] = true;

					if (placeQueen(board, newRow)) {
						return true;
					}
					board[newRow][col] = false;
				}
			}
			return false;
		}

	}

	private static boolean canPlace(boolean[][] board, int row, int col) {
		boolean flag = true;
		for (int i = 0; i < board.length; i++) {
			if (board[i][col]) {
				flag = false;
			}
		}

		for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j]) {
				flag = false;
			}
		}

		for (int i = row, j = col; i >= 0 && j < board.length; i--, j++) {
			if (board[i][j]) {
				flag = false;
			}
		}

		return flag;
	}

}
