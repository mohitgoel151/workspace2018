package com.mohit.poc.string;

import static org.junit.Assert.assertEquals;

/**
 * https://www.geeksforgeeks.org/longest-palindrome-substring-set-1/
 * 
 * https://leetcode.com/articles/longest-palindromic-substring/
 */
public class LongestPalindromicSubstring {

    public void execute() {

        assertEquals(getStringViaNormalApproach("ababd"), getStringViaDp("ababd"));
        assertEquals(getStringViaNormalApproach("222020221"), getStringViaDp("222020221"));
        assertEquals(getStringViaNormalApproach("aaaa"), getStringViaDp("aaaa"));
        // assertEquals(getStringViaNormalApproach("abc"), getStringViaDp("abc"));
        assertEquals(getStringViaNormalApproach("abcda"), getStringViaDp("abcda"));
        assertEquals(getStringViaNormalApproach("aacdefcaa"), getStringViaDp("aacdefcaa"));

        System.out.println("All test cases passes " + this.getClass().getSimpleName());
    }

    /**
     * Time O(n*n) Space O(n)
     * 
     * @param str
     * @return
     */
    private String getStringViaNormalApproach(String str) {

        if (str.length() == 1) {
            return str;
        }

        int resultLength = 1;
        int sIndex = 0;

        StringBuilder builder = new StringBuilder();
        builder.append("_");
        for (char aChar : str.toCharArray()) {
            builder.append(aChar);
            builder.append("_");
        }
        String newStr = builder.toString();

        // mid can be initialized from 2 but done from 1 here just to match value from Dp method
        for (int mid = 1; mid < newStr.length() - 1; mid++) {

            int length = getLengthForString(newStr, mid);

            if (length > resultLength) {
                resultLength = length;
                sIndex = mid - length / 2;
            }

            if (mid + length / 2 > newStr.length()) {
                break;
            }

        }

        return newStr.substring(sIndex, sIndex + resultLength).replace("_", "");
    }

    private int getLengthForString(String str, int mid) {
        int result = 1;

        for (int i = 1; mid - i >= 0 && mid + i < str.length(); i++) {
            if (str.charAt(mid + i) == str.charAt(mid - i)) {
                result = 2 * i + 1;
            } else {
                break;
            }
        }

        return result;
    }

    /**
     * Here we are only concerned in diagonally top part of the matric Time O((n*n)/2) Space O(n*n)
     */
    private String getStringViaDp(String str) {

        int length = str.length();

        if (length < 1) {
            return str;
        }

        int sIndex = 0;
        int maxSize = 1;

        // row represents start index and column represents end index
        boolean[][] dp = new boolean[length][length];

        // All String of length = 1 are palindrome
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
            sIndex = i;
        }

        // check for size = 2
        for (int i = 0; i < length - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                dp[i][i + 1] = true;
                maxSize = 2;
                sIndex = i;
            }
        }

        for (int size = 3; size <= length; size++) {

            for (int i = 0; i + size <= length; i++) {

                int j = i + size - 1;

                // Edge char has to be same
                if (str.charAt(i) == str.charAt(j)) {

                    // adjacent inner char should also be making palindrome to make outer char bigger
                    // palindrome
                    if (dp[i + 1][j - 1] == true) {

                        dp[i][j] = true;
                        if (size > maxSize) {
                            sIndex = i;
                            maxSize = size;
                        }
                    }
                }
            }
        }

        return str.substring(sIndex, sIndex + maxSize);
    }

}
