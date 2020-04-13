package com.mohit.poc.stack;

import java.util.Stack;

public class MaxAreaInHistogramV3 {
    
    public void test() {
        int[] hist = new int[] {11, 11, 10, 10, 10};//1,2,3,4,5 };//11, 11, 10, 10, 10};//2, 3, 0, 4, 1, 1, 2};
        int area = getMaxHistogramArea(hist);
        System.out.println(area);
    }

    public int getMaxHistogramArea(int[] h) {
        if(h == null || h.length == 0) {
            return 0;
        }

        if(h.length == 1) {
            return h[0];
        }

        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        
        for(int i = 1; i < h.length; i++) {

            if(stack.isEmpty() || h[i] >= h[stack.peek()]) {
                stack.push(i);
            } else {
                while(!stack.isEmpty() && (h[i] < h[stack.peek()])) {
                    int top = stack.pop();
                    int height = h[top];
                    int width = i;
                    if(!stack.isEmpty()) {
                        width = i - stack.peek() - 1;
                    }
                    maxArea = Math.max(maxArea, width*height);
                    
                }
                stack.push(i);
            }
        }

        int i = h.length;
        while(!stack.isEmpty()) {
            int top = stack.pop();
            int height = h[top];
            int width = i;
            if(!stack.isEmpty()) {
                width = i - stack.peek() - 1;
            }
            maxArea = Math.max(maxArea, width*height);
        }
        return maxArea;
    }

}
