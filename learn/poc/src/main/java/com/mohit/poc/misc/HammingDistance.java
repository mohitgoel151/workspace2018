package com.mohit.poc.misc;

import static org.junit.Assert.assertEquals;

/*
 * https://leetcode.com/problems/hamming-distance/
 */
public class HammingDistance {

	public static void main(String[] args) {
		HammingDistanceXORSolution xor = new HammingDistanceXORSolution();
		HammingDistancBitSolution bit= new HammingDistancBitSolution();
		
		assertEquals(xor.hammingDistance(1, 4), bit.hammingDistance(1, 4));
		assertEquals(xor.hammingDistance(1, 100), bit.hammingDistance(1, 100));
		System.out.println("All passed " + "HammingDistance");
	}

}

class HammingDistanceXORSolution {
	
    public int hammingDistance(int x, int y) {
        int xor = x ^ y, count = 0;
        
        while (xor != 0) {
            xor &= (xor - 1);
            count++;
        }
        return count;
    }
}

class HammingDistancBitSolution {
	
    public int hammingDistance(int x, int y) {
         String xb = Integer.toBinaryString(x);
         String yb = Integer.toBinaryString(y);
        
         int result = 0;
         int max = Math.max(xb.length(), yb.length());
        
         for(int i = 0; i < max; i++) {
             int xDigit = (xb.length()-1-i >= 0) ? (xb.charAt(xb.length()-1-i) - '0') : 0;
             int yDigit = (yb.length()-1-i >= 0) ? (yb.charAt(yb.length()-1-i) - '0') : 0;
            
             if(xDigit != yDigit) {
                 result++;
             }
         }
         return result;
    }
}