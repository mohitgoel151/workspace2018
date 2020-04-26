package com.mohit.poc.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * https://leetcode.com/problems/3sum/
 * 
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

	Note:	The solution set must not contain duplicate triplets.

 */
public class ThreeSum {

	public static void main(String[] args) {
		ThreeSumSolution sol = new ThreeSumSolution();
		System.out.println(sol.threeSum(new int[] {-1, 0, 1, 2, -1, -4}));
		System.out.println("completed");
	}

}

/**
 * Way to approach this question
 * 
 * Sum of three numbers will be 0 when any one of them is -ve (0,0,0 is exception to this)
 * 
 * So sort all the given numbers. 
 * Array elements can contain duplicate value which can bring similar combination, we also have to avoid that case 
 * 
 * Approach:
 * 1. Sort all the elements in array
 * 2. we can start iterating the elements (This will be our outer for loop and first element of result)
 * 	  As remaining array is sorted, we can take 2 pointers low and high
 * 	  if sum < 0  => low++
 * 	  if sum > 0  => high--
 * 
 * 	To avoid the scenario of duplicates we can run while loop to check if
 * 		low && (low-1) are same or not
 * 		high && (high+1) are same or not
 * 			if so continue increment/decrement their values.
 * 
 *	By adopting this approach we can avoid using Set and gives us better runtime and space complexities.
 *	
 *	Space : O(a)  => number of combinations in result
 *	time  : O(nlogn) + O(n*n)
 */
class ThreeSumSolution {
    
    public List<List<Integer>> threeSum(int[] nums) {
        
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        
        for(int i = 0; i < nums.length - 2; i++) {
        	/*
        	 * if this is same as previous ... skip it
        	 */
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            
            if(nums[i] > 0) {
                break;
            }
            
            int low = i + 1;
            int high = nums.length-1;
            
            while(low < high) {
                
                int total = nums[i] + nums[low] + nums[high];
                
                if(total == 0) {
                    result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    low++;
                    high--;
                    
                    /*
                     * After changing low and high ... continue checking if they are same as of previous value
                     */
                    while(low < high && nums[low] == nums[low-1]) {
                        low++;
                    }
                    while(low < high && nums[high] == nums[high+1]) {
                        high--;
                    }
                } else if (total > 0) {
                    high--;
                    
                    /*
                     * Same here
                     */
                    while(low < high && nums[high] == nums[high+1]) {
                        high--;
                    }
                } else {
                    low++;
                    
                    /*
                     * Same here
                     */
                    while(low < high && nums[low] == nums[low-1]) {
                        low++;
                    }
                }
            }
        }
        
        return result;
    }
}