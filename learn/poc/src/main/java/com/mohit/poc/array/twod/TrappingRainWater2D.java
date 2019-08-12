package com.mohit.poc.array.twod;

import static org.junit.Assert.assertEquals;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import com.mohit.poc.pojo.Cell;


public class TrappingRainWater2D {
    
    int[][] adjacents = new int[][] { 
        {-1, 0},
        {0, 1},
        {1, 0},
        {0, -1}
        
    };

    public void execute() {

        int[][] input = new int[][] { 
            { 1, 4, 3, 1, 3, 2 }, 
            { 3, 2, 1, 3, 2, 4 }, 
            { 2, 3, 3, 2, 3, 1 } 
        };

        int[][] input1 = new int[][] { 
            { 12, 13, 1, 12 }, 
            { 13, 4, 13, 12 }, 
            { 13, 8, 10, 12 }, 
            { 12, 13, 12, 12 }, 
            { 13, 13, 13, 13 } 
        };
        
        int[][] input2 = new int[][] { 
            { 3, 10, 8, 12, 2, 7, 9 }, 
            { 7, 1, 11, 3, 8, 1, 10 },
            { 9, 7, 3, 10, 2, 5, 6 },
            { 7, 11, 1, 4, 6, 11, 9 },
            { 4, 5, 8, 12, 3, 4, 2 },
            { 12, 2, 12, 1, 5, 9, 6 },
            { 6, 5, 8, 12, 4, 11, 10 }
        };
        
        assertEquals(4, calculateCapacity(input));
        assertEquals(14, calculateCapacity(input1));
        assertEquals(39, calculateCapacity(input2));
        
        System.out.println("Hurray !!!!!! ");
        System.out.println("All test cases passed for class => " + this.getClass().getSimpleName());

    }

    /**
     * This approach which we applied for 1 D array will not work here Reason : int[][] input = new int[][] {
     * {12,13,1,12}, {13,4,13,12}, {13,8,10,12}, {12,13,12,12}, {13,13,13,13} }; Now for cell[1][1] which has
     * value 4. Water in that cell can come upto height 12 (4,8,10,12) but with 1D approach it is coming out
     * as 13. Making result incorrect.
     * 
     */

    private int calculateCapacity(int[][] heightMap) {

        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
            throw new IllegalArgumentException();
        }

        int rows = heightMap.length;
        int columns = heightMap[0].length;
        
        boolean[][] traversed = new boolean[rows][columns];

        Queue<Cell> pq = new PriorityQueue<Cell>(new Comparator<Cell>() {

            @Override
            public int compare(Cell o1, Cell o2) {
                return o1.getValue() - o2.getValue();
            }
        });
        
        //insert all four boundary elements
        for(int col = 0; col < columns; col++)  {
            pq.add(new Cell(0, col, heightMap[0][col]));
            pq.add(new Cell(rows-1, col, heightMap[rows-1][col]));
            
            traversed[0][col] = true;
            traversed[rows-1][col] = true;
        }
        
        for(int row = 1; row < rows - 1; row++) {
            pq.add(new Cell(row, 0, heightMap[row][0]));
            pq.add(new Cell(row, columns-1, heightMap[row][columns-1]));
            traversed[row][0] = true;
            traversed[row][columns-1] = true;
        }
        
        int capacity = 0;
        int maxTillNow = pq.peek().getValue();
        
        while(pq.isEmpty() == false) {
            Cell aCell = pq.poll();
            
            if(maxTillNow < aCell.getValue()) {
                maxTillNow = aCell.getValue();
            } else {
                capacity += (maxTillNow - aCell.getValue());
            }
            
            addAdjacentUntraversedCells(traversed, heightMap, aCell, pq);
        }

        return capacity;
    }
    
    /**
     * Check all adjacent values which are in bounds and also untraversed
     * @param traversed
     * @param heightMap
     * @param currentCell
     * @param pq
     */
    private void addAdjacentUntraversedCells(boolean[][] traversed, int[][] heightMap, Cell currentCell, Queue<Cell> pq) {
        int rows = heightMap.length;
        int columns = heightMap[0].length;
        
        for(int i=0; i < adjacents.length; i++) {
            
            int tempRow = adjacents[i][0] + currentCell.getRow();
            int tempCol = adjacents[i][1] + currentCell.getColumn();
            
            //check if temp row and column value are in bound and also untraversed
            if(tempRow >= 0 && tempRow < rows && tempCol >=0 && tempCol < columns && traversed[tempRow][tempCol] == false) {
                pq.add(new Cell(tempRow, tempCol, heightMap[tempRow][tempCol]));
                traversed[tempRow][tempCol] = true;
            }
            
        }
    }

    

}
