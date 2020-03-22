package com.mohit.poc.slidingwindow;

import static org.junit.Assert.assertEquals;

/**
 * 
 * https://leetcode.com/problems/longest-repeating-character-replacement/
 * 
 * Given a string s that consists of only uppercase English letters, you can perform at most k operations on that string.
 * 
 * In one operation, you can choose any character of the string and change it to any other uppercase English character.
 * 
 * Find the length of the longest sub-string containing all repeating letters
 * you can get after performing the above operations.
 *
 */
public class LongestRepeatingWithReplacement {

	public static void main(String[] args) {
		LongestRepeatingWithReplacementSol sol = new LongestRepeatingWithReplacementSol();
		sol.execute();
		
		System.out.println("All test cases passed " + sol.getClass().getSimpleName());
	}
}

class LongestRepeatingWithReplacementSol {

	public void execute() {
		assertEquals(4, characterReplacement("ABAB", 2));
		assertEquals(4, characterReplacement("AABABBA", 1));
	}

	/**
	 *	iterate over each character in string and maintain left and right index
	 *	maintain frequency in freq array
	 *	
	 *	While moving keep update of maxFreq of any encountered from 0 to index (right index)
	 *	This maxFreq value can be incorrect for certain ranges on window but as we are interested in longest string
	 *	we always focus to keep it incrementing.
	 *
	 *	maxCount may be invalid at some points, but this doesn't matter, because it was valid earlier in the string, and all that matters is finding the max window that occurred anywhere in the string
	 *
	 *	When ever (substring length - maxFreq > k) we move left pointer ahead
	 * 
	 */
	public int characterReplacement(String s, int k) {

		if (s == null || s.length() == 0 || k < 0) {
			throw new IllegalArgumentException("");
		}

		int endIndex = 0;
		int maxFreq = 0;
		int result = 0;
		int[] freqMap = new int[26];

		for (int index = 0; index < s.length(); index++) {
				
			char startIndexChar = s.charAt(index);
			freqMap[startIndexChar - 'A']++;
			maxFreq = Math.max(maxFreq, freqMap[startIndexChar - 'A']);

			while (index - endIndex + 1 - maxFreq > k) {
				freqMap[s.charAt(endIndex) - 'A']--;
				endIndex++;
			}

			result = Math.max(result, index - endIndex + 1);

		}
		return result;

	}
}