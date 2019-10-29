package com.mohit.poc.fb;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubArrayOfSum {

    public void execute() {

        assertEquals(true, getMinLength(Arrays.asList(2, 3, -3, 2, 5, 6, 7, 8, 9), 4));
        assertEquals(true, getMinLength(Arrays.asList(8, 2, 3, -2, 1, 5, 6, 7, 8, 9), 4));
        assertEquals(true, getMinLength(Arrays.asList(8, 2, 3, -2, 1, 5, 6, 7, 8, 9), 9));
        assertEquals(false, getMinLength(Arrays.asList(8, 2, 3, -2, 1, 5, 6, 7, 8, 9), 90));
        assertEquals(false, getMinLength(Arrays.asList(8, 2, 3, -2, 1, 5, 6, 7, 8, 9), -9));

        System.out.println("All test cases passed " + this.getClass().getSimpleName());
    }

    private boolean getMinLength(List<Integer> input, int requiredSum) {

        if (input == null || input.size() == 0) {
            throw new IllegalArgumentException("");
        }

        Map<Integer, Integer> sumToIndexMap = new HashMap<>();
        sumToIndexMap.put(0, -1);

        int runningSum = 0;

        for (int index = 0; index < input.size(); index++) {

            int currentValue = input.get(index);
            runningSum += currentValue;
            sumToIndexMap.put(runningSum, index);

            int remainingSum = runningSum - requiredSum;

            Integer remainigSumIndex = sumToIndexMap.get(remainingSum);
            if (remainigSumIndex != null) {
                return true;
            }

        }
        return false;
    }
}
