package com.mohit.poc.dp;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

/**
 * 
 * https://leetcode.com/problems/longest-increasing-subsequence/
 *
 */
public class LongestIncreasingSubsequence {

	public void execute() {

		assertEquals(0, lengthOfLIS(new int[] {}));
		assertEquals(1, lengthOfLIS(new int[] {2}));
		assertEquals(1, lengthOfLIS(new int[] {2,2}));
		
		assertEquals(1, lengthOfLIS(new int[] {4,3,2,1}));
		assertEquals(4, lengthOfLIS(new int[] {1,2,3,4}));
		assertEquals(4, lengthOfLIS(new int[] {10,9,2,5,3,7,101,18}));
		
		System.out.println("All test cases passed " + this.getClass().getSimpleName());
		
	}

	/**
	 * Space = O(n)  //temp Array
	 * Time = O(n*n) 
	 * 			(worst case .. if input is already in increasing order)
	 * 			(best case  .. if input is in decreasing order) 
	 * 
	 * this time complexity can be reduced to O(nlog(n)) if we can use binary search on temp array
	 * 
	 * Logic :
	 * we created temp array of same size and initialized all values with Integer.MAX_VALUE;
	 * 
	 * started traversing each value in main array and checked its location in temp array.
	 * We start iterating one by one in temp array and check if num[i] <= temp[j]
	 * 
	 * In case we found that value, we update that and break that for loop and if we don't find any on (num[i] is larger than all values in temp)
	 * then we add to the last of temp array and increment result.
	 * 
	 * temp array will have numbers in increasing sequence 
	 * result will represent the size of temp array as well as expected answer to the problem
	 * 
	 */
	public int lengthOfLIS(int[] nums) {

		if (nums == null || nums.length == 0) {
			return 0;
		}

		int result = 1;
		int[] temp = new int[nums.length];
		Arrays.fill(temp, Integer.MAX_VALUE);

		temp[0] = nums[0];

		for (int i = 1; i < nums.length; i++) {
			int j = 0;

			for (; j < result; j++) {

				if (nums[i] <= temp[j]) {
					temp[j] = nums[i];
					break;
				}
			}
			if (j == result) {
				temp[result] = nums[i];
				result++;
			}
		}
		return result;
	}
}
