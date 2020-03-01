package com.mohit.pattern.matching;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/regular-expression-matching/
 * 
 * '.' Matches any single character
 * '*' Matches zero or more of the preceding element.
 */
public class Regular {

    public void execute() {
        assertEquals(false, isMatch("aa", "a"));
        assertEquals(true, isMatch("ab", ".*"));
        assertEquals(true, isMatch("aab", "c*a*b"));
        assertEquals(false, isMatch("mississippi", "mis*is*p*."));
        System.out.println("All Test cases passed " +  this.getClass().getSimpleName());
    }

    public boolean isMatch(String s, String p) {

        if (s == null || p == null) {
            return false;
        }

        Boolean[][] cache = new Boolean[s.length() + 1][p.length() + 1];

        return isMatching(0, 0, s, p, cache);
    }

    private boolean isMatching(int si, int pi, String s, String p, Boolean[][] cache) {

        if (cache[si][pi] != null) {
            return cache[si][pi];
        }
        boolean ans;
        if (pi == p.length()) {
            ans = (si == s.length());
        } else {
            boolean isFirstMatching = (si < s.length() && ((s.charAt(si) == p.charAt(pi)) || '.' == p.charAt(pi)));
            if (pi + 1 < p.length() && p.charAt(pi + 1) == '*') {
                ans = isMatching(si, pi + 2, s, p, cache) || (isFirstMatching && isMatching(si + 1, pi, s, p, cache));
            } else {
                ans = isFirstMatching && isMatching(si + 1, pi + 1, s, p, cache);
            }
        }
        cache[si][pi] = ans;
        return ans;
    }

}
