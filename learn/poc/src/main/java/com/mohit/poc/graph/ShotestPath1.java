package com.mohit.poc.graph;

import static org.junit.Assert.assertEquals;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://www.geeksforgeeks.org/find-shortest-distance-guard-bank/
 * 
 * Given a matrix that is filled with ‘O’, ‘G’, and ‘W’ where ‘O’ represents
 * open space, ‘G’ represents guards and ‘W’ represents walls in a Bank. Replace
 * all of the O’s in the matrix with their shortest distance from a guard,
 * without being able to go through any walls. Also, replace the guards with 0
 * and walls with -1 in output matrix.
 * 
 * @author Mohit
 *
 */
public class ShotestPath1 {

	public void execute() {

		char[][] input1 = new char[][] { 
			{ 'O', 'O', 'O', 'O', 'G' }, 
			{ 'O', 'W', 'W', 'O', 'O' },
			{ 'O', 'O', 'O', 'W', 'O' }, 
			{ 'G', 'W', 'W', 'W', 'O' }, 
			{ 'O', 'O', 'O', 'O', 'G' } 
		};

		Integer[][] expOut1 = new Integer[][] { 
			{ 3, 3, 2, 1, 0 }, 
			{ 2, -1, -1, 2, 1 }, 
			{ 1, 2, 3, -1, 2 },
			{ 0, -1, -1, -1, 1 }, 
			{ 1, 2, 2, 1, 0 }
		};
		
//		ArrayList<String> a = new ArrayList<>();
//		a.equals(null);

		Comparator<GraphQueueNode<Integer>> comparator = new GraphQueueNodeIntComparator();

		Integer[][] actOut1 = getResult(input1, comparator);

		assertEquals(true, isSame(actOut1, expOut1));

	}

	private Integer[][] getResult(char[][] input, Comparator<GraphQueueNode<Integer>> comparator) {

		if (input == null || input.length == 0 || input[0].length == 0) {
			throw new IllegalArgumentException("invalid input");
		}

		Integer[][] result = new Integer[input.length][input[0].length];

		int[][] directions = new int[][] { { 1, 0 }, { 0, -1 }, { -1, 0 }, { 0, 1 } };

		Queue<GraphQueueNode<Integer>> queue = new PriorityQueue<GraphQueueNode<Integer>>(10, comparator);

		// Traverse the matrix and add all guard locations to queue
		for (int row = 0; row < input.length; row++) {
			for (int column = 0; column < input[0].length; column++) {
				if (input[row][column] == 'G') {
					queue.add(new GraphQueueNode<Integer>(row, column, 0));
					result[row][column] = 0;
				}
			}
		}

		while (!queue.isEmpty()) {
			GraphQueueNode<Integer> node = queue.poll();
			for (int i = 0; i < directions.length; i++) {
				int x = node.getX() + directions[i][0];
				int y = node.getY() + directions[i][1];
				if (isWithinBounds(x, y, input.length, input[0].length)) {
					if (input[x][y] == 'W') {
						result[x][y] = -1;
					} else if (result[x][y] == null) {
						result[x][y] = node.getValue() + 1; //this will fill the minimum value and all other cells pending in queue will make it larger and can be ignored
						queue.add(new GraphQueueNode<Integer>(x, y, node.getValue() + 1));
					}
				}
			}
		}
		return result;
	}

	private boolean isWithinBounds(int x, int y, int rows, int column) {
		if (x < 0 || y < 0 || x >= rows || y >= column) {
			return false;
		} else {
			return true;
		}
	}

	private boolean isSame(Integer[][] actOut, Integer[][] expOut) {
		for (int row = 0; row < actOut.length; row++) {
			for (int column = 0; column < actOut[0].length; column++) {
				if (actOut[row][column] != expOut[row][column]) {
					return false;
				}
			}
		}
		return true;
	}

}
