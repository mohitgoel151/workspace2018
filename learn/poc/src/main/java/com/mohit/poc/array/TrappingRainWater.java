package com.mohit.poc.array;

import static org.junit.Assert.assertEquals;

import java.util.Stack;

/**
 * https://leetcode.com/articles/trapping-rain-water/#
 * https://leetcode.com/problems/trapping-rain-water/solution/
 */
public class TrappingRainWater {
    
    public void execute() {
        
        assertEquals(10,  trap(new int[] {3, 0, 0, 2, 0, 4}));
        assertEquals(6, trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
        assertEquals(15, trap(new int[] {1,3,2,4,1,3,1,4,5,2,2,1,4,2,2}));
        
        assertEquals(10,  calculate(new int[] {3, 0, 0, 2, 0, 4}));
        assertEquals(6, calculate(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
        assertEquals(15, calculate(new int[] {1,3,2,4,1,3,1,4,5,2,2,1,4,2,2}));
    }
    
    /**
     * stack approach
     */
    private int[] calculate (int[] height){
        int[] result = new int[height.length];
        Stack<Integer> s = new Stack<Integer>();
        int index = 0;
        while(index < height.length){
            if(s.isEmpty() || height[index] <= height[s.peek()]){
                s.push(index++);
            }else{
                int bottom = s.pop();
                if(s.size() != 0){
                    for(int i = s.peek() + 1; i < index; i++){
                        result[i] += (Math.min(height[s.peek()], height[index]) - height[bottom]);
                    }    
                }
            }
        }
        return result;
    }  
    
    /**
     * DP approach
     */
    private int trap(int[] array) {
        if(array == null) {
            throw new IllegalArgumentException("");
        }
        
        if(array.length == 0) {
            return 0;
        }
        
        int totalArea = 0;
        
        int[] leftHeight = new int[array.length];
        int[] rightHeight = new int[array.length];
        
        leftHeight[0] = array[0];
        for(int i = 1; i < array.length; i++) {
            leftHeight[i] = Math.max(leftHeight[i-1], array[i]);
        }
        
        rightHeight[array.length - 1] = array[array.length - 1];
        for(int i = array.length - 2; i >= 0; i--) {
            rightHeight[i] = Math.max(rightHeight[i+1], array[i]);
        }
        
        for(int i = 0; i < array.length; i++) {
            totalArea += (Math.min(leftHeight[i], rightHeight[i]) - array[i]);
        }
        
        return totalArea;
    }

}
