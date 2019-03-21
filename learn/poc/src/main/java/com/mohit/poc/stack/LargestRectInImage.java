package com.mohit.poc.stack;

import java.util.ArrayList;
import java.util.List;

public class LargestRectInImage {
    
    public void test() {
        int[][] matrix =  {
            {1,0,1,1,1,1},
            {0,1,1,1,1,1},
            {0,1,1,0,1,1},
            {0,0,1,1,1,1},
            {1,0,1,1,0,1}
        };
        int maxArea = maxArea(matrix);
        System.out.println(maxArea);
    }
    
    public int maxArea(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            throw new RuntimeException("");
        }
        
        int maxArea = 0;
        MaxAreaInHistogramV2 histAreaCaclucator = new MaxAreaInHistogramV2();
        
        for (int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
            List<Integer> histogram = getHistogramForRow(matrix, rowIndex);
            int area = histAreaCaclucator.getMaxHistogramArea(histogram);
            if(maxArea < area) {
                maxArea = area;
            }
        }
        
        return maxArea;
    }

    private List<Integer> getHistogramForRow(int[][] matrix, int rowIndex) {
        List<Integer> hist = new ArrayList<>();
        int height = 0;
        for (int column = 0; column < matrix[0].length; column++) {
            height = 0;
            for(int row = rowIndex; row >= 0; row--) {
                if(matrix[row][column] == 1) {
                    height++;
                } else {
                    break;
                }
            }
            hist.add(height);
        }
        System.out.println("row = " + rowIndex + "    hist = " + hist);
        return hist;
    }

}
