package com.mohit.binary_search;

import java.util.Random;

public class RandomCountrySelectionByPopluation {

	public static void main(String[] args) {
		RandomCountrySelectionByPopluationSol sol = new RandomCountrySelectionByPopluationSol();
		sol.execute();
		System.out.println("All test cases passed " + sol.getClass().getSimpleName());
	}

}

class RandomCountrySelectionByPopluationSol {

	public void execute() {
		getRandom(new int[] { 5, 5, 2, 3, 7, 1 });
	}

	public int getRandom(int[] arr) {

		Random random = new Random();

		int runningSum[] = new int[arr.length];
		runningSum[0] = arr[0];

		int total = arr[0];

		for (int i = 1; i < runningSum.length; i++) {
			runningSum[i] = runningSum[i - 1] + arr[i];
			total += arr[i];
		}

		int ran = random.nextInt(total);

		int low = 0;
		int high = arr.length - 1;
		int mid = (high + low) / 2;
		
		while (true) {
			
			if (runningSum[mid] >= ran && (mid - 1 == -1 || runningSum[mid - 1] < ran)) {
				break;
			}
			
			if (runningSum[mid] > ran) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
			mid = (high + low) / 2;
		}
		return mid;
	}

}