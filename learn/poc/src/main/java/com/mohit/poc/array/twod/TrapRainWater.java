package com.mohit.poc.array.twod;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * https://github.com/awangdev/LintCode/blob/master/Java/Trapping%20Rain%20Water%20II.java
 * 
 * Refer "TrappingRainWater2D" for more clarity
 * Visual : https://www.youtube.com/watch?v=cJayBq38VYw
 *
 */
public class TrapRainWater {
    
    List<Cell> adjacent = Collections.unmodifiableList(Arrays.asList(new Cell(1,0), new Cell(-1, 0), new Cell(0,1), new Cell(0, -1)));
    
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
        
        assertEquals(4, trapRainWater(input));
        assertEquals(14, trapRainWater(input1));
        assertEquals(39, trapRainWater(input2));
        
        System.out.println("Hurray !!!!!! ");
        System.out.println("All test cases passed for class => " + this.getClass().getSimpleName());
    }

    private int trapRainWater(int[][] heightMap) {
        if(heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
            return 0;
        }
        
        int capacity = 0;
        int max = Integer.MIN_VALUE;
        Set<Cell> traversed = new HashSet<>();
        
        Queue<Cell> pq = new PriorityQueue<>(
            new Comparator<Cell>() {
                public int compare(Cell c1, Cell c2) {
                    return c1.height - c2.height;
                }
            }    
        );
        
        markBoundaryCells(pq, heightMap, traversed);
        
        while(!pq.isEmpty()) {
            Cell c = pq.poll();
            if (max < c.height) {
                max = c.height;
            }
            capacity += traverseAdjacentCells(heightMap, traversed, max, c, pq);
        }
        
        return capacity;
    }
    
    private int traverseAdjacentCells(int[][] heightMap, Set<Cell> traversed, int max, Cell c, Queue<Cell> pq) {
        
        int cap = 0;
        
        for (Cell adCell : adjacent) {
            Cell ac = new Cell(c.row + adCell.row, c.column + adCell.column);
            if(isValidCell(ac, heightMap)) {
                ac.height = heightMap[c.row + adCell.row][c.column + adCell.column];
                if(traversed.contains(ac)) {
                    continue;
                } else {
                    if (heightMap[ac.row][ac.column] < max) {
                        cap += max - heightMap[ac.row][ac.column];
                    }
                    traversed.add(ac);
                    pq.add(ac);                                                       
                }
            }
        
        }
        
        return cap;
    }
    
    private void markBoundaryCells(Queue<Cell> pq, int[][] array, Set<Cell> traversed) {
        
        for(int column = 0; column < array[0].length; column++) {
            pq.add(new Cell(0, column, array[0][column]));
            pq.add(new Cell(array.length - 1, column, array[array.length - 1][column]));
            traversed.add(new Cell(0, column, array[0][column]));
            traversed.add(new Cell(array.length - 1, column, array[array.length - 1][column]));
        }
        
        for(int row = 1; row < array.length - 1; row++) {
            pq.add(new Cell(row, 0, array[row][0]));
            pq.add(new Cell(row, array[0].length - 1, array[row][array[0].length - 1]));
            traversed.add(new Cell(row, 0, array[row][0]));
            traversed.add(new Cell(row, array[0].length - 1, array[row][array[0].length - 1]));
        }
    }
    
    private boolean isValidCell(Cell c, int[][] array) {
        
        if (c.row < 0 || c.column < 0 || c.row >= array.length || c.column >= array[0].length) {
            return false;
        } else {
            return true;
        }   
    }
    
}

    

class Cell {
    public int row;
    public int column;
    public int height;
    
    public Cell() {
        this(0,0,0);
    }
    
    public Cell(int x, int y) {
        this(x, y, 0);
    }
    
    public Cell(int x, int y, int h) {
        row = x;
        column = y;
        height = h;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + column;
        result = prime * result + height;
        result = prime * result + row;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cell other = (Cell) obj;
        if (column != other.column)
            return false;
        if (height != other.height)
            return false;
        if (row != other.row)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Cell [row=" + row + ", column=" + column + ", height=" + height + "]";
    }
    
}
