package com.mohit.poc.array;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Still some cases need to be fixed
 * 
 * Approach
 * https://www.youtube.com/watch?v=Q3JUfHpffIg
 *
 */
public class KLargestInNSortedArray {

    public void execute() {

        int[] arr1 = new int[] { 1, 5, 9, 13, 17, 21, 24, 27, 28 };
        int[] arr2 = new int[] { 2, 6, 10, 14, 18, 22, 25, 29, 30, 31, 32 };
        int[] arr3 = new int[] { 3, 7, 11, 15, 19, 23, 26 };
        int[] arr4 = new int[] { 4, 8, 12, 16, 20 };

        List<int[]> inputList = new ArrayList<>();
        inputList.add(arr1);
        inputList.add(arr2);
        inputList.add(arr3);
        inputList.add(arr4);

        int[] startIndex = new int[inputList.size()];
        int[] endIndex = new int[] { arr1.length - 1, arr2.length - 1, arr3.length - 1, arr4.length - 1 };
        
//        assertEquals(22, getValidations(inputList, startIndex, endIndex, 11));
//        assertEquals(23, getValidations(inputList, startIndex, endIndex, 10));
//        assertEquals(32, getValidations(inputList, startIndex, endIndex, 1));
        assertEquals(1, getValidations(inputList, startIndex, endIndex, 32));
        
        System.out.println("All test cases passed " + this.getClass().getSimpleName());
        
    }

    private int getValidations(List<int[]> inputList, int[] startIndex, int[] endIndex, int k) {

        if (k < 0) {
            throw new IllegalArgumentException("");
        }

        if (inputList == null || inputList.size() == 0) {
            // Also check for each internal array within list
            throw new IllegalArgumentException("");
        }

        int totalSize = 0;
        for (int i = 0; i < inputList.size(); i++) {
            totalSize += inputList.get(i).length;
        }

        if (k > totalSize) {
            throw new IllegalArgumentException("");
        }
        // All remaining validations in start & end index and their corresponding lengths

        return getKthLargest(inputList, startIndex, endIndex, k);
    }

    private int getKthLargest(List<int[]> inputList, int[] startIndex, int[] endIndex, int k) {
        
        int largestArrayIndex = getArrayOfMaxLength(inputList, startIndex, endIndex);

        // make binary search on this
        int middleIndex = (startIndex[largestArrayIndex] + endIndex[largestArrayIndex]) / 2;
        int middleIndexValue = inputList.get(largestArrayIndex)[middleIndex];

        int[] partitionArray = getPartitionIndex(inputList, startIndex, endIndex, largestArrayIndex, middleIndex, middleIndexValue);

        // check if search element lies on left of right of partition index
        int rightSideElements = 0;

        for (int i = 0; i < inputList.size(); i++) {
            rightSideElements += endIndex[i] - partitionArray[i];
        }
        
        if(rightSideElements > k) {
            //move start to mid
            return getKthLargest(inputList, partitionArray, endIndex, k);
        } else if (rightSideElements < k) {
            return getKthLargest(inputList, startIndex, partitionArray, k-rightSideElements);
            //move end to mid and now K = k-rightSideElements
        } else {
            return getSamllestValueInRightSide(inputList, partitionArray);
        }
    }
    
    private int getSamllestValueInRightSide(List<int[]> input, int[] partition) {
        
        int smallestValue = Integer.MAX_VALUE;
        
        for(int arrayIndex = 0; arrayIndex < input.size(); arrayIndex++) {
            
            int[] arr = input.get(arrayIndex);
            if(arr.length > partition[arrayIndex] + 1) {
                int val = arr[partition[arrayIndex] + 1];
                if(val < smallestValue) {
                    smallestValue = val;
                }
            }
        }
        
        return smallestValue;
    }

    private int[] getPartitionIndex(List<int[]> inputList, int[] startIndex, int[] endIndex, int largestArrayIndex, int middleIndex, int middleIndexValue) {

        int[] temp = new int[inputList.size()];

        for (int i = 0; i < inputList.size(); i++) {
            if (largestArrayIndex == i) {
                temp[i] = middleIndex;
            } else {
                temp[i] = getPartitionIndex(inputList.get(i), startIndex[i], endIndex[i], middleIndexValue);
            }
        }

        return temp;
    }

    private int getPartitionIndex(int[] array, int sIndex, int eIndex, int middleIndexValue) {

        if (sIndex >= eIndex) {
            return sIndex;
        }
        int mid = (sIndex + eIndex) / 2;

        if (array[mid] == middleIndexValue) {
            return mid;
        } else if (array[mid] > middleIndexValue) {
            return getPartitionIndex(array, sIndex, mid - 1, middleIndexValue);
        } else {
            return getPartitionIndex(array, mid + 1, eIndex, middleIndexValue);
        }
    }

    private int getArrayOfMaxLength(List<int[]> inputList, int[] startIndex, int[] endIndex) {

        int maxSizeArrayIndex = 0;
        int tempSize = 0;
        for (int i = 0; i < inputList.size(); i++) {
            if (endIndex[i] - startIndex[i] > tempSize) {
                tempSize = endIndex[i] - startIndex[i];
                maxSizeArrayIndex = i;
            }
        }
        return maxSizeArrayIndex;
    }

}
