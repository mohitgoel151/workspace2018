package com.mohit.poc.dp;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * https://leetcode.com/problems/longest-arithmetic-sequence/
 *
 */
public class LongestArithmeticProgression {

    public void execute() {
        assertEquals(4, longestArithSeqLength(new int[] { 3, 6, 9, 12 }));
        assertEquals(3, longestArithSeqLength(new int[] { 9, 4, 7, 2, 10 }));
        assertEquals(4, longestArithSeqLength(new int[] { 20, 1, 15, 3, 10, 5, 8 }));
        System.out.println("All test casses passed : " + this.getClass().getSimpleName());
    }

    public int longestArithSeqLength(int[] A) {

        if (A == null || A.length == 0) {
            return 0;
        }

        if (A.length <= 2) {
            return A.length;
        }

        Map<Integer, Integer>[] map = new HashMap[A.length];
        int result = 0;

        for (int outer = 0; outer < A.length; outer++) {
        	
            map[outer] = new HashMap<>();
            for (int inner = 0; inner < outer; inner++) {
                int diff = A[outer] - A[inner];
                
                //check how many elements are already computed at i for same diff value
                int count = map[inner].getOrDefault(diff, 1);
                int newCount = count + 1;
                
                //check how many elements are already computed at j for same diff value
                int existingCount = map[outer].getOrDefault(diff, 0);

                //Pick max of these 2
                int newValue = Math.max(existingCount, newCount);
                
                map[outer].put(diff, newValue);
                result = Math.max(result, newValue);
            }
        }
        return result;

    }

}
