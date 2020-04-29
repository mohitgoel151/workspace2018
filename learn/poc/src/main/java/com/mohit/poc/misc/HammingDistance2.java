package com.mohit.poc.misc;

import static org.junit.Assert.assertEquals;

/*
 * https://leetcode.com/problems/total-hamming-distance/
 * 
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different. 
 * Now your job is to find the total Hamming distance between all pairs of the given numbers.

Example:
Input: 4, 14, 2

Output: 6

Explanation: In binary representation, the 4 is 0100, 14 is 1110, and 2 is 0010 (just showing the four bits relevant in this case). So the answer will be:

HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) =>> 2 + 2 + 2 = 6.

 */
public class HammingDistance2 {

	public static void main(String[] args) {
		HammingDistance2Sol sol = new HammingDistance2Sol();
		assertEquals(6, sol.getHammingDist(new int[] {4, 14, 2}));
		System.out.println("All Passed HammingDistance2");
	}

}

class HammingDistance2Sol {
	
	public int getHammingDist(int[] nums) {
		
		if (nums == null || nums.length == 0) {
			return 0;
		}
		
		int result = 0;
		int bits = 32;
		
		while(bits > 0) {
			
			int on = 0;
			int off = 0;
			
			/*
			 * Special care : here we have used "for" loop for iterating and nums[i] give us reference to that
			 * When I tried while loop here as =>>  while (int num : nums) =>> then any changes done to num will not be reflected back to numbers in nums array
			 */
			for(int i = 0; i < nums.length; i++) {
				
				/*
				 * Check how many number now have 1 and 0 in last. 
				 */
				if ((nums[i] & 1) == 1) {
					on++;
				} else {
					off++;
				}
				nums[i] >>= 1;
			}
			result += on*off;
			bits--;
		}
		
		return result;
	}
	
	
}