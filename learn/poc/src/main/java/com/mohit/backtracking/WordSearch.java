package com.mohit.backtracking;

import static org.junit.Assert.assertTrue;

public class WordSearch {

	public static void main(String[] args) {
		WordSearchSolution sol = new WordSearchSolution();

		char[][] board = new char[][] { 
			{ 'A', 'B', 'C', 'E' }, 
			{ 'S', 'F', 'C', 'S' }, 
			{ 'A', 'D', 'E', 'E' } 
		};

//		assertTrue(sol.exist(board, "ABCCEES"));
		assertTrue(sol.exist(board, "ABCCEESE"));
		
		System.out.println("All passed " + sol.getClass().getSimpleName());
	}

}

class WordSearchSolution {

	int[][] moves = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, };

	public boolean exist(char[][] board, String word) {

		if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0) {
			return false;
		}

		int rows = board.length;
		int cols = board[0].length;

		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				if (word.charAt(0) == board[r][c]) {
					boolean[][] traversed = new boolean[rows][cols];
					traversed[r][c] = true;
					if (checkWord(board, traversed, r, c, word, 0)) {
						return true;
					}
					traversed[r][c] = false;
				}
			}
		}

		return false;

	}

	private boolean checkWord(char[][] board, boolean[][] traversed, int row, int col, String word, int index) {

		if (index == word.length()) {
			return true;
		}

		if (board[row][col] != word.charAt(index)) {
			return false;
		} else if (index == word.length()-1) {
			return true;
		}

		for (int[] move : moves) {
			int newRow = move[0] + row;
			int newCol = move[1] + col;

			if (inBoundsAndUntraversed(board, traversed, newRow, newCol)) {
				traversed[newRow][newCol] = true;
				if (checkWord(board, traversed, newRow, newCol, word, index + 1)) {
					return true;
				}
				traversed[newRow][newCol] = false;
			}
		}
		return false;
	}

	private boolean inBoundsAndUntraversed(char[][] board, boolean[][] traversed, int row, int col) {
		if (row >= 0 && row < board.length && col >= 0 && col < board[0].length && !traversed[row][col]) {
			return true;
		}
		return false;
	}

}