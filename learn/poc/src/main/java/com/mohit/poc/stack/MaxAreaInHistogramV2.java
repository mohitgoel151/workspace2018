package com.mohit.poc.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class MaxAreaInHistogramV2 {

    public void test() {
        List<Integer> hist = new ArrayList<>(Arrays.asList(11, 11, 10, 10, 10));
        int area = getMaxHistogramArea(hist);
        System.out.println(area);
    }

    public int getMaxHistogramArea(List<Integer> pointsList) {

        if (pointsList == null || pointsList.isEmpty()) {
            throw new RuntimeException("Invalid points data passed");
        }

        int maxArea = 0;
        pointsList.add(0);

        Stack<Integer> stack = new Stack<>();
        stack.add(0);

        for (int i = 1; i < pointsList.size(); i++) {

            if (pointsList.get(i) >= pointsList.get(i - 1)) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && pointsList.get(stack.peek()) > pointsList.get(i)) {
                    int heightIndex = stack.pop();
                    int width = (stack.isEmpty()) ? i : i - stack.peek() - 1;
                    int area = pointsList.get(heightIndex) * width;
                    
                    maxArea = Math.max(maxArea, area);
                }
                stack.push(i);
            }

        }

        return maxArea;
    }

}
