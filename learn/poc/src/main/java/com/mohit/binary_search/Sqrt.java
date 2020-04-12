package com.mohit.binary_search;

import static org.junit.Assert.assertEquals;

public class Sqrt {

	public static void main(String[] args) {
		SqrtSol sol = new SqrtSol();
		sol.execute();
		System.out.println("All test cases passed " + sol.getClass().getSimpleName());
	}
}

class SqrtSol {
	
	public void execute() {
		assertEquals(2, mySqrt(8));
		assertEquals(9, mySqrt(99));
		assertEquals(10, mySqrt(100));
	}
	
	public int mySqrt(int x) {

		if (x == 0) {
			return 0;
		}

		if (x < 4) {
			return 1;
		}

		int low = 1;
		int high = x / 2;

		return sqrt(x, low, high);

	}

	private int sqrt(int number, int low, int high) {
		int result = low;
		
		while (low <= high) {

			int mid = (low + high) / 2;

			if (mid >= (Integer.MAX_VALUE / mid)) {
				high = mid - 1;
				continue;
			}

			int squareValue = mid * mid;

			if (squareValue == number) {
				return mid;
			} else if (squareValue < number) {
				result = Math.max(mid, result);
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return result;
	}
}
