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
        
        assertEquals(11, getValidations(inputList, startIndex, endIndex, 11));
        
//        for(int i = 1; i <= 32; i++) {
//            assertEquals(i, getValidations(inputList, startIndex, endIndex, i));
//        }

        
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
        
        if(k == 1) {
            return smallestValueIn(inputList, startIndex);
        }

        int largestArrayIndex = getArrayOfMaxLength(inputList, startIndex, endIndex);

        // make binary search on this
        int middleIndex = (startIndex[largestArrayIndex] + endIndex[largestArrayIndex]) / 2;
        int middleIndexValue = inputList.get(largestArrayIndex)[middleIndex];

        int[] partitionArray = getPartitionIndex(inputList, startIndex, endIndex, largestArrayIndex, middleIndex, middleIndexValue);

        // check if search element lies on left of right of partition index
        int leftSideElements = 0;
        System.out.println("");

        for (int i = 0; i < inputList.size(); i++) {
            leftSideElements += partitionArray[i] - startIndex[i];
        }

        if (leftSideElements > k) {
            partitionArray[largestArrayIndex] --;
            return getKthLargest(inputList, startIndex, partitionArray, k);
        } else if (leftSideElements < k) {
            int index = smallestIn(inputList, partitionArray);
            partitionArray[index] ++;
            return getKthLargest(inputList, partitionArray, endIndex, k - leftSideElements - 1);
        } else {
            
            return getLargestInLeft(inputList, partitionArray);
        }
    }
    
    
    
    private int getLargestInLeft(List<int[]> inputList, int[] partitionArray) {
        int largest = Integer.MIN_VALUE;
        
        for (int i = 0; i < partitionArray.length; i++) {
            int temp; 
            if(partitionArray[i] == 0) {
                temp = inputList.get(i)[0];
            } else {
                temp = inputList.get(i)[partitionArray[i] - 1];
            }
            if(temp > largest) {
                largest = temp;
            }
        }
        
        return largest;
    }

    private int smallestIn(List<int[]> inputList, int[] indexArray) {
        int smallest = inputList.get(0)[indexArray[0]];
        int index = 0;
        for(int i = 1; i < inputList.size(); i++) {
            if(smallest > inputList.get(i)[indexArray[i]]) {
                smallest = inputList.get(i)[indexArray[i]];
                index = i;
            }
        }
        return index;
    }

    private int smallestValueIn(List<int[]> inputList, int[] startIndex) {
        int smallest = smallestIn(inputList, startIndex);
        return inputList.get(smallest)[startIndex[smallest]];
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
