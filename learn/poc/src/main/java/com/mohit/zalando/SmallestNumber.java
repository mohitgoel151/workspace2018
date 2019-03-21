package com.mohit.zalando;

import java.util.Arrays;

public class SmallestNumber {

    public static void main(String[] args) {

        int[] a = new int[] { 1, 4, 3, 2, 0, 9, 6, 7, 8 };
        int aa = solution(a);
        System.out.println(aa);
    }

    public static int solution(int[] A) {

        Arrays.sort(A);
        int start = 1;
        int inputStart = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] < 1) {
                i++;
            } else {
                inputStart = (i > 0) ? i - 1 : i;
                break;
            }
        }

        for (int i = inputStart; i < A.length; i++) {
            if (start == A[i]) {
                start++;
            } else if (i > 0 && A[i] == A[i - 1]) {

            } else {
                break;
            }
        }
        return start;
    }
}
