package com.mohit.pattern.matching;

import static org.junit.Assert.assertEquals;

/**
 * 
 * https://leetcode.com/problems/wildcard-matching/
 * 
 * '?' Matches any single character. 
 * '*' Matches any sequence of characters (including the empty sequence).
 * 
 * Important this is taking care of edge cases (when string ends and when pattern ends)
 * 
 * DFS will be done as per diagram in 
 * https://leetcode.com/problems/wildcard-matching/discuss/477823/Recursive-DFS-solution-with-memoization-(Top-Down-Approach)
 * 
 * In this user has created 3 child nodes for *, which are not required and can be done with 2 child nodes
 * 1. (i+1, j) 
 * 2. (i, j+1)
 * 3. (i+1, j+1) ... this is not required as it will also come from child nodes of above 2 conditions.
 * 
 * Alternative way to solve via DP 2D matrix
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/RegexMatching.java#L50
 */
public class Wildcard {

    public void execute() {
        assertEquals(true, isMatch("aa", "*"));
        assertEquals(false, isMatch("acdcb", "a*c?b"));
        assertEquals(true, isMatch("adceb", "*a*b"));
        System.out.println("All Test cases passed " +  this.getClass().getSimpleName());
    }

    public boolean isMatch(String s, String p) {

        if (s == null || p == null) {
            return false;
        }

        Boolean[][] cache = new Boolean[s.length() + 1][p.length() + 1];

        return isMatch(0, 0, s, p, cache);
    }

    private boolean isMatch(int si, int pi, String s, String p, Boolean[][] cache) {
        if (cache[si][pi] != null) {
            return cache[si][pi];
        }

        boolean ans;
        if (pi == p.length()) {
            ans = (si == s.length());
        } else if (si == s.length() && (p.charAt(pi) == '*')) {
            //If string ends and pattern has *, then that can be considered as 0 occurrence of * 
            ans = isMatch(si, pi + 1, s, p, cache);
        } else if (si == s.length()) {
            ans = false;
        } else {
            char sc = s.charAt(si);
            char pc = p.charAt(pi);

            if (pc == '?') {
                ans = isMatch(si + 1, pi + 1, s, p, cache);
            } else if (pc == '*') {
                //If pattern is * then we can use it and move si+1
                //We can discard the use of * (0 occurrence) and move pi+1
                ans = isMatch(si + 1, pi, s, p, cache) || isMatch(si, pi + 1, s, p, cache);
            } else {
                ans = (sc == pc) && isMatch(si + 1, pi + 1, s, p, cache);
            }

        }
        cache[si][pi] = ans;
        return ans;
    }
}
