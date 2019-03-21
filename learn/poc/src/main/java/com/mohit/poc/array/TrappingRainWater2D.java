package com.mohit.poc.array;

import static org.junit.Assert.assertEquals;

public class TrappingRainWater2D {

    public void execute() {

//        int[][] input = new int[][] { { 1, 4, 3, 1, 3, 2 }, { 3, 2, 1, 3, 2, 4 }, { 2, 3, 3, 2, 3, 1 } };
        
        int[][] input = new int[][] {{12,13,1,12},{13,4,13,12},{13,8,10,12},{12,13,12,12},{13,13,13,13}};
        
//        assertEquals(14, calculateCapacity(input));

    }

    /**
     * This approach which we applied for 1 D array will not work here
     * Reason :
     * int[][] input = new int[][] 
     * {
     *  {12,13,1,12},
     *  {13,4,13,12},
     *  {13,8,10,12},
     *  {12,13,12,12},
     *  {13,13,13,13}
     * };
     * Now for cell[1][1] which has value 4. Water in that cell can come upto height 12 but with 1D 
     * approach it is coming out as 13. 
     * Making result incorrect.
     * 
     */
    private int approachAsOf1D(int[][] heightMap) {
        
        if(heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
            return 0;
        }

        int volume = 0;

        int[][] leftToRight = new int[heightMap.length][heightMap[0].length];
        int[][] rightToLeft = new int[heightMap.length][heightMap[0].length];
        int[][] topToBottom = new int[heightMap.length][heightMap[0].length];
        int[][] bottomToTop = new int[heightMap.length][heightMap[0].length];

        for (int row = 0; row < heightMap.length; row++) {
            for (int column = 0; column < heightMap[0].length; column++) {

                if (column == 0) {
                    leftToRight[row][column] = heightMap[row][column];
                } else {
                    leftToRight[row][column] = Math.max(leftToRight[row][column - 1], heightMap[row][column]);
                }
            }
        }

        for (int row = 0; row < heightMap.length; row++) {
            for (int column = 0; column < heightMap[0].length; column++) {

                if (row == 0) {
                    topToBottom[row][column] = heightMap[row][column];
                } else {
                    topToBottom[row][column] = Math.max(topToBottom[row - 1][column], heightMap[row][column]);
                }
            }
        }

        for (int row = heightMap.length - 1; row >= 0; row--) {
            for (int column = heightMap[0].length - 1; column >= 0; column--) {

                if (column == heightMap[0].length - 1) {
                    rightToLeft[row][column] = heightMap[row][column];
                } else {
                    rightToLeft[row][column] = Math.max(rightToLeft[row][column + 1], heightMap[row][column]);
                }
            }
        }

        for (int row = heightMap.length - 1; row >= 0; row--) {
            for (int column = heightMap[0].length - 1; column >= 0; column--) {

                if (row == heightMap.length - 1) {
                    bottomToTop[row][column] = heightMap[row][column];
                } else {
                    bottomToTop[row][column] = Math.max(bottomToTop[row + 1][column], heightMap[row][column]);
                }
            }
        }

        System.out.println("");
        
        for (int row = 0; row < heightMap.length; row++) {
            for (int column = 0; column < heightMap[0].length; column++) {
                volume += Math.min(Math.min(leftToRight[row][column], rightToLeft[row][column]), Math.min(topToBottom[row][column], bottomToTop[row][column])) - heightMap[row][column];
            }
        }
        
        return volume;
    }

}
