package com.mohit.poc.array;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

/**
 * Find max product of 2 integers that can be generated from given array 
 * Time : o(n) 
 * Space : O(1)
 */
public class MaxProduct {

	public static void main(String[] args) {
		MaxProductSol sol = new MaxProductSol();
		sol.execute();
		System.out.println("All test cases passed " + sol.getClass().getSimpleName());
	}
}

class MaxProductSol {

	public void execute() {

		List<Integer> input = Arrays.asList(2, 3, -4, -10, 5, 20, -11);
		assertEquals(110, maxProduct(input));

		assertEquals(6, maxProduct(Arrays.asList(2, 3, -4)));
		assertEquals(8, maxProduct(Arrays.asList(-2, 3, -4)));

	}

	private int maxProduct(List<Integer> input) {

		if (input == null || input.size() == 0) {
			return 0;
		} else if (input.size() == 1) {
			return input.get(0);
		} else if (input.size() == 2) {
			return input.get(0) * input.get(1);
		}

		int maxPositive = Integer.MIN_VALUE;
		int minNegative = Integer.MAX_VALUE;
		int result = 0;

		for (Integer tempInt : input) {
			
			int product = 0;

			if (tempInt < 0) {
				product = minNegative * tempInt;
				minNegative = Math.min(minNegative, tempInt);

			} else if (tempInt > 0) {
				product = maxPositive * tempInt;
				maxPositive = Math.max(maxPositive, tempInt);
			}

			result = Math.max(product, result);
		}

		return result;
	}

}
