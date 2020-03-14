package leetcode.biweekly._16;

import java.math.BigInteger;
import java.util.Arrays;

public class Paran {

	public static void main(String[] args) {
		
		BigInteger b = new BigInteger("12345");
		b.intValue();
		
		
		int aa = candy(new int[] {10,1,9,2,8,3,7,4,6,5});
		System.out.println(aa);
		
		aa = candy(new int[] {10,9,8,7,6,5});
		System.out.println(aa);
		
		aa = candy(new int[] {1,2,3,4,5,6});
		System.out.println(aa);
		
		aa = alter(new int[] {10,1,9,2,8,3,7,4,6,5});
		System.out.println(aa);
		
		aa = alter(new int[] {10,9,8,7,6,5});
		System.out.println(aa);
		
		aa = alter(new int[] {1,2,3,4,5,6});
		System.out.println(aa);
	}
	
	public static int alter(int[] rating) {
		int result = 0;
		
		int[] temp = new int[rating.length];
		temp[0] = 1;
		int min = 1;
		
		for(int i = 1; i < rating.length; i++) {
			if(rating[i] > rating[i-1]) {
				temp[i] = temp[i-1]+1;
			} else {
				if(temp[i-1] > 1) {
					temp[i] = 1;
				} else {
					temp[i] = temp[i-1] - 1;
					min = Math.min(min, temp[i]);
				}
			}
		}
		
		int delta = (min < 1) ? 1+Math.abs(min) : 0;
		
		for(int i = 0; i < rating.length; i++) {
			result += (temp[i] + delta);
		}
		
		return result;
	}

	public static int candy(int[] ratings) {
		int[] left = new int[ratings.length];
		int[] right = new int[ratings.length];
		Arrays.fill(left, 1);
		Arrays.fill(right, 1);
		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i] > ratings[i - 1]) {
				left[i] = left[i - 1] + 1;
			}
		}
		for (int i = ratings.length - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1]) {
				right[i] = right[i + 1] + 1;
			}
		}
		int candies = 0;
		for (int i = 0; i < ratings.length; i++) {

			candies += Math.max(left[i], right[i]);
		}
		return candies;
	}
}
//{{{}}}
//{{}{}}
//{{}}{}
//{}{{}}
//{}{}{}