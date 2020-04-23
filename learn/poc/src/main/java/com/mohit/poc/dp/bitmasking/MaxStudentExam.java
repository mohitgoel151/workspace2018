package com.mohit.poc.dp.bitmasking;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/maximum-students-taking-exam/
 * 
 * Given a m * n matrix seats  that represent seats distributions in a classroom. If a seat is broken, it is denoted by '#' character otherwise it is denoted by a '.' character.

Students can see the answers of those sitting next to the left, right, upper left and upper right, but he cannot see the answers of the student sitting directly in front or behind him. Return the maximum number of students that can take the exam together without any cheating being possible..

Students must be placed in seats in good condition.
 */
public class MaxStudentExam {

	public static void main(String[] args) {
		
		MaxStudentExamSol sol = new MaxStudentExamSol();
		
		String[][] input = new String[][] {
			{".",".",".",".","#",".",".","."},
			{".",".",".",".",".",".",".","."},
			{".",".",".",".",".",".",".","."},
			{".",".",".",".",".",".","#","."},
			{".",".",".",".",".",".",".","."},
			{".",".","#",".",".",".",".","."},
			{".",".",".",".",".",".",".","."},
			{".",".",".","#",".",".","#","."}			
		};
		assertEquals(31, sol.maxStudents(input));
		
		input = new String[][] {
			{"#",".","#","#",".","#"},{".","#","#","#","#","."},{"#",".","#","#",".","#"}
		};
		assertEquals(4, sol.maxStudents(input));
	}

}

/*
 * Best way to solve this type of problem is bit masking.
 * 
 * But here i am trying to mimic something like that.
 * 
 * As student can see at upper and current row seats we need to maintain the state of only these 2 rows (upper and current (to what ever point its filled))
 * this state is working as cache key for us.
 * 
 * value in key is the count of max student which can be allowed in remaining columns of current row and below rows. (Bottom up DP)
 */
class MaxStudentExamSol {

	int[][] visibility = new int[][] { { 0, 1 }, { 0, -1 }, { -1, 1 }, { -1, -1 }, };

	public int maxStudents(String[][] seats) {

		if (seats == null || seats.length == 0) {
			return 0;
		}

		int rows = seats.length;
		int columns = seats[0].length;

		Boolean[][] traversed = new Boolean[rows][columns];

		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < columns; c++) {
				if ("#".equals(seats[r][c])) {
					traversed[r][c] = null;
				} else {
					traversed[r][c] = false;
				}
			}
		}

		return helper(seats, traversed, 0, 0, 0, new HashMap<>());

	}

	private int helper(String[][] seats, Boolean[][] traversed, int row, int col, int count, Map<Integer, Integer> cache) {

		int key = getKey(traversed, row, col);
		Integer cacheVal = cache.get(key);
		if (cacheVal != null) {
			/*
			 * cache value if max student that can be accommodate in remaining rows and vacant seats on right side.
			 */
			return cacheVal + count;
		}

		int result = count;
		for (int r = row; r < seats.length; r++) {
			int c;
			if (row == r) {
				c = col;
			} else {
				c = 0;
			}
			for (; c < seats[0].length; c++) {
				if (".".equals(seats[r][c])) {
					// check if we can allow student
					boolean allowed = canAllow(seats, traversed, r, c);
					if (allowed) {
						traversed[r][c] = true;
						int max = helper(seats, traversed, r, c + 1, count + 1, cache);
						result = Math.max(result, max);
						traversed[r][c] = false;
					}
				}
			}
		}
		cache.put(key, result - count);
		return result;
	}

	private int getKey(Boolean[][] traversed, int row, int col) {

		int key = row;
		/*
		 * first digit in key is row identifier. 
		 * for 0th row index, it is conflicting with some other row.
		 * Also in this problem row count is less than 9, there for we are able to use int. 
		 * 
		 * If row count is more then we have to use string as key and we have to append "_" between columns value
		 * 
		 */
		if (row == 0) {
			/*
			 * if we don't do this, then for 2nd column key will look like  0*10+2 ~~ 2
			 * and we loose row info.
			 */
			key = 99;
		}
		if (row > 0) {
			Boolean[] upperRow = traversed[row - 1];
			for (int c = 0; c < traversed[0].length; c++) {
				int val = upperRow[c] == null ? 2 : (upperRow[c] ? 1 : 0);
				key = key * 10 + val;
			}
		}

		for (int c = 0; c < col; c++) {
			int val = traversed[row][c] == null ? 2 : (traversed[row][c] ? 1 : 0);
			key = key * 10 + val;
		}
		return key;
	}

	private boolean canAllow(String[][] seats, Boolean[][] traversed, int r, int c) {
		for (int[] visibleSeat : visibility) {
			int newRow = r + visibleSeat[0];
			int newCol = c + visibleSeat[1];

			if (isInBounds(seats, newRow, newCol) && traversed[newRow][newCol] != null
					&& traversed[newRow][newCol] == true) {
				return false;
			}
		}
		return true;
	}

	private boolean isInBounds(String[][] seats, int r, int c) {
		if (r >= 0 && r < seats.length && c >= 0 && c < seats[0].length) {
			return true;
		}
		return false;
	}
}