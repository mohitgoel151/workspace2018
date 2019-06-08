package com.mohit.poc.array;

/**
 * Find duplicates in O(n) time and O(1) extra space Given an array of n
 * elements which contains elements from 0 to n-1, with any of these numbers
 * appearing any number of times. Find these repeating numbers in O(n) and using
 * only constant memory space. For example, let n be 7 and array be {1, 2, 3, 1,
 * 3, 6, 6}, the answer should be 1, 3 and 6. This problem is an extended
 * version of following problem.
 * 
 * @author mohit
 * 
 *         http://www.geeksforgeeks.org/find-duplicates-in-on-time-and-constant-extra-space/
 *
 */
public class DuplicatesInArray {

    public void execute() {

        System.out.println("executing class = " + this.getClass().getSimpleName());

        System.out.println();
        int[] arr = { 1, 2, 3, 1, 3, 6, 6 };
        System.out.println("1 3 6");
        printRepeating(arr);

        System.out.println("\n");
        arr = new int[] { 1, 2, 3, 1, 6, 5, 4, 6, 2 };
        System.out.println("1 2 6");
        printRepeating(arr);

        System.out.println();
        System.out.println("All test cases passed :)");
    }

    private void printRepeating(int[] arr) {

        if (arr == null || arr.length < 2) {
            System.out.println("No duplicates");
        }

        for (int i = 0; i < arr.length; i++) {
            int tempIndex = arr[i];

            if (tempIndex <= 0) {
                continue;
            } else {
                int valueInAux = arr[tempIndex];

                if (valueInAux <= 0) {
                    arr[tempIndex] = valueInAux - 1;
                } else {
                    arr[i] = valueInAux;
                    arr[tempIndex] = 0;
                    i--;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            int value = arr[i];
            if (value < 0) {
                System.out.print(i + " ");
            }
        }

    }

}
