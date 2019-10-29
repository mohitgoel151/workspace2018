package com.mohit.poc.misc;

import java.util.*;

/**
 * https://www.geeksforgeeks.org/find-subarray-with-given-sum-in-array-of-integers/
 *
 *Given an unsorted array of integers, find a subarray which adds to a given number. If there are more than one subarrays with the sum as the given number, print any of them.

Examples:

Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
Ouptut: Sum found between indexes 2 and 4

Input: arr[] = {10, 2, -2, -20, 10}, sum = -10
Ouptut: Sum found between indexes 0 to 3

Input: arr[] = {-10, 0, 2, -2, -20, 10}, sum = 20
Ouptut: No subarray with given sum exists

 *
 */
class GFG {
    public static void subArraySum(int[] arr, int sum) { 
        
        int n = arr.length;
        
        //cur_sum to keep track of cummulative sum till that point 
        int cur_sum = 0; 
        int start = 0; 
        int end = -1; 
        
        HashMap<Integer, Integer> hashMap = new HashMap<>(); 
        hashMap.put(0, -1); //initialize map as sum will be 0 just before first index
        
        for (int i = 0; i < n; i++) { 
            cur_sum = cur_sum + arr[i]; 
            
            //if hashMap already has the value, means we already  
            // have subarray with the sum - so stop 
            if (hashMap.containsKey(cur_sum - sum)) { 
                start = hashMap.get(cur_sum - sum) + 1; 
                end = i; 
                break; 
            } 
            
            //if value is not present then add to hashmap 
            hashMap.put(cur_sum, i); 
  
        } 
        // if end is -1 : means we have reached end without the sum 
        if (end == -1) { 
            System.out.println("No subarray with given sum exists"); 
        } else { 
            System.out.println("Sum found between indexes " 
                            + start + " to " + end); 
        } 
  
    } 
  
    // Driver code 
    public static void main(String[] args) { 
        int[] arr = {2, 6, -4, -5, 8, 3}; 
        subArraySum(arr, -9); 
        
        int[] arr2 = {2, 6, -4, -4, -5, 8, 3}; 
        subArraySum(arr2, 0); 
        subArraySum(arr2, -2); 
        
  
    } 
}
