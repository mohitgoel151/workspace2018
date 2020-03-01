package leetcode.biweekly._16;

import java.util.ArrayList;
import java.util.List;

public class Inter {

    public static void main(String[] args) {
        int[][] in = new int[][] { 
            {0,1},{1,2},{0,3},{3,3} 
            };
        System.out.println(insert(in, new int[] { 1, 3, 4, 8 }));

    }

    public static int[] insert(int[][] queries, int[] arr) {

        int count = arr.length;
        int[] fwd = new int[count];
        int[] bkd = new int[count];

        int arrayXor = arr[0];
        fwd[0] = arr[0];
        for (int i = 1; i < count; i++) {
            arrayXor = arrayXor ^ arr[i];
            fwd[i] = fwd[i - 1] ^ arr[i];
        }

        bkd[count - 1] = arr[count - 1];
        for (int i = count - 2; i >= 0; i--) {
            bkd[i] = bkd[i + 1] ^ arr[i];
        }

        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int[] q = queries[i];

            result[i] = arrayXor;
            if (q[0] > 0) {
                result[i] = result[i] ^ fwd[q[0] - 1];
            }
            if (q[1] < count - 1) {
                result[i] = result[i] ^ bkd[q[1] + 1];
            }
        }
        return result;
    }

}
