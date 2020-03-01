package com.mohit.poc.array.twod;

import static org.junit.Assert.assertEquals;

/**
 * 
 * https://leetcode.com/problems/count-servers-that-communicate/
 * 
 * You are given a map of a server center, represented as a m * n integer matrix grid, 
 * where 1 means that on that cell there is a server and 0 means that it is no server. 
 * Two servers are said to communicate if they are on the same row or on the same column. 
 * Return the number of servers that communicate with any other server.
 *
 */
public class ConnectedServers {
    
    public void execute() {
        assertEquals(0, countServers(new int[][]{{1,0},{0,1}}));
        assertEquals(3, countServers(new int[][]{{1,0},{1,1}}));
        assertEquals(4, countServers(new int[][]{{1,1,0,0},{0,0,1,0},{0,0,1,0},{0,0,0,1}}));
        
        System.out.println("All test cases passes => " + this.getClass().getSimpleName());
    }
    
public int countServers(int[][] grid) {
        
        int result = 0;
        int[] row = new int[grid.length];
        int[] col = new int[grid[0].length];
        
        for(int r = 0; r < grid.length; r++) {
            for(int c = 0; c < grid[0].length; c++) {
                if(grid[r][c] == 1) {
                    row[r]++;
                    col[c]++;
                }
            }
        }
        
        for(int r = 0; r < grid.length; r++) {
            for(int c = 0; c < grid[0].length; c++) {
                if(grid[r][c] == 1) {
                    if(row[r] > 1 || col[c] > 1) {
                        result++;
                    }    
                }
            }
        }
        
        return result;
    }
    

}
