package com.mohit.zalando;

import java.util.HashMap;
import java.util.Map;

public class SquareRootDepth {

    public static void main(String[] args) {
        // int a = solution(16, 20);
        int a = solution(6000, 7000);
        System.out.println(a);
    }

    public static Map<Integer, Integer> cache = new HashMap<>();

    public static int solution(int A, int B) {

        cache.put(2, 0);
        cache.put(3, 0);

        int maxDepth = 0;
        for (int i = A; i <= B; i++) {
            int depth = getMaxDepth(i);
            if (depth > maxDepth) {
                maxDepth = depth;
            }
        }

        return maxDepth;
    }

    private static int getMaxDepth(int i) {
        Integer cacheValue = cache.get(i);

        if (cacheValue == null) {
            int sqrtValue = isValidSqValue(i);
            if (sqrtValue == -1) {
                cache.put(i, 0);
                return 0;
            } else {
                int depth = 1 + getMaxDepth(sqrtValue);
                cache.put(i, depth);
                return depth;
            }
        } else {
            return cacheValue;
        }
    }

    private static int isValidSqValue(int val) {
        double sqrtValue = Math.sqrt(val);
        if (sqrtValue - Math.floor(sqrtValue) == 0) {
            return (int) sqrtValue;
        }

        return -1;
    }

}
