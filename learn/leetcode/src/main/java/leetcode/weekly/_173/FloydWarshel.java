package leetcode.weekly._173;

import java.util.Arrays;

public class FloydWarshel {

    public static void main(String[] args) {

        int[][] input = new int[][] { { 0, 1, 2 }, { 0, 4, 8 }, { 1, 2, 3 }, { 1, 4, 2 }, { 2, 3, 1 }, { 3, 4, 1 } };

        System.out.println(findTheCity(5, input, 2));

    }

    private static int findTheCity(int n, int[][] edges, int distanceThreshold) {

        if (edges == null || edges.length == 0 || distanceThreshold < 1) {
            return 0;
        }

        int[][] cache = new int[n][n];

        for (int r = 0; r < n; r++) {
            Arrays.fill(cache[r], 100000);
            cache[r][r] = 0;
        }

        for (int i = 0; i < edges.length; i++) {
            int source = edges[i][0];
            int dest = edges[i][1];
            int weight = edges[i][2];
            cache[source][dest] = weight;
            cache[dest][source] = weight;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    cache[i][j] = Math.min(cache[i][j], cache[i][k] + cache[k][j]);
                }
            }
        }
        int resultCity = -1;
        int minReachable = Integer.MAX_VALUE;
        int reachable = 0;
        for (int r = 0; r < n; r++) {
            reachable = 0;
            for (int c = 0; c < n; c++) {
                if (r == c) {
                    continue;
                }
                if (cache[r][c] <= distanceThreshold) {
                    reachable++;
                }
            }
            if (reachable < minReachable) {
                minReachable = reachable;
                resultCity = r;
            } else if (reachable == minReachable) {
                resultCity = Math.max(resultCity, r);
            }
        }
        return resultCity;
    }

}
