package com.mohit.jdk8;

import java.util.*;

public class Candies {

    public static void main(String[] args) {
        int[] status = new int[] { 1, 0, 1, 0 };

        int r = maxCandies(new int[] { 1, 0, 1, 0 }, new int[] { 7, 5, 4, 100 }, new int[][] { {}, {}, { 1 }, {} }, new int[][] { { 1, 2 }, { 3 }, {}, {} }, new int[] { 0 });
         System.out.println(r);
    }

    public static int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {

        int result = 0;

        Set<Integer> cBoxes = new HashSet<>();
        Set<Integer> cKeys = new HashSet<>();
        collectBoxesAndKeys(cBoxes, cKeys, keys, containedBoxes, initialBoxes);

        for (int index = 0; index < status.length; index++) {
            if (cBoxes.contains(index) && (status[index] == 1 || cKeys.contains(index))) {
                result += candies[index];
            }
        }

        return result;
    }

    public static void collectBoxesAndKeys(Set<Integer> cBoxes, Set<Integer> cKeys, int[][] keys, int[][] boxes, int[] initBoxes) {

        for (int boxNo : initBoxes) {
            cBoxes.add(boxNo);
            addItems(cBoxes, boxes[boxNo]);
            addItems(cKeys, keys[boxNo]);
            collectBoxesAndKeys(cBoxes, cKeys, keys, boxes, boxes[boxNo]);
        }

    }

    public static void addItems(Set<Integer> aSet, int[] array) {
        for (int a : array) {
            aSet.add(a);
        }
    }

}
