package com.mohit.poc.array.twod;

import static org.junit.Assert.assertEquals;

/**
 * 
 * http://codeanytime.blogspot.com/2015/01/dungeon-game.html
 * 
 *  The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. 
 *  The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room and 
 *  must fight his way through the dungeon to rescue the princess.
 *  
 *  The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.
 *  Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) 
 *  or contain magic orbs that increase the knight's health (positive integers).
 *  In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.
 *  
 *  Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.
 *  
 *  For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.
 *  -2 (K)  -3  3
 *  -5  -10 1
 *  10  30  -5 (P)
 *
 */
public class DungeonGame {

	public static void main(String[] args) {
		DungeonGameSol obj = new DungeonGameSol();
		obj.execute();
	}
}

class DungeonGameSol {    
    
    public void execute() {
        
        int[][] test1 = {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
        
        assertEquals(7, calculateMinimumHP(test1));
        
        assertEquals(7, minHealth(new int[][] {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}}));
        
        System.out.println("Hurray !!!!!! ");
        System.out.println("All test cases passed for class => " + this.getClass().getSimpleName());
    }
    
    
    private int minHealth(int[][] array) {
        
        if(array == null || array.length == 0 || array[0].length == 0) {
            throw new IllegalArgumentException("invalid. .....");
        }
        
        DCell[][] dCells = new DCell[array.length][array[0].length];
        
        dCells[0][0] = new DCell(array[0][0], array[0][0]);
        
//        Traverse on first row
        for(int column = 1; column < array[0].length; column++) {
            int health = dCells[0][column-1].healthBalance + array[0][column];
            int minHealth = Math.min(health, dCells[0][column-1].minTill);
            dCells[0][column] = new DCell(health, minHealth);
        }
        
        //Traverse on first column
        for(int row = 1 ; row < array.length; row++) {
            int health = dCells[row-1][0].healthBalance + array[row][0];
            int minHealth = Math.min(health, dCells[row - 1][0].minTill);
            dCells[row][0] = new DCell(health, minHealth);
        }
        
        for(int row = 1 ; row < array.length; row++) {
            
            for(int column = 1; column < array[0].length; column++) {
                int selectedRow = 0;
                int selectColumn = 0;
                
                //Choose column whose minTill value is larger
                if(dCells[row-1][column].minTill > dCells[row][column-1].minTill) {
                    selectedRow = row -1;
                    selectColumn = column;
                } else {
                    selectedRow = row;
                    selectColumn = column - 1;
                }
                
                int health = dCells[selectedRow][selectColumn].healthBalance + array[row][column];
                int minTill = Math.min(health, dCells[selectedRow][selectColumn].minTill);
                dCells[row][column] = new DCell(health, minTill);
            }
        }
        
        return Math.max((-1 * dCells[dCells.length - 1][dCells[0].length -1].minTill), 0) + 1;
    }
    
    
    
    private int calculateMinimumHP(int[][] dungeon) {
        int M = dungeon.length;
        int N = dungeon[0].length;
        
        dungeon[M-1][N-1] = Math.max(-dungeon[M-1][N-1], 0);
        
        for(int j = N-2; j >= 0; j--) 
           dungeon[M-1][j] = Math.max(dungeon[M-1][j+1] - dungeon[M-1][j], 0);
        
        for(int i = M-2; i >= 0; i--) 
           dungeon[i][N-1] = Math.max(dungeon[i+1][N-1] - dungeon[i][N-1], 0); 
        
        for(int i = M-2; i >=0; i--)
          for(int j = N-2; j >= 0; j--) 
             dungeon[i][j] = Math.max(Math.min(dungeon[i+1][j], dungeon[i][j+1]) - dungeon[i][j], 0); 
        
        return dungeon[0][0] + 1 ;
    }

}

class DCell {
    public int healthBalance;
    public int minTill;
    
    public DCell() {
        this(0,0);
    }

    public DCell(int i, int j) {
        healthBalance = i;
        minTill = j;
    }

    @Override
    public String toString() {
        return "DCell [healthBalance=" + healthBalance + ", minTill=" + minTill + "]";
    }
    
    
}