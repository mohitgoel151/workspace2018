package com.mohit.poc.dp;

import static org.junit.Assert.assertEquals;

/**
 * 
 * O(n) https://www.geeksforgeeks.org/minimum-number-jumps-reach-endset-2on-solution/
 * 
 * O(n*n) https://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/
 * 
 * Given an array of integers where each element represents the max number of steps that can be made forward
 * from that element. Write a function to return the minimum number of jumps to reach the end of the array
 * (starting from the first element). If an element is 0, then cannot move through that element.
 *
 */
public class FrogJumps {

    public void execute() {

        assertEquals(3, getMinJumps(new int[] { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 }));
        assertEquals(3, getMinJumps(new int[] { 1, 3, 6, 1, 0, 9 }));
        assertEquals(4, getMinJumps(new int[] { 1, 3, 6, 3, 2, 3, 6, 8, 9, 5 }));

        try {
            assertEquals(4, getMinJumps(new int[] { 1, 3, 0, 0, 0, 0, 0, 8, 9, 5 }));
        } catch (Exception e) {
            assertEquals("not possible to reach here", e.getMessage());
        }

        try {
            assertEquals(4, getMinJumps(new int[] { 0, 3, 8, 9, 5 }));
        } catch (Exception e) {
            assertEquals("Can not proceed", e.getMessage());
        }
        
        
        assertEquals(3, getMinJumpsByArray(new int[] { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 }));
        assertEquals(3, getMinJumpsByArray(new int[] { 1, 3, 6, 1, 0, 9 }));
        assertEquals(4, getMinJumpsByArray(new int[] { 1, 3, 6, 3, 2, 3, 6, 8, 9, 5 }));

        try {
            assertEquals(4, getMinJumpsByArray(new int[] { 1, 3, 0, 0, 0, 0, 0, 8, 9, 5 }));
        } catch (Exception e) {
            assertEquals("not possible to reach here", e.getMessage());
        }

        try {
            assertEquals(4, getMinJumpsByArray(new int[] { 0, 3, 8, 9, 5 }));
        } catch (Exception e) {
            assertEquals("Can not proceed", e.getMessage());
        }

        System.out.println("All test cases passed " + this.getClass().getSimpleName());

    }

    /**
     * In this approach we will be figuring out that how many min steps are required to reach at particular
     * index and we will be moving from left to right.
     * 
     * 
     * 
     * @param input
     * @return
     */
    private int getMinJumpsByArray(int[] input) {

        if (input == null || input.length == 0) {
            throw new IllegalArgumentException("");
        }
        if (input[0] < 1) {
            throw new RuntimeException("Can not proceed");
        }

        int[] result = new int[input.length];
        result[0] = 0;

        for (int index = 1; index < input.length; index++) {

            // We can reach this destination from taking jump from index-1, or index-2 or index - 3
            int minJumps = Integer.MAX_VALUE;

            for (int rIndex = index - 1; rIndex >= 0; rIndex--) {
                if (input[rIndex] + rIndex >= index) { // value has to be atleast sufficient to make required number of jumps to reach index
                    if (minJumps > result[rIndex] + 1) {
                        minJumps = result[rIndex] + 1;
                    }
                }
            }
            if(minJumps == Integer.MAX_VALUE) {
                throw new RuntimeException("not possible to reach here");
            }
            result[index] = minJumps;
        }

        return result[input.length - 1];
    }

    /**
     * This method keeps track of how many steps are currently taken and how far we can go by making jump from
     * that index.
     * 
     * From 0th index, max steps allowed will be value at this index. If we move beyond that index we have to
     * make atleast one jump. ........ if (steps == 0) { jumps++; If at any point we see that maxReach is last
     * index (we can make jump from that index value and return jump+1;
     * 
     * If at any point index >= maxReach then that means that we can't go beyond that point.
     * 
     * Array is traversed only once, hence runtime complexity = O(n) Space = O(1)
     * 
     * @param input
     * @return
     */
    private int getMinJumps(int[] input) {

        if (input == null || input.length == 0) {
            throw new IllegalArgumentException("");
        }

        if (input[0] < 1) {
            throw new RuntimeException("Can not proceed");
        }

        int jumps = 0;
        int maxReach = input[0];
        int steps = input[0];

        for (int index = 0; index < input.length; index++) {

            maxReach = Math.max(maxReach, index + input[index]);
            if (maxReach >= input.length - 1) {
                return jumps + 1;
            }

            steps--;

            if (steps == 0) {
                jumps++;

                if (index >= maxReach) {
                    throw new RuntimeException("not possible to reach here");
                }

                steps = maxReach - index;
            }
        }

        throw new RuntimeException("not possible");
    }

}
