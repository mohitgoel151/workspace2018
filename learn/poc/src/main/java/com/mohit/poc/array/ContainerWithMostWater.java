package com.mohit.poc.array;

import static org.junit.Assert.assertEquals;

/**
 * Variation of trapping rain water https://leetcode.com/problems/container-with-most-water/
 * 
 * Initially we consider the area constituting the exterior most lines. Now, to maximize the area, we need to
 * consider the area between the lines of larger lengths. If we try to move the pointer at the longer line
 * inwards, we won't gain any increase in area, since it is limited by the shorter line. But moving the
 * shorter line's pointer could turn out to be beneficial, as per the same argument, despite the reduction in
 * the width. This is done since a relatively longer line obtained by moving the shorter line's pointer might
 * overcome the reduction in area caused by the width reduction.
 *
 */
public class ContainerWithMostWater {

    public void execute() {

        assertEquals(calculate(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }), 49);
        System.out.println("All test cases passed " + this.getClass().getSimpleName());
    }

    public int calculate(int[] heights) {

        if (heights == null || heights.length < 2) {
            return 0;
        }

        int capacity = 0;

        int start = 0;
        int end = heights.length - 1;

        while (start < end) {
            capacity = Math.max(capacity, Math.min(heights[start], heights[end]) * (end - start));
            if (heights[start] < heights[end]) {
                start++;
            } else {
                end--;
            }
        }

        return capacity;
    }

}
