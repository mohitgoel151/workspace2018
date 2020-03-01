package com.mohit.poc.dp;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * https://leetcode.com/problems/minimum-number-of-taps-to-open-to-water-a-garden/
 * 
 * Problem :
 * 
 * There is a one-dimensional garden on the x-axis. 
 * The garden starts at the point 0 and ends at the point n. 
 * (i.e The length of the garden is n). There are n + 1 taps located at points [0, 1, ..., n] 
 * in the garden. Given an integer n and an integer array ranges of length n + 1 where ranges[i] (0-indexed) 
 * means the i-th tap can water the area [i - ranges[i], i + ranges[i]] if it was open.Return the minimum 
 * number of taps that should be open to water the whole garden, If the garden cannot be watered return -1.
 * 
 * 
 * Solution : 
 * 
 * This problem can be solved by 2 approaches.
 * 
 * 1. via DP 
 * 2. Via sorting each interval boundary by their start index then then try to see how far we can go
 * with an interval which has >= 0 overlap
 * 
 * Similar problem
 * 
 * https://leetcode.com/problems/video-stitching
 * 
 */
public class Garden {

    public void execute() {
        assertEquals(2, minTapsDP(8, new int[] { 4, 0, 0, 0, 0, 0, 0, 0, 4 }));
        assertEquals(3, minTapsDP(7, new int[] { 1, 2, 1, 0, 2, 1, 0, 1 }));
        
        assertEquals(2, minTapsSort(8, new int[] { 4, 0, 0, 0, 0, 0, 0, 0, 4 }));
        assertEquals(3, minTapsSort(7, new int[] { 1, 2, 1, 0, 2, 1, 0, 1 }));
        
        System.out.println("All test cases passes => " + this.getClass().getSimpleName());
    }

    // DP Approach
    //
    public int minTapsDP(int n, int[] ranges) {

        int[][] boundry = new int[ranges.length][2];

        for (int i = 0; i < ranges.length; i++) {
            boundry[i][0] = Math.max(0, i - ranges[i]);
            boundry[i][1] = Math.min(n, i + ranges[i]);
        }

        // Here for this particular problem sorting of all these boundaries are skipped because data is already 
        // given for each next interval.
        // in case random interval were given, sorting will be required first.

        // dp[i] is the max number of tapes to water area from 0 to i
        int[] dp = new int[ranges.length];
        Arrays.fill(dp, n + 2);
        dp[0] = 0; // minimum tapes needed to water area 0 is 0(basically no area)

        for (int index = 0; index <= n; index++) {

            int start = boundry[index][0]; // find the minimum point of garden(area) to water with tape i.
            int end = boundry[index][1]; // find the maximum point of garden(area) to water with tape i.

            for (int tapRange = start; tapRange <= end; tapRange++) {
                // Check if this range from(left..right) can be watered using less number of tapes than
                // previous
                dp[tapRange] = Math.min(dp[tapRange], 1 + dp[start]);
            }
        }
        // If minimum tapes needed to water area 0..n is greater than n , it means we could not found minimum
        // number of tapes
        return dp[n] >= n + 2 ? -1 : dp[n];
    }
    
    public int minTapsSort(int n, int[] ranges) {
        int[][] boundry = new int[ranges.length][2];

        for (int i = 0; i < ranges.length; i++) {
            boundry[i][0] = Math.max(0, i - ranges[i]);
            boundry[i][1] = Math.min(n, i + ranges[i]);
        }
        
        Arrays.sort(boundry, new IntervalComparator());
        
        int start = 0;
        int end = 0;
        int result = 0;
                
        for(int index = 0; index < boundry.length; ) {
            
            while(index < boundry.length && boundry[index][0] <= start) {
                end = Math.max(end,  boundry[index][1]);
                index++;
            }
            
            if(end == start) {
                return -1;
            }
            result++;
            start = end;
            if(start >= n) {
                break;
            }
        }
        
        return result;
    }
    
    class IntervalComparator implements Comparator<int[]> {
        //Here in comparator sort in ascending order for start and in case start are equal
        //place interval ahead which has higher end value
        public int compare(int[] i1, int[] i2) {
            if(i1[0] != i2[0]) {
                return i1[0] - i2[0]; //ascending
            } else {
                return i2[1] - i1[1];
            }
        }
    }

}
