package com.mohit.poc.dp;

import static org.junit.Assert.assertEquals;

/**
 * 
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
 * 
 * https://www.youtube.com/watch?v=oDhu5uGq_ic
 * 
 *
 */
public class Stocks_K_Transactions {

	public static void main(String[] args) {
		Stocks_K_TransactionsSol sol = new Stocks_K_TransactionsSol();

		assertEquals(20, sol.maxProfit(3, new int[] { 3, 2, 6, 5, 0, 3, 10, 4, 5, 6, 7, 4, 3, 4, 6, 6, 6, 5, 9, 0 }));
		assertEquals(24, sol.maxProfit(5, new int[] { 3, 2, 6, 5, 0, 3, 10, 4, 5, 6, 7, 4, 3, 4, 6, 6, 6, 5, 9, 0 }));

		System.out.println("All cases passed " + sol.getClass().getSimpleName());

	}

}

/**
 * 
 * treat days as columns and transactions count as rows
 * 
 * At each step check how much profit can be earned by Selling today 
 * 
 * To calculate this we have to consider today's price along with price on purchasing day and profit booked till buying day with one less transaction (upper row)
 * 
 * today's price           = Price[today]
 * price on purchasing day = price[buyDay]
 * profit on buying day    = dp[tras-1][buyDay]
 * 
 */
class Stocks_K_TransactionsSol {

	public int maxProfit(int k, int[] prices) {

		if (prices.length < 2 || k < 1) {
			return 0;
		}

		int days = prices.length;

		//If transactions allwed are more than days by 2 then we just calculate prices for all day where they are more than previous day price
		if (k >= prices.length / 2) {
			int profit = 0;
			for (int day = 1; day < days; day++) {
				if (prices[day] > prices[day - 1]) {
					profit += (prices[day] - prices[day - 1]);
				}
			}
			return profit;
		}

		int[][] dp = new int[k + 1][prices.length];

		//for 0 transaction profit is 0 .... so that row can be skipped
		//we can not book any profit on day 0 ... so that can also be skipped
		for (int transaction = 1; transaction <= k; transaction++) {
			//Keep tracking the maxDiff
			int maxDiff = dp[transaction - 1][0] - prices[0];

			for (int day = 1; day < days; day++) {

				//check if we don't transact today and use 
				int profitWithoutTransactingToday = dp[transaction][day - 1];
				int profitWithTransactingToday = prices[day] + maxDiff;
				
				dp[transaction][day] = Math.max(profitWithoutTransactingToday, profitWithTransactingToday);
				maxDiff = Math.max(maxDiff, dp[transaction - 1][day] - prices[day]);

			}
		}
		//bottom rightmost cell will be the answer
		return dp[k][days - 1];
	}
}