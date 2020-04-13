package com.mohit.poc.slidingwindow;

import static org.junit.Assert.assertEquals;

/**
 * 
 * https://leetcode.com/problems/subarray-product-less-than-k/
 * 
 * Your are given an array of positive integers nums.
 * Count and print the number of (contiguous) subarrays where the product of all the elements in the subarray is less than k.
 * 
 * Input: nums = [10, 5, 2, 6], k = 100 
 * Output: 8 
 * Explanation: The 8 subarrays that have product less than 100 are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]. 
 * Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
 *
 */
public class SubarrayProduct {

	public static void main(String[] args) {
		SubarrayProductSol sol = new SubarrayProductSol();
		sol.execute();
		System.out.println("All test cases passed " + sol.getClass().getSimpleName());
	}

}

class SubarrayProductSol {

	public void execute() {
		assertEquals(10, numSubarrayProductLessThanK(new int[] { 10, 5, 2, 6 }, 10000));
		assertEquals(8, numSubarrayProductLessThanK(new int[] { 10, 5, 2, 6 }, 100));
		assertEquals(0, numSubarrayProductLessThanK(new int[] { 10, 5, 2, 6 }, 1));
	}

	public int numSubarrayProductLessThanK(int[] nums, int maxThreshold) {

		if (nums == null || nums.length == 0) {
			return 0;
		}

		int product = 1, rear = 0;
		int result = 0;

		for (int front = 0; front < nums.length; front++) {
			
			//We can add validation here to check if product after multiplication is not going beyond Int.MAX_VALUE
			product *= nums[front];

			while (front >= rear && product >= maxThreshold) {
				product /= nums[rear];
				rear++;
			}
			result += (front - rear + 1);
		}
		return result;

	}

}