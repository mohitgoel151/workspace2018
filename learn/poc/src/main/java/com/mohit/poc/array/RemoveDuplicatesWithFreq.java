package com.mohit.poc.array;

import static org.junit.Assert.assertEquals;

/*
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 * 
 * Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

Given nums = [0,0,1,1,1,1,2,3,3],

Your function should return length = 7, with the first seven elements of nums being modified to 0, 0, 1, 1, 2, 3 and 3 respectively.

It doesn't matter what values are set beyond the returned length.
 */
public class RemoveDuplicatesWithFreq {

	public static void main(String[] args) {
		RemoveDuplicatesWithFreqSolution sol = new RemoveDuplicatesWithFreqSolution();
		assertEquals(5, sol.removeDuplicates(new int[] { 1, 1, 1, 2, 2, 3 }));
		assertEquals(7, sol.removeDuplicates(new int[] { 0, 0, 1, 1, 1, 1, 2, 3, 3 }));

		System.out.println("all passed " + sol.getClass().getSimpleName());
	}

}

class RemoveDuplicatesWithFreqSolution {

	public int removeDuplicates(int[] nums) {

		if (nums == null || nums.length < 3) {
			return nums.length;
		}

		int front = 1;
		int rear = 0;
		int freq = 1;

		/*
		 * keep on incrementing front index until i == i-1 and keep on incrementing freq count
		 * 
		 * if freq >= 2 ... Add i-1 twice at rear(++) else so once
		 * 
		 * After adding .. update freq and front index value
		 */
		while (front < nums.length) {

			while (front < nums.length) {
				if (nums[front - 1] != nums[front]) {
					break;
				}
				freq++;
				front++;
			}

			if (freq >= 2) {
				nums[rear++] = nums[front - 1];
				nums[rear++] = nums[front - 1];
			} else {
				nums[rear++] = nums[front - 1];
			}
			freq = 1;
			front++;
		}
		
		/**
		 * Few edge cases 
		 * 1. If last 2 or more chars are same they will we already added by above while loop
		 * 2. If last entry if different then, while loop for last char will not be executed and that has to be handled by below condition
		 */
		if (front == nums.length) {
			nums[rear++] = nums[front - 1];
		}
		return rear;

	}
}