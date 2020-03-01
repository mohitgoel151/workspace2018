package leetcode.weekly._173;

import java.util.HashMap;
import java.util.Map;

public class JJob {

    static int globalMin = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int re = minDifficulty(new int[] {6,5,4,3,2,1}, 2);
        System.out.println(re);
    }

    public static int minDifficulty(int[] jobDifficulty, int d) {
        if (jobDifficulty.length < d) {
            return -1;
        }
        Map<String, Integer> cache = new HashMap<>();

        return diffSum(jobDifficulty, d, 0, 0, 0, cache);
    }

    private static int diffSum(int[] arr, int dRemain, int index, int sum, int tsum, Map<String, Integer> cache) {

        String key = String.valueOf(dRemain + "_" + index);
        Integer val = cache.get(key);

        if (val != null) {
            return val;
        }

        if (sum > globalMin) {
            cache.put(key, sum);
            return sum;
        }

        if (dRemain == 1) {
            int mi = sum + getMin(arr, index) + tsum;
            globalMin = Math.min(globalMin, mi);
            cache.put(key, mi);
            return mi;
        }

        if (arr.length - index == dRemain) {
            int s = sum + Math.max(tsum, arr[index]);
            for (int i = index + 1; i < arr.length; i++) {
                s += arr[i];
            }
            globalMin = Math.min(globalMin, s);
            cache.put(key, s);
            return s;
        }

        int with = 0;
        int without = 0;
        int tmax = 0;
        for (int i = index; i <= arr.length - dRemain; i++) {
            tmax = Math.max(tmax, arr[i]);
            val = Math.min(
                    diffSum(arr, dRemain - 1, i + 1, sum + tmax, 0, cache), 
                    diffSum(arr, dRemain, i + 1, sum, tmax, cache)
                    );
        }
        cache.put(key, val);
        return val;
    }

    private static int getMin(int[] arr, int index) {
        int max = arr[index];
        for (int i = index + 1; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }

}
