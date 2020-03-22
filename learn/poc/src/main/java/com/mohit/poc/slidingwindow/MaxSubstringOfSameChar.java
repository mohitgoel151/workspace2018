package com.mohit.poc.slidingwindow;

import static org.junit.Assert.assertEquals;
/**
 * 
 * 
 *
 */
public class MaxSubstringOfSameChar {
	
	public static void main(String[]  args) {
		MaxSubstringOfSameCharSol sol  = new MaxSubstringOfSameCharSol();
		sol.execute();
		
		System.out.println("All Test cases passed " + sol.getClass().getSimpleName());
	}

}

class MaxSubstringOfSameCharSol {
	
	public void execute() {
		
		assertEquals(5, getMaxLength(new int[] {0, 1, 0, 0, 1, 1, 0}));
		assertEquals(1, getMaxLength(new int[] {0}));
		assertEquals(2, getMaxLength(new int[] {0, 1}));
		assertEquals(3, getMaxLength(new int[] {0, 1, 0}));
		assertEquals(3, getMaxLength(new int[] {0, 1, 1}));
		
	}

	private int getMaxLength(int[] input) {
		
		//validation
		
		if(input.length < 3) {
			return input.length;
		}
		
		int lastCharSize = 0;
		int secondLastSubarraySize = 0;
		int result = 0;
		
		int endIndex = 0;
		
		for(int index = 0; index < input.length; ) {
			
			while (index < input.length) {
				if (index < input.length-1 && input[index] == input[index + 1]) {
					index++;
				} else if (index == input.length-1 && input[index] == input[index - 1]) {
					index++;
				} else {
					index++;
					break;
				}
			}
			index--;
			int digitCount = index - endIndex + 1;
			endIndex = index + 1; 
			index = endIndex;
			
			result = Math.max(result, digitCount + lastCharSize + secondLastSubarraySize);
			secondLastSubarraySize = lastCharSize;
			lastCharSize = digitCount;
			
		}
		
		return result;
	}
	
}