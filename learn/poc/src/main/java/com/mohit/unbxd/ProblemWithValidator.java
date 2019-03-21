package com.mohit.unbxd;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;


public class ProblemWithValidator {

	public static void main(String[] args) {

		Combination start = new Combination(1, 2, 3, 4, 0);
		Combination end = new Combination(1, 2, 3, 5, -1);

		// Can use any custom validator
		CombinationValidator validator = new EvenSumBlockedCombination();

		int steps = steps(start, end, validator);
		System.out.println(steps);
	}

	private static int steps(Combination start, Combination end, CombinationValidator validator) {

		if (Utility.isSameCombination(start, end)) {
			return 0;
		}

		Set<Combination> traversedCombination = new HashSet<>();
		Queue<Combination> queue = new LinkedList<>();
		queue.add(start);

		Combination node;
		List<Combination> adjacentNodes = null;

		/**
		 * Traverse till queue is not empty
		 */
		while (queue.isEmpty() == false) {
			node = queue.remove();

			if (Utility.isSameCombination(node, end)) {
				// Found the destination node
				return node.getLevel();
			}

			adjacentNodes = getPossibleUnTraversedCombinations(node, validator, traversedCombination);
			queue.addAll(adjacentNodes);
		}

		throw new RuntimeException("Destination combination is not valid");
	}

	/**
	 * Returns the list of all valid adjacent nodes which are not traversed till now
	 * 
	 * @param node
	 * @param blocked
	 * @param traversedNodes
	 * @return
	 */
	private static List<Combination> getPossibleUnTraversedCombinations(Combination node,
			CombinationValidator validator, Set<Combination> traversedNodes) {

		List<Combination> adjacentNodes = getPossibleCombinations(node, validator);
		List<Combination> untraversedNodes = new ArrayList<>();

		for (Combination combination : adjacentNodes) {
			if (traversedNodes.contains(combination) == false) {
				untraversedNodes.add(combination);
				traversedNodes.add(combination);
			}
		}

		return untraversedNodes;
	}

	/**
	 * Return list of all valid adjacent node combinations. (incrementing and
	 * decrementing all four digits)
	 * 
	 * @param node
	 * @param validator
	 * @return
	 */
	private static List<Combination> getPossibleCombinations(Combination node, CombinationValidator validator) {

		List<Combination> adjacentNodes = new ArrayList<>();

		for (int i = 0; i < 2; i++) {
			boolean isIncrement = (i == 0) ? true : false;
			for (int index = 0; index < 4; index++) {

				Combination temp = Utility.getCombinationWithIndex(node, index, isIncrement);
				if (validator.isValidCombination(temp)) {
					adjacentNodes.add(temp);
				}
			}
		}
		return adjacentNodes;
	}

}
