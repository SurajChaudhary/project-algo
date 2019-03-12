package com.devtalk.algorithm.matrix;

public class KnightTourProblem {

	private static int[] R_MOVE = { -1, -2, -2, -1, 1, 2, 2, 1 };
	private static int[] C_MOVE = { -2, -1, 1, 2, 2, 1, -1, -2 };

	public static void main(String[] args) {

		int[][] board = { { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 }

		};
		knightTour(board, 0, 0, 1);

	}

	private static boolean knightTour(int[][] board, int row, int col, int move) {

		if (64 == move) {
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					System.out.print(board[i][j] + " ");
				}
				System.out.println(" ");
			}
			return true;
		} else {
			for (int index = 0; index < R_MOVE.length; index++) {
				int newRow = row + R_MOVE[index];
				int newCol = col + C_MOVE[index];

				if (isMoveValid(board, newRow, newCol)) {
					move++;
					board[newRow][newCol] = move;
					if (knightTour(board, newRow, newCol, move)) {
						return true;
					}
					move--;
					board[newRow][newCol] = 0;
				}
			}
			return false;
		}
	}

	private static boolean isMoveValid(int[][] board, int row, int col) {
		//System.out.println("row :"+ row + " col: "+ col);
		return row >= 0 && col >= 0 && row < 8 && col < 8 && board[row][col] == 0;
	}

}
