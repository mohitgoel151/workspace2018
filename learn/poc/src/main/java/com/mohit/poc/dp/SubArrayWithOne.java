package com.mohit.poc.dp;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/contest/weekly-contest-165/problems/count-square-submatrices-with-all-ones/
 * 
 * @author mohgoel
 *
 */
public class SubArrayWithOne {

    public void execute() {

        int[][] input = new int[][] {
            {1,0,1},
            {1,1,0},
            {1,1,0}
        };
        assertEquals(7, input);
        
        input = new int[][] {
            {0,1,1,1},
            {1,1,1,1},
            {0,1,1,1}
        };
        assertEquals(15, input);
    }

    public int countSquares(int[][] matrix) {

        int[][] aux = new int[matrix.length][matrix[0].length];

        int result = 0;

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {

                if (r == 0 || c == 0) {
                    aux[r][c] = matrix[r][c];
                } else if (matrix[r][c] == 1) {
                    aux[r][c] = 1 + Math.min(aux[r - 1][c], Math.min(aux[r][c - 1], aux[r - 1][c - 1]));
                }

                result += aux[r][c];
            }
        }
        return result;
    }

}
