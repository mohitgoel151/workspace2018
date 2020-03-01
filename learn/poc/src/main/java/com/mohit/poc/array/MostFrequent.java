package com.mohit.poc.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class MostFrequent {

    public void execute() {

        int[][] in = new int[][] { { 66672, 75156 }, { 59890, 65654 }, { 92950, 95965 }, { 9103, 31953 }, { 54869, 69855 }, { 33272, 92693 }, { 52631, 65356 }, { 43332, 89722 }, { 4218, 57729 },
                { 20993, 92876 } };

        System.out.println(removeCoveredIntervals(in));
    }

    public int removeCoveredIntervals(int[][] intervals) {

        if (intervals.length == 1) {
            return 1;
        }
        Arrays.sort(intervals, new Sortbyroll());
        Stack<int[]> stack = new Stack<>();
        stack.push(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] inter = intervals[i];

            while (isCovered(stack.peek(), inter)) {
                stack.pop();
            }
            stack.push(inter);
        }
        return stack.size();
    }

    private boolean isCovered(int[] top, int[] newInter) {
        return (newInter[0] <= top[0] && newInter[1] >= top[1]);
    }
}

class Sortbyroll implements Comparator<int[]> {
    public int compare(int[] a, int[] b) {
        return b[0] - a[0];
    }
}