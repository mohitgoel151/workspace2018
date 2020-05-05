package com.mohit.poc.array;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/
 * 
 * Given an array and an integer K, find the maximum for each and every contiguous subarray of size k
 */
public class SlidingWindowMaximum {

    public void execute() {
        
        assertEquals(true, isSameArray(new int[] {3, 4, 5, 6, 7, 8, 9, 10}, getSlidingWindowMax(new int[]{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, 3)));
        
        assertEquals(true, isSameArray(new int[] {3, 3, 4, 5, 5, 5, 6}, getSlidingWindowMax(new int[]{1, 2, 3, 1, 4, 5, 2, 3, 6}, 3)));
        
        assertEquals(true, isSameArray(new int[] {10, 10, 10, 15, 15, 90, 90 }, getSlidingWindowMax(new int[] {8, 5, 10, 7, 9, 4, 15, 12, 90, 13}, 4)));
        
        assertEquals(true, isSameArray(new int[] {10, 9, 8, 7, 6, 5, 4 }, getSlidingWindowMax(new int[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1}, 4)));
        
    }
    
    private int[] getSlidingWindowMax(int[] input, int k) {
        
        if (input == null || input.length == 0 || k < 1 || k > input.length) {
            throw new IllegalArgumentException("Invalid argument exception");
        }
        
        int[] result = new int[input.length - k + 1];
        
        //Hold index of value which is greater
        List<Integer> tempArray = new ArrayList<>(k);
        
        for(int i = 0; i < k; i++) {
            offerElementInTempArray(tempArray, input, i);
        }
        
        result[0] = input[tempArray.get(0)];
        updateTempArray(tempArray, 0);
        
        for(int i = k ; i < input.length; i++) {
            
            offerElementInTempArray(tempArray, input, i);
            result[i-k+1] = input[tempArray.get(0)];
            updateTempArray(tempArray, i-k+1);
        }
        
        return result;
        
    }
    
    private void updateTempArray(List<Integer> tempArray, int i) {
        if(tempArray.get(0) == i) {
            tempArray.remove(0);
        }
        
    }

    private void offerElementInTempArray(List<Integer> temp, int[] input, int index) {
        
        if (temp.size() == 0) {
            temp.add(index);
            return;
        }
        
        for(int i = temp.size() - 1 ; i >= 0; i--) {
            if(input[temp.get(i)] < input[index]) {
                temp.remove(i);
            } else {
                break;
            }
        }
        
        temp.add(index);
    }
    
    private boolean isSameArray(int[] expected, int [] actual) {
        
        if(expected.length != actual.length) {
            return false;
        }
        
        for(int i = 0; i < expected.length; i++) {
            if(expected[i] != actual[i]) {
                return false;
            }
        }

        return true;
    }

}
