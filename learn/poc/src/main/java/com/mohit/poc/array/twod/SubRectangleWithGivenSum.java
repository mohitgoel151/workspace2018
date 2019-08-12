package com.mohit.poc.array.twod;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Give a 2D array, find a rectangle whose sum if of given value
 *
 */
public class SubRectangleWithGivenSum {

    public void execute() {

        int[][] input = { 
                { 1, 2, 3, 4, -9 }, 
                { 6, -2, -3, -4, -5 }, 
                { 6, -2, -3, -4, -6 }, 
                { 6, 2, 3, 4, 6 } 
        };

        assertEquals(12, getSizeWithSum(input, 0));
        assertEquals(16, getSizeWithSum(input, 19));
        
        assertEquals(8, getSizeWithSum(input, 7));
        assertEquals(10, getSizeWithSum(input, 12));
        
        assertEquals(0, getSizeWithSum(input, 1200));
        assertEquals(20, getSizeWithSum(input, 5));
        assertEquals(16, getSizeWithSum(input, -14));

    }

    private int getSizeWithSum(int[][] input, int requiredSum) {

        if (input == null || input.length == 0 || input[0].length == 0) {
            throw new RuntimeException("");
        }

        int size = 0;

        int[][] columnWiseSumArray = getColumnWiseRunningSum(input);

        for (int rowSize = 1; rowSize <= input.length; rowSize++) {
            for(int rowStartIndex = 0; rowStartIndex <= input.length - rowSize; rowStartIndex++) {
                
                if(rowSize == 4) {
                    System.out.println("");
                }

                int[] arrayWithRows = getArrayWithRows(input, columnWiseSumArray, rowSize, rowStartIndex);
                int tempSize = getSizeInArray(arrayWithRows, requiredSum);
    
                if (tempSize*rowSize > size) {
                    size = tempSize*rowSize;
                }
            }
        }

        return size;
    }

    private int[] getArrayWithRows(int[][] input, int[][] columnWiseSumArray, int rowSize, int rowStartIndex) {
        int[] result = null;
        
        if(rowStartIndex == 0) {
            result = columnWiseSumArray[rowSize - 1];
        } else {
            result = new int[input[0].length];
            for (int columnIndex = 0; columnIndex < input[0].length; columnIndex++) {
                result[columnIndex] = columnWiseSumArray[rowSize + rowStartIndex - 1][columnIndex] - columnWiseSumArray[rowStartIndex-1][columnIndex];
            }
        }

        return result;
    }

    private int getSizeInArray(int[] processedArray, int requiredSum) {
        int size = 0;
        int runningSum = 0;
        Map<Integer, Integer> runningSet = new HashMap<>(); //sum -> index
        runningSet.put(0, -1);

        for (int i = 0; i < processedArray.length; i++) {
            runningSum += processedArray[i];
            int remainingSum = runningSum - requiredSum;
            if (runningSet.containsKey(remainingSum)) {
                int previousIndex = runningSet.get(remainingSum);
                if(size < i - previousIndex) {
                    size = i - previousIndex;
                }
            } else {
                runningSet.putIfAbsent(runningSum, i);
            }
        }
        return size;
    }

    private int[][] getColumnWiseRunningSum(final int[][] input) {

        int[][] result = new int[input.length][input[0].length];

        for (int i = 0; i < input[0].length; i++) {
            result[0][i] = input[0][i];
        }

        for (int row = 1; row < input.length; row++) {
            for (int column = 0; column < input[0].length; column++) {
                result[row][column] = result[row - 1][column] + input[row][column];
            }
        }
        return result;
    }

}
