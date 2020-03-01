package com.mohit.poc.array;

public class RotatedSortedArray {
    
    public void execute() {
        
        int[] input = new int[] {6,7,8,9,1,2,3,4,5};
        
        int toFind = 9;
        int index = getInxdex(toFind, input);
        System.out.println(index);
    }
    
    private int getInxdex(int toFind, int[] array) {
        
        if(array == null || array.length < 1) {
            return -1;
        }
        
        int mid;
        int start = 0;
        int end = array.length - 1;
        for(; ;) {
            
            mid = (start + end)/2;
            
            if(array[mid] == toFind) {
                return mid;
            }
            
            if(start >= end) {
                return -1;
            }
            
            if(array[start] < array[mid]) {
                if(array[start] <= toFind && array[mid] > toFind) {
                    end = mid-1;
                } else {
                    start = mid + 1;
                }
            } else {
                if(array[mid] < toFind && array[end] >= toFind) {
                    start = mid + 1;
                } else {
                    end = mid-1;
                }
            }
        }
    }

}
