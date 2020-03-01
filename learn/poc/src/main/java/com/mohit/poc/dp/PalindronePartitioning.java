package com.mohit.poc.dp;

public class PalindronePartitioning {

    public void execute() {
        System.out.println(palindromePartition("aabbc", 3));

    }

    public int palindromePartition(String s, int k) {

        int len = s.length();
        if (k >= s.length() || s.length() == 0)
            return 0;
        if (k == 0)
            return Integer.MAX_VALUE; // will throw garbage here
        int[][] cost = new int[len][len];
        int[][] dp = new int[k + 1][len];
        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                int x = (s.charAt(i) == s.charAt(j)) ? 0 : 1;
                cost[i][j] = x + cost[i + 1][j - 1];
            }
        }
        for (int i = 0; i < cost.length; i++) {
            for (int j = 0; j < cost[0].length; j++) {
                System.out.print(cost[i][j] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < len; i++) {
            dp[1][i] = cost[0][i];
        }
        for (int i = 2; i <= k; i++) {
            for (int j = 1; j < len; j++) {
                int min = Integer.MAX_VALUE;
                 for (int m = 0; m < j; m++) {
                    min = Math.min(min, dp[i - 1][m] + cost[m + 1][j]);
                }
                dp[i][j] = min;
            }
        }
        
        
        int[][] dp2 = new int[k + 1][len];
        for (int i = 0; i < len; i++) {
            dp2[1][i] = cost[0][i];
        }
        for (int i = 2; i <= k; i++) {
            for (int j = 0; j < len; j++) {
                if(j == 0) {
                    dp2[i][j] = dp2[i-1][len-i];
                    continue;
                }
                if(len-i-j+1 >= 0) {
                    dp2[i][j] = Math.min (dp2[i][j-1], dp2[i-1][len-i-j+1] + cost[len-i-j+2][len-1]);
                }
            }
        }
        int cost2 = dp2[k][len-k];
        
        return dp[k][len - 1];
    }

}
