package com.mohit.poc.dp;

import java.util.Arrays;
import java.util.List;

/**
 * https://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/
 * 
 * Given a value V, if we want to make change for V cents, and we have infinite supply of each of C = { C1,
 * C2, .. , Cm} valued coins, what is the minimum number of coins to make the change?
 * 
 * Examples:
 * 
 * Input: coins[] = {25, 10, 5}, V = 30 Output: Minimum 2 coins required We can use one coin of 25 cents and
 * one of 5 cents
 * 
 * Input: coins[] = {9, 6, 5, 1}, V = 11 Output: Minimum 2 coins required We can use one coin of 6 cents and 1
 * coin of 5 cents
 * 
 */
public class MinCoinsForAmount {

    public void execute() {
        List<Integer> coins = Arrays.asList(9, 6, 5, 2);
        int amount = 16;

        System.out.println(getMinCoinsCount(amount, coins));
    }

    public int getMinCoinsCount(int amount, List<Integer> coins) {

        // Do validations on input
        
        int[][] arr = new int[coins.size()][amount + 1];
        for(int iCoin = 0; iCoin< coins.size(); iCoin++) {
            arr[iCoin][0] = 1;
        }

        for (int iCoin = 0; iCoin < coins.size(); iCoin++) {
            for (int amt = 0; amt <= amount; amt++) {
                int without = (iCoin > 0) ? arr[iCoin-1][amt] : Integer.MAX_VALUE; 
                int with = (amt - coins.get(iCoin) >= 0) ? (arr[iCoin][amt - coins.get(iCoin)] + 1) : 1;
                arr[iCoin][amt] = Math.min(with , without);
            }
        }

        return arr[coins.size() - 1][amount];
    }

}
