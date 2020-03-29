package com.mohit.combinations;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class AllCombinationsOfSet {

	public static void main(String[] args) {
		AllCombinationsOfSetSol sol = new AllCombinationsOfSetSol();
		sol.execute();
	}
}

class AllCombinationsOfSetSol {

	public void execute() {
		assertEquals(4, combinations(Arrays.asList(1, 2)));
		assertEquals(8, combinations(Arrays.asList(1, 2, 3)));
		assertEquals(16, combinations(Arrays.asList(1, 2, 3, 4)));
	}

	private int combinations(List<Integer> input) {

		if (input == null || input.size() == 0) {
			return 0;
		}

		Set<Set<Integer>> resultCombinations = new HashSet<>();
		Set<Set<Integer>> tempCombinations = new HashSet<>();

		resultCombinations.add(new HashSet<Integer>());

		for (Integer aNumber : input) {

			tempCombinations.clear();
			tempCombinations.addAll(resultCombinations);

			Iterator<Set<Integer>> it = resultCombinations.iterator();
			while (it.hasNext()) {
				Set<Integer> newSet = new HashSet<>(it.next());
				newSet.add(aNumber);
				tempCombinations.add(newSet);
			}

			resultCombinations.clear();
			resultCombinations.addAll(tempCombinations);
		}

		System.out.println(resultCombinations);
		return resultCombinations.size();
	}

}
