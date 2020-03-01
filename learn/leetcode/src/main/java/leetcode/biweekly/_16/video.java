package leetcode.biweekly._16;

import java.util.Arrays;
import java.util.Comparator;

public class video {

    public static void main(String[] args) {
        int [][] in = new int[][] {{0,2},{4,6},{8,10},{1,9},{1,5},{5,9}};
        videoStitching(in, 10);
    }

    public static int videoStitching(int[][] boundry, int n) {

        Arrays.sort(boundry, new Comparator<int[]>() {
            @Override
            public int compare(int[] i1, int[] i2) {
                if (i1[0] != i2[0]) {
                    return i1[0] - i2[0]; // ascending
                } else {
                    return i2[1] - i1[1];
                }
            }
        });

        int start = 0;
        int end = 0;
        int result = 0;

        for (int index = 0; index < boundry.length; ) {

            while (index < boundry.length && boundry[index][0] <= start) {
                end = Math.max(end, boundry[index][1]);
                index++;
            }

            if (end == start) {
                return -1;
            }
            result++;
            start = end;
            if (start >= n) {
                break;
            }
        }

        return (start < n) ? -1 : result;
    }

    class IntervalComparator implements Comparator<int[]> {
        // Here in comparator sort in ascending order for start and in case start are equal
        // place interval ahead which has higher end value
        public int compare(int[] i1, int[] i2) {
            if (i1[0] != i2[0]) {
                return i1[0] - i2[0]; // ascending
            } else {
                return i2[1] - i1[1];
            }
        }
    }

}
