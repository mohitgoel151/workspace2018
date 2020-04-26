package com.mohit.poc.misc;

import static org.junit.Assert.assertEquals;

/**
 * 
 * https://leetcode.com/problems/integer-to-english-words/
 * 
 * Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1
 * 
 *  Input: 1234567891
	Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
 *
 */
public class NumToWords {

	public static void main(String[] args) {
		NumToWordsSolution sol = new NumToWordsSolution();
		assertEquals("One Hundred Thousand", sol.numberToWords(100000));
		assertEquals("One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One", sol.numberToWords(1234567891));
		System.out.println("All passed " + sol.getClass().getSimpleName());
	}

}

/*
 * Approach to solve
 * 
 * 1. Make arrays for less than 20 and multiples of 10. (Keep empty strings such that number and their indexes coincide)
 * 2. From main method check for 0 and if not call helper method.
 * 3. Make conditional check of billion, million and thousand
 * 4. Handle for number less than 1000 (0-999).
 * 
 * 3(1). Calculate quotient and remainder.
 * 		 Get string value for quotient and append its corresponding representation (billion, million, thousand)
 * 	     If remainder > 0, call helper for remainder value
 * 
 * 4(1). Get quotient for hundred representation (if its > 0 ... add its value and "hundred suffix)
 * 		 now we are left with remainder part. 
 * 		 check of remainder < 20 or more
 * 		 if < 20
 * 			get value from array
 * 		 else 
 * 			get tens part and call helper again for remaining remainder's remainder part
 * 
 */
class NumToWordsSolution {

	/*
	 * Make array of all words less than 19
	 */
	String[] belowTwenty = new String[] { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
			"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
			"Nineteen" };

	/*
	 * Make array of all multiple of tens Make sure we keep empty string such that
	 * number and its index coincide
	 */
	String[] tens = new String[] { "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty",
			"Ninety" };

	public String numberToWords(int num) {

		if (num == 0) {
			return "Zero";
		}
		return helper(num);
	}

	public String helper(int num) {

		if (num == 0) {
			return "";
		}

		StringBuilder builder = new StringBuilder();

		if (num >= (int) Math.pow(10, 9)) {
			parse(num, (int) Math.pow(10, 9), " Billion", builder);

		} else if (num >= (int) Math.pow(10, 6)) {
			parse(num, (int) Math.pow(10, 6), " Million", builder);

		} else if (num >= 1000) {
			parse(num, (int) Math.pow(10, 3), " Thousand", builder);

		} else {
			int quotent = num / 100;
			int remainder = num % 100;

			if (quotent > 0) {
				builder.append(" ").append(belowTwenty[quotent]);
				builder.append(" Hundred");
			}

			if (remainder < 20) {
				builder.append(" ").append(belowTwenty[remainder]);
			} else { //less than 100
				quotent = remainder / 10;
				builder.append(" ").append(tens[quotent]);
				builder.append(" ").append(helper(remainder % 10));
			}

		}

		return builder.toString().trim();
	}

	private void parse(int num, int fraction, String representation, StringBuilder builder) {
		int quotent = num / fraction;
		int remainder = num % fraction;

		builder.append(helper(quotent)).append(representation);

		if (remainder > 0) {
			builder.append(" ").append(helper(remainder));
		}
	}

}
