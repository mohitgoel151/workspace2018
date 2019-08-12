package com.mohit.poc.dp;

import static org.junit.Assert.assertEquals;

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
    
    private static int INVALID_COMBINATION_COUNT = 1000000;

    public void execute() {
        List<Integer> coins = Arrays.asList(9, 6, 5, 2);

        assertEquals(2, getMinCoinsCount(16, coins));
        assertEquals(3, getMinCoinsCount2(16, coins));
        
        assertEquals(1, getMinCoinsCount(3, coins));
        assertEquals(INVALID_COMBINATION_COUNT, getMinCoinsCount2(3, coins));
        
        System.out.println("Hurray !!!!!! ");
        System.out.println("All test cases passed for class => " + this.getClass().getSimpleName());
    }

    /**
     * This method can return coin count for higher amount as well
     * e.g. for 16 it will return result as 2 (9, 9)
     * @param amount
     * @param coins
     * @return
     */
    private int getMinCoinsCount(int amount, List<Integer> coins) {

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
    
    /**
     * This method will check the min coins required for returning exact amount
     * e.g. For 16 it will return result as 3 (9, 5, 2)
     * 
     * IMPORTANT ::: While considering the case of "with coin" 
     * Subtract the current coin value from amount and then check best combinations for remaining amount
     * 
     * Considering multiple coins for that coin and then check best for remaining amount will return in-correct result.
     * 
     * @param amount
     * @param coins
     * @return
     */
    private int getMinCoinsCount2(int amount, final List<Integer> coins) {
        
        if(amount < 0 || coins == null || coins.size() == 0) {
            throw new IllegalArgumentException();
        }
        
        int[][] matrix = new int[coins.size()][amount+1];
        
        for(int coinIndex = 0; coinIndex < coins.size(); coinIndex++) {
            for(int amt = 0; amt <= amount; amt++) {
                
                int coinAmount = coins.get(coinIndex);
                
                if(coinAmount > amt) {
                    if(amt == 0) {
                        matrix[coinIndex][amt] = 0;
                    } else {
                        matrix[coinIndex][amt] = INVALID_COMBINATION_COUNT;
                    }
                } else if (coinAmount == amt) { 
                    matrix[coinIndex][amt] = 1;
                } else {
                    int withoutThisCoin = INVALID_COMBINATION_COUNT;
                    int withThisCoin = INVALID_COMBINATION_COUNT;
                    
                    //with this coin
                    int remainingAmount = amt - coinAmount;
                    int coinsForRemaining = matrix[coinIndex][remainingAmount];
                    withThisCoin = 1 + coinsForRemaining;
                    
                    //without this coin
                    if(coinIndex > 0) {
                        withoutThisCoin = matrix[coinIndex - 1][amt];
                    }
                    
                    matrix[coinIndex][amt] = Math.min(withoutThisCoin, withThisCoin);
                }
            }
        }
        
        return matrix[coins.size() - 1][amount];
    }
    

}
