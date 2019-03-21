package com.mohit.zalando;

public class CombinationToMakeArraySorted {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // int[] array = new int[] {3,4,5,4};
        // int[] array = new int[] {1,2,3,3,5,6,7};
        int[] array = new int[] { 1, 8, 5, 17 };

        int sol = solution(array);
        System.out.println(sol);
    }

    public static int solution(int[] A) {

        int totalConbinations = 0;

        if (A.length == 1) {
            // It is not clearly mentioned in problem statement what should be the result in case
            // input has only one element. Currently below algo is returning result = 1
            // If 0 is expected, we can directly return 0 from this if block.
        }

        for (int skipIndex = 0; skipIndex < A.length; skipIndex++) {
            boolean isValidRun = true;
            for (int runningIndex = 0; runningIndex < A.length; runningIndex++) {
                if (skipIndex == runningIndex) {
                    if (runningIndex != 0 && runningIndex != A.length - 1) {
                        if (A[runningIndex - 1] > A[runningIndex + 1]) {
                            isValidRun = false;
                            break;
                        }
                    }

                } else {
                    if (runningIndex != A.length - 1 && (runningIndex + 1 != skipIndex) && A[runningIndex] > A[runningIndex + 1]) {
                        isValidRun = false;
                        break;
                    }
                }
            }
            if (isValidRun) {
                totalConbinations++;
            }
        }
        return totalConbinations;
    }

}
