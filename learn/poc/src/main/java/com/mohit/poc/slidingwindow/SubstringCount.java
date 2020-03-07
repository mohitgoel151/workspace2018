package com.mohit.poc.slidingwindow;

import static org.junit.Assert.assertEquals;

/**
 * 
 * https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/
 * 
 * Given a string s consisting only of characters a, b and c.
 * Return the number of substrings containing at least one occurrence of all these characters a, b and c.
 * 
 * 
 * Input: s = "abcabc" 
 * Output: 10 
 * Explanation: The substrings containing at least one occurrence of the characters a, b and c are 
 * "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again).
 *
 */
public class SubstringCount {

	public static void main(String[] args) {
		SubstringCountSoln obj = new SubstringCountSoln();
		obj.execute();
	}

}

class SubstringCountSoln {

	public void execute() {
		assertEquals(10, numberOfSubstrings("abcabc"));
		assertEquals(1, numberOfSubstrings("abc"));
		assertEquals(3, numberOfSubstrings("aaacb")); //"aaacb", "aacb" and "acb"
		System.out.println("All test cases passed " + this.getClass().getSimpleName() );
	}

	public int numberOfSubstrings(String s) {

		if (s == null || s.length() == 0) {
			return 0;
		}

		int low = 0, right = 0, result = 0;
		
		//As characters are fixed .. use array to track their frequency between low and right index
		int[] freq = new int[3];

		
		while (right < s.length()) {
			//Keep moving right and update frequency
			char aChar = s.charAt(right);
			freq[aChar - 'a']++;
			right++;

			//Move low pointer forward until substring i..j has at-least one occurrence
			while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
				char lowChar = s.charAt(low);
				freq[lowChar - 'a']--;
				low++;
			}
			
			//Update result and increment with low index because all substring between low .. right can make combination for all range from 0 .. low
			result += low;
		}
		return result;
	}
}
