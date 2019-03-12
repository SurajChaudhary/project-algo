package com.devtalk.algorithm.matrix;

public class RatInTheMaze {

	// Moves for rat
	static int[] ROW = { 0, 0, -1, 1 };
	static int[] COL = { -1, 1, 0, 0 };

	static final int ROWS = 4;
	static final int COLS = 4;

	public static void main(String[] args) {
		int[][] maze = { { 1, 1, 0, 1 }, { 0, 1, 1, 1 }, { 0, 1, 0, 1 }, { 0, 1, 1, 1 } };
		int[][] visited = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };
		visited[0][0] = 1;
		// For given starting points
		int startingRow = 0;
		int startingCol = 0;
		findPathInMaze(maze, visited, startingRow, startingCol, 3, 3, 1);
		System.out.println("################");
		System.out.println("################");
		System.out.println("################");
		System.out.println(" ");

		// Solution for all points in maze as starting points, one point at a time
		int[][] visited2 = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };
		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col < COLS; col++) {
				visited2[row][col]++;
				findPathInMaze(maze, visited2, row, col, 3, 3, 1);
				visited2[row][col]--;
			}
		}

	}

	private static void findPathInMaze(int[][] maze, int[][] visited, int row, int col, int desRow, int desCol,
			int move) {

		if (row == desRow && col == desCol) {
			for (int i = 0; i < ROWS; i++) {
				for (int j = 0; j < COLS; j++) {
					System.out.print(visited[i][j] + " ");
				}
				System.out.println(" ");
			}
			System.out.println("################");
		} else {
			for (int index = 0; index < ROW.length; index++) {
				int newRow = row + ROW[index];
				int newCol = col + COL[index];
				if (canRatMove(maze, visited, newRow, newCol)) {
					move++;
					visited[newRow][newCol] = move;
					findPathInMaze(maze, visited, newRow, newCol, desRow, desCol, move);
					move--;
					visited[newRow][newCol] = 0;

				}
			}
		}

	}

	private static boolean canRatMove(int[][] maze, int[][] visited, int row, int col) {
		return row >= 0 && col >= 0 && row < ROWS && col < COLS && maze[row][col] == 1 && visited[row][col] == 0;
	}

}
