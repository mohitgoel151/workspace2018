package com.mohit.poc.misc;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

/*
 * https://leetcode.com/problems/longest-consecutive-sequence/
 * 
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence. 
 * Your algorithm should run in O(n) complexity.

	Example:

	Input: [100, 4, 200, 1, 3, 2]
	Output: 4
	Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
	
	
	Main Concept to learn :
	Here we are iterating over for loop and internally doing iteration in while loop.
	Catch here is .. while loop is executed only when this number is smallest among the sequence. (num-1) is not in set.
	
	So, basically all elements will be traversed only once in outer for and inner while loop == O(n+n) => O(n)
	
 */
public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		LongestConsecutiveSequenceSol sol = new LongestConsecutiveSequenceSol();

		assertEquals(4, sol.longestConsecutive(new int[] { 100, 4, 200, 1, 3, 2 }));
		assertEquals(6, sol.longestConsecutive(new int[] { 0, 5, 100, 4, 200, 1, 3, 2 }));
		System.out.println("All passed " + sol.getClass().getSimpleName());
	}

}

class LongestConsecutiveSequenceSol {

	/*
	 * Time and space is O(n)
	 */
	public int longestConsecutive(int[] nums) {

		if (nums == null || nums.length == 0) {
			return 0;
		}

		Set<Integer> numSet = new HashSet<>();
		for (int num : nums) {
			numSet.add(num);
		}

		int longest = 0;

		for (Integer num : nums) {

			if (!numSet.contains(num - 1)) {
				int len = 1;
				while (numSet.contains(num + len)) {
					len++;
				}
				longest = Math.max(longest, len);
			}

		}
		return longest;
	}

}