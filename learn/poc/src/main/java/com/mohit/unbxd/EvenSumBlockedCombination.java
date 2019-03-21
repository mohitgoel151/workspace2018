package com.mohit.unbxd;

/**
 * 
 * Checks if sum of all digits is odd then its valid else not
 *
 */
public class EvenSumBlockedCombination implements CombinationValidator {
	
	@Override
	public boolean isValidCombination(Combination combination) {
		int sum = combination.getNo1() + combination.getNo2() + combination.getNo3() + combination.getNo4();
		return (sum % 2 == 1) ? true : false;
	}

}
