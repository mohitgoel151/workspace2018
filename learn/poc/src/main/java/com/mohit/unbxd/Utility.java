package com.mohit.unbxd;

public final class Utility {

	/**
	 * Check if all four values of both given combinations are same or not
	 * 
	 * @param comb1
	 * @param comb2
	 * @return true if both are same
	 */
	public static boolean isSameCombination(Combination comb1, Combination comb2) {
		if ((comb1.getNo1() == comb2.getNo1()) && (comb1.getNo2() == comb2.getNo2())
				&& (comb1.getNo3() == comb2.getNo3()) && (comb1.getNo4() == comb2.getNo4())) {
			return true;
		}
		return false;
	}

	public static Combination getCombinationWithIndex(Combination comb, int index, boolean increment) {

		Combination newCombination;

		int value;
		if (index == 0) {
			value = comb.getNo1();
		} else if (index == 1) {
			value = comb.getNo2();
		} else if (index == 2) {
			value = comb.getNo3();
		} else {
			value = comb.getNo4();
		}

		if (increment) {
			value++;
			if (value == 10) {
				value = 0;
			}
		} else {
			value--;
			if (value == -1) {
				value = 9;
			}
		}
		if (index == 0) {
			newCombination = new Combination(value, comb.getNo2(), comb.getNo3(), comb.getNo4(), comb.getLevel() + 1);
		} else if (index == 1) {
			newCombination = new Combination(comb.getNo1(), value, comb.getNo3(), comb.getNo4(), comb.getLevel() + 1);
		} else if (index == 2) {
			newCombination = new Combination(comb.getNo1(), comb.getNo2(), value, comb.getNo4(), comb.getLevel() + 1);
		} else {
			newCombination = new Combination(comb.getNo1(), comb.getNo2(), comb.getNo3(), value, comb.getLevel() + 1);
		}

		return newCombination;
	}

}
