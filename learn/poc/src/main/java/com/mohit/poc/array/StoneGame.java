package com.mohit.poc.array;

import static org.junit.Assert.assertEquals;

/**
 * 
 * https://www.geeksforgeeks.org/game-of-n-stones-where-each-player-can-remove-1-3-or-4
 * 
 * Made generic solution which can work for any sort of moves
 *
 */
public class StoneGame {

	public static void main(String[] args) {
		StoneGameSol sol = new StoneGameSol();
		sol.execute();
		System.out.println("All cases passed " + sol.getClass().getSimpleName());

	}

}

class StoneGameSol {
	
	int[] moves = new int[] {1,3,4};
	
	public void execute() {
		
		assertEquals(0, playerWinForStone(7));
		assertEquals(1, playerWinForStone(6));
		assertEquals(0, playerWinForStone(2));
		assertEquals(1, playerWinForStone(8));
		assertEquals(0, playerWinForStone(9));
		
	}
	
	private int playerWinForStone(int stoneCount) {
		
		int[] cache = new int[stoneCount+1];
		
		for(int move : moves) {
			if(move < cache.length) {
				cache[move] = 1;
			}
		}
		
		for(int i = 1; i <= stoneCount; i++) {
			
			boolean isP1Winner = false;
			for(int move : moves) {
				
				int backIndex = i-move;
				if(backIndex > 0) {
					isP1Winner = isP1Winner || (cache[backIndex] == 0);
				}
			}
			
			if(isP1Winner) {
				cache[i] = 1;
			}
		}
		return cache[stoneCount];
	}
	
}