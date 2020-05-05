package com.mohit.poc.array;

/**
 * 
 * https://leetcode.com/problems/sort-colors/
 * 
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, 
 * with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 *
 */
public class SortNumbers {

	public static void main(String[] args) {
		
		SortNumbersSol sol = new SortNumbersSol();
		sol.sortColors(new int[] {2,0,2,1,1,0});
		
	}

}

class SortNumbersSol {
	
    public void sortColors(int[] nums) {
        
        if(nums == null || nums.length < 2) {
            return;
        }
        
        int left = moveLeft(nums, 0);
        int right = moveRight(nums, nums.length -1);
        
        for(int index = left; index <= right; index++) {
            if(nums[index] == 2) {
                swap(nums, index, right);
                right = moveRight(nums, right);
                index--;
            } else if (nums[index] == 0) {
                swap(nums, index, left);
                left++;
            }
        }
        
    }
    
    private int moveLeft(int[] nums, int left) {
    	// --> Movement
        while(left < nums.length && nums[left] == 0) {
            left++;
        }
        return left;
    }
    
    private int moveRight(int[] nums, int right) {
        //  <--  Movement
        while(right >= 0 && nums[right] == 2) {
            right--;
        }
        return right;
        
    }
    
    private void swap(int[] nums, int firstIndex, int secondIndex) {
        int temp = nums[firstIndex];
        nums[firstIndex] = nums[secondIndex];
        nums[secondIndex] = temp;
    }
}