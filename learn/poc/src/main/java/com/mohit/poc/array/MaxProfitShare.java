package com.mohit.poc.array;

import static org.junit.Assert.assertEquals;

/**
 * 
 * https://www.geeksforgeeks.org/maximum-profit-by-buying-and-selling-a-share-at-most-twice/
 * 
 * In a daily share trading, a buyer buys shares in the morning and sells it on
 * the same day. If the trader is allowed to make at most 2 transactions in a
 * day, whereas the second transaction can only start after the first one is
 * complete (Sell->buy->sell->buy). Given stock prices throughout the day, find
 * out the maximum profit that a share trader could have made.
 * 
Input:   price[] = {10, 22, 5, 75, 65, 80}
Output:  87
Trader earns 87 as sum of 12 and 75
Buy at price 10, sell at 22, buy at 5 and sell at 80

Input:   price[] = {2, 30, 15, 10, 8, 25, 80}
Output:  100
Trader earns 100 as sum of 28 and 72
Buy at price 2, sell at 30, buy at 8 and sell at 80

Input:   price[] = {100, 30, 15, 10, 8, 25, 80};
Output:  72
Buy at price 8 and sell at 80.
 * 
 */
public class MaxProfitShare {

	public static void main(String[] args) {
		MaxProfitShareCode code = new MaxProfitShareCode();
		code.execute();
	}

}

class MaxProfitShareCode {

	public void execute() {
		assertEquals(87, getMaxProfit(new int[] {10, 22, 5, 75, 65, 80}));
		assertEquals(100, getMaxProfit(new int[] {2, 30, 15, 10, 8, 25, 80}));
		assertEquals(72, getMaxProfit(new int[] {100, 30, 15, 10, 8, 25, 80}));
		assertEquals(0, getMaxProfit(new int[] {90, 80, 70, 60, 50}));
		System.out.println("All test cases passed " + this.getClass().getSimpleName());
	}
	
	public int getMaxProfit(int[] input) {
		
		int[] tempArray = new int[input.length];
		
		int maxSoFar = input[input.length - 1];
		int profit = 0;
		tempArray[input.length - 1] = 0;
		
		for(int index = input.length - 2; index >= 0; index--) {
			int diff = maxSoFar - input[index];
			maxSoFar = Math.max(maxSoFar, input[index]);
			profit = Math.max(profit, diff);
			tempArray[index] = profit;
		}
		
		int minSoFar = input[0];
		
		for(int index = 1; index < input.length - 2; index++) {
			int diff = input[index] - minSoFar;
			minSoFar = Math.min(minSoFar, input[index]);
			profit = Math.max(profit, diff + tempArray[index+1]);
		}
		
		return profit;
	}

}