package com.mohit.poc.array;

/**
 * 
 * https://www.geeksforgeeks.org/difference-array-range-update-query-o1/
 * 
 * Consider an array A[] of integers and following two types of queries.
 * 
 * update(l, r, x) : Adds x to all values from A[l] to A[r] (both inclusive).
 * printArray() : Prints the current modified array.
 * 
 * 
 * Input : A [] { 10, 5, 20, 40 } 
 * 		update(0, 1, 10) 
 * 		printArray() 
 * 		update(1, 3, 20)
 * 		update(2, 2, 30) 
 * 		printArray()
 * 
 * Output : 
 * 		20 15 20 40 
 * 		20 35 70 60
 *
 */
class RangeSumImpl {

	public void execute() {
		int[] input = new int[] { 10, 5, 20, 40 };
		int[] diff = getDiffArray(input);

		update(diff, 0, 1, 10);
		printArray(diff);
		update(diff, 1, 3, 20);
		update(diff, 2, 2, 30);
		printArray(diff);
	}

	private void printArray(int[] diff) {

		int previous = 0;
		for (int i = 0; i < diff.length; i++) {
			int current = previous + diff[i];
			System.out.print(current + " ");
			previous = current;
		}
		System.out.println();
	}

	private void update(int[] diff, int l, int r, int x) {

		diff[l] += x;

		if (r + 1 == diff.length) {
			return;
		}
		diff[r + 1] -= x;
	}

	private int[] getDiffArray(int[] input) {

		int[] diff = new int[input.length];
		diff[0] = input[0];

		for (int i = 1; i < input.length; i++) {
			diff[i] = input[i] - input[i - 1];
		}
		return diff;
	}

}

public class RangeSum {
	
	public static void main(String[] args) {
		RangeSumImpl obj = new RangeSumImpl();
		obj.execute();
	}
}
