package com.mohit.zalando;

public class SquareRootDepthRecursion {

    private static int max = 0;

    public static void main(String[] args) {
        int aa = 1000000000;
        solution2(3, aa);
        System.out.println(max);
    }

    public static void solution2(int A, int B) {
        getDepth(A, B, 0);
    }

    public static void getDepth(int A, int B, int level) {
        if (A > B) {
            if (level > max) {
                max = level;
            }
            return;
        }
        if (A == B) {
            getDepthOf(A, level);
        }

        double sqrtA = Math.sqrt(A);
        double sqrtB = Math.sqrt(B);

        int ceilA = (int) Math.ceil(sqrtA);
        int floorB = (int) Math.floor(sqrtB);

        getDepth(ceilA, floorB, level + 1);
    }

    public static void getDepthOf(int A, int level) {

        if (getIfValidSqValue(A) == false) {
            if (level > max) {
                max = level;
            }
            return ;
        }
        getDepthOf((int) Math.sqrt(A), level + 1);
    }

    private static boolean getIfValidSqValue(int val) {
        double sqrtValue = Math.sqrt(val);
        if (sqrtValue - Math.floor(sqrtValue) == 0) {
            return true;
        }
        return false;
    }

}
