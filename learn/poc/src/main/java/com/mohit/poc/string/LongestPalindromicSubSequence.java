package com.mohit.poc.string;

import static org.junit.Assert.assertEquals;

import java.lang.invoke.MethodHandles;

/*
 * https://leetcode.com/problems/longest-palindromic-subsequence/
 */
public class LongestPalindromicSubSequence {

	public static void main(String[] args) {
		
		SubSequenceDFS dfs = new SubSequenceDFS();
		SubSequenceDP dp = new SubSequenceDP();
		
		String input = "bbbab"; //4 (bbbb)
		assertEquals(dfs.longestPalindromeSubseq(input), dp.longestPalindromeSubseq(input));
		
		input = "cbbd"; // 2 (bb)
		assertEquals(dfs.longestPalindromeSubseq(input), dp.longestPalindromeSubseq(input));
		
		input = "ccabdaxcycz"; //7 (ccabacc)
		assertEquals(dfs.longestPalindromeSubseq(input), dp.longestPalindromeSubseq(input));
		
		System.out.println("All passed " + MethodHandles.lookup().lookupClass().getSimpleName());
	}

}

class SubSequenceDFS {
	
	public int longestPalindromeSubseq(String s) {

		Integer[][] dp = new Integer[s.length()][s.length()];
		return helper(s, 0, s.length() - 1, dp);
	}

	public int helper(String s, int low, int high, Integer[][] dp) {

		if (low < 0 || high >= s.length() || low > high) {
			return 0;
		}

		if (low == high) {
			dp[low][high] = 1;
			return 1;
		}

		if (dp[low][high] != null) {
			return dp[low][high];
		}
		int max = 0;

		if (s.charAt(low) == s.charAt(high)) {
			max = 2 + helper(s, low + 1, high - 1, dp);
		} else {
			max = Math.max(helper(s, low + 1, high, dp), helper(s, low, high - 1, dp));
		}

		dp[low][high] = max;
		return max;
	}
}

class SubSequenceDP {

	public int longestPalindromeSubseq(String s) {

		int len = s.length();
		int[][] dp = new int[len + 1][len + 1];

		for (int r = 1; r <= len; r++) {

			char rowChar = s.charAt(r - 1);

			for (int c = 1; c <= s.length(); c++) {
				char colChar = s.charAt(len - c);

				if (rowChar == colChar) {
					dp[r][c] = 1 + dp[r - 1][c - 1];
				} else {
					dp[r][c] = Math.max(dp[r - 1][c], dp[r][c - 1]);
				}
			}
		}
		return dp[s.length()][s.length()];
	}
}