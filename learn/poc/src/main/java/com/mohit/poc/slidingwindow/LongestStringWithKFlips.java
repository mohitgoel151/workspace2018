package com.mohit.poc.slidingwindow;

import static org.junit.Assert.assertEquals;

/**
 * 
 * Longest substring with "1" after k flips of "0"
 *
 */
public class LongestStringWithKFlips {

	public static void main(String[] args) {

		LongestStringWithKFlipsSol obj = new LongestStringWithKFlipsSol();
		obj.execute();

	}
}

class LongestStringWithKFlipsSol {

	public void execute() {

		assertEquals(getLongest("1001111010111", 2), 10);
		assertEquals(getLongest("1001111010111", 0), 4);
		assertEquals(getLongest("1001111010111", 100), 13);
		assertEquals(getLongest("1001111010111", 1), 6);
		assertEquals(getLongest("000000", 6), 6);
		assertEquals(getLongest("000000", 4), 4);
		assertEquals(getLongest("100001", 4), 6);
		assertEquals(getLongest("001100", 4), 6);
		assertEquals(getLongest("001100", 3), 5);
		System.out.println("Passed " + this.getClass().getSimpleName());
	}

	private int getLongest(String input, int flipsAllowed) {

		if (input == null || input.length() == 0 || flipsAllowed < 0) {
			throw new RuntimeException();
		}

		int flipsDone = 0;
		int backIndex = 0, frontIndex = 0;
		int max = 0;

		for (int i = 0; i < input.length(); i++) {

			if (input.charAt(i) == '0') {

				if (flipsDone < flipsAllowed) {
					flipsDone++;
				} else {
					// move start pointer ahead
					while (input.charAt(backIndex) != '0') {
						backIndex++;
					}
					backIndex++;
				}
			}
			frontIndex++;
			max = Math.max(max, frontIndex - backIndex);
		}
		return max;
	}

}
