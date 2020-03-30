package com.mohit.poc.graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 * https://leetcode.com/problems/flower-planting-with-no-adjacent
 * 
 * You have N gardens, labeled 1 to N.  In each garden, you want to plant one of 4 types of flowers.

paths[i] = [x, y] describes the existence of a bidirectional path from garden x to garden y.

Also, there is no garden that has more than 3 paths coming into or leaving it.

Your task is to choose a flower type for each garden such that, for any two gardens connected by a path, they have different types of flowers.

Return any such a choice as an array answer, where answer[i] is the type of flower planted in the (i+1)-th garden.  The flower types are denoted 1, 2, 3, or 4.  
It is guaranteed an answer exists.
 *
 */
public class FlowerGarden {

    public void execute() {
        System.out.println(gardenNoAdj(5, new int[][] { { 3, 4 }, { 4, 5 }, { 3, 2 }, { 5, 1 }, { 1, 3 }, { 4, 2 } })); //[1, 1, 2, 3, 2]

        System.out.println(gardenNoAdj(4, new int[][] { { 1,2}, {3,4}, {3,2}, {4,2}, {1,4 } })); //[1, 2, 1, 3]
        
        System.out.println(gardenNoAdj(5, new int[][] { { 4,1}, {4,2}, {4,3}, {2,5}, {1,2}, {1,5 } })); //[1,2,1,3,3], 
        
        System.out.println(gardenNoAdj(1, new int[][] { })); //[1]

        System.out.println(gardenNoAdj(4, new int[][] { { 1,2},{3,4 } })); //[1,2,1,2]

    }

    public int[] gardenNoAdj(int N, int[][] paths) {

        int[] result = new int[N];

        Map<Integer, Set<Integer>> map = new HashMap<>();

        // Handling for single nodes having no connection
        for (int i = 1; i <= N; i++) {
            map.put(i, new HashSet<Integer>());
        }

        // Make 2 way links
        for (int[] path : paths) {
            Set<Integer> link = map.get(path[0]);
            link.add(path[1]);

            link = map.get(path[1]);
            link.add(path[0]);
        }

        boolean[] flowerAvailable = new boolean[5];

        //Here we are iteratively picking gardens by garden number
        for (int i = 1; i <= N; i++) {
            flowerAvailable = new boolean[5];
            Arrays.fill(flowerAvailable, true);
            
            //check which all adjacent gardens have already chosen their color and mark all those colors as un-available for this garden
            for(int adjacentGarden : map.get(i)) {
                if(result[adjacentGarden-1] != 0) {
                    flowerAvailable[result[adjacentGarden-1]] = false;
                }
            }
            
            for(int flowerIndex = 1; flowerIndex < 5; flowerIndex++) {
                if(flowerAvailable[flowerIndex]) {
                    result[i-1] = flowerIndex;
                    flowerAvailable[flowerIndex] = false;
                    break;
                }
            }

        }

        return result;
    }

}
