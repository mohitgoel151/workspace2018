package com.mohit.poc.graph;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class SnakeAndLadder {

	public static void main(String[] args) {

		SnakeAndLadderSol sol = new SnakeAndLadderSol();

		int[][] ladders = new int[][] { { 3, 54 }, { 37, 100 } };
		int[][] snakes = new int[][] { { 56, 33 } };
		assertEquals(3, sol.quickestWayUp(ladders, snakes));
		
		ladders = new int[][] { { 3, 57 }, { 8, 100 } };
		snakes = new int[][] { { 88, 44 } };
		assertEquals(2, sol.quickestWayUp(ladders, snakes));
		
		ladders = new int[][] { { 7, 98 } };
		snakes = new int[][] { { 99, 1 } };
		assertEquals(2, sol.quickestWayUp(ladders, snakes));
		
		ladders = new int[][] { { 32, 62 }, { 42, 68 }, { 12, 98 } };
		snakes = new int[][] { { 95, 13 }, { 97, 25 }, { 93, 37 }, { 79, 27 }, { 75, 19 }, { 49, 47 }, { 67, 17 } };
		assertEquals(3, sol.quickestWayUp(ladders, snakes));
		

		System.out.println("All test cases passed " + sol.getClass().getSimpleName());
	}

}


class SnakeAndLadderSol {

	public int quickestWayUp(int[][] ladders, int[][] snakes) {

		boolean[] traversed = new boolean[101];

		Map<Integer, Integer> ladderMap = new HashMap<>();
		for (int[] ladder : ladders) {
			ladderMap.put(ladder[0], ladder[1]);
		}

		Map<Integer, Integer> snakeMap = new HashMap<>();
		for (int[] snake : snakes) {
			snakeMap.put(snake[0], snake[1]);
		}

		CellWithSteps start = new CellWithSteps(1, 0);
		traversed[start.cellNo] = true;
		Queue<CellWithSteps> queue = new LinkedList<>();
		queue.add(start);

		while (!queue.isEmpty()) {
			CellWithSteps currentCell = queue.poll();
			
			for (int dieValue = 6; dieValue > 0; dieValue--) {
				int nextCellNo = currentCell.cellNo + dieValue;
				if (nextCellNo > 100) {
					continue;
				}

				nextCellNo = getNextCell(ladderMap, snakeMap, nextCellNo);
				if (nextCellNo == 100) {
					return currentCell.steps + 1;
				}
				
				if (traversed[nextCellNo] == false) {
					CellWithSteps nextStep = new CellWithSteps(nextCellNo, currentCell.steps + 1);
					queue.add(nextStep);
					traversed[nextCellNo] = true;
				}
			}
		}
		return Integer.MAX_VALUE;
	}

	private int getNextCell(Map<Integer, Integer> ladderMap, Map<Integer, Integer> snakeMap, int cellNo) {
		Integer ladderend = ladderMap.get(cellNo);
		if (ladderend != null) {
			return ladderend;
		}

		Integer snakeEnd = snakeMap.get(cellNo);
		if (snakeEnd != null) {
			return snakeEnd;
		}

		return cellNo;
	}
}

class CellWithSteps {
	int cellNo;
	int steps;

	public CellWithSteps(int c, int s) {
		cellNo = c;
		steps = s;
	}

	@Override
	public String toString() {
		return "CellWithSteps [cellNo=" + cellNo + ", steps=" + steps + "]";
	}

}