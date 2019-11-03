package com.mohit.zzzzz;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DuplicatesInArrayRevise {
    
    public void execute() {

        int[] arr = { 1, 2, 3, 1, 3, 6, 6, 0 };
        assertEquals(true, isSame(printRepeating(arr), Arrays.asList(1, 3, 6)));

        arr = new int[] { 1, 2, 3, 1, 6, 5, 4, 6, 2 };
        assertEquals(true, isSame(printRepeating(arr), Arrays.asList(1, 2, 6)));
        

        System.out.println("All test cases passed " + this.getClass().getSimpleName());
    }

    private List<Integer> printRepeating(int[] arr) {
        if(arr == null || arr.length == 0) {
            throw new IllegalArgumentException();
        }
        
        Integer[] result = new Integer[arr.length];
        for(int index = 0; index < result.length; index++) {
            result[index] = arr[index];
        }

        
        for(int index = 0; index < result.length; index++) {
            
            Integer currentValue = result[index];
            
            if(currentValue != null && currentValue > -1) {
                //get value what is at the index of this current value
                Integer valueAtCurrentValueIndex = result[currentValue];
                if(valueAtCurrentValueIndex != null && valueAtCurrentValueIndex < 0) {
                    result[currentValue] -= 1;
                    result[index] = null;
                } else {
                    result[index] = valueAtCurrentValueIndex;
                    result[currentValue] = -1;
                    index--;
                }
            }
            
        }
        
        List<Integer> finalResult = new ArrayList<>();
        for(int index = 0; index < result.length; index++) {
            if(result[index] != null && result[index] < -1) {
                finalResult.add(index);
            }
        }
        
        return finalResult;
    }
    
    private boolean isSame(List<Integer> actual, List<Integer> expected) {
        if ((actual == null && expected != null) || (actual != null && expected == null) || actual.size() != expected.size()) {
            return false;
        }
        for(int index = 0; index < actual.size(); index++) {
            if(actual.get(index) != expected.get(index)) {
                return false;
            }
        }
        return true;
    }
    
    

}
