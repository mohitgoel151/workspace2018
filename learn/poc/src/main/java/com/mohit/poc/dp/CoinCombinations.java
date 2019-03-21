package com.mohit.poc.dp;

import java.util.Arrays;
import java.util.List;

/**
 * https://www.geeksforgeeks.org/coin-change-dp-7/
 * 
 * For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. So output
 * should be 4. For N = 10 and S = {2, 5, 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6},
 * {2,3,5} and {5,5}. So the output should be 5.
 *
 */
public class CoinCombinations {

    public void execute() {

        List<Integer> coins = Arrays.asList(2, 5, 3, 6);
        int amount = 10;

        System.out.println(getCoinCombinations2(amount, coins));

    }

    private int getCoinCombinations(int amount, List<Integer> coins) {

        // validate input
        // amount > 0
        // coins list is to be valid and coin value should be > 0
        // Also remove duplicate coin values from input list

        int[] arr = new int[amount + 1];
        arr[0] = 1;

        for (int iCoin = 0; iCoin < coins.size(); iCoin++) {
            for (int amt = coins.get(iCoin); amt <= amount; amt++) {
                arr[amt] += arr[amt - coins.get(iCoin)];
            }
        }

        return arr[amount];
    }

    private int getCoinCombinations2(int amount, List<Integer> coins) {

        // validate input
        // amount > 0
        // coins list is to be valid and coin value should be > 0
        // Also remove duplicate coin values from input list

        int[][] arr = new int[coins.size()][amount + 1];
        for (int iCoin = 0; iCoin < coins.size(); iCoin++) {
            arr[iCoin][0] = 1;
        }

        for (int iCoin = 0; iCoin < coins.size(); iCoin++) {
            for (int amt = 1; amt <= amount; amt++) {
                // without current coin
                int without = (iCoin > 0) ? arr[iCoin - 1][amt] : 0;

                // For with this coin
                int with = (coins.get(iCoin) <= amt) ? arr[iCoin][amt - coins.get(iCoin)] : 0;

                arr[iCoin][amt] = with + without;

            }
        }

        return arr[coins.size() - 1][amount];
    }

}
