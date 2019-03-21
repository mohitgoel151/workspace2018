package com.mohit.poc.misc;

import java.util.List;

public class GasStation {

    public int aa(final int[] A, final int[] B) {
        int start = 0, end = 1;
        int cur_petrol = A[start] - B[start];
        while (start != end || cur_petrol < 0) {
            while (cur_petrol < 0 && start != end) {
                cur_petrol -= A[start] - B[start];
                start = (start + 1) % A.length;
                if (start == 0)
                    return -1;
            }
            cur_petrol += A[end] - B[end];
            end = (end + 1) % A.length;
        }
        return start;
    }
}
