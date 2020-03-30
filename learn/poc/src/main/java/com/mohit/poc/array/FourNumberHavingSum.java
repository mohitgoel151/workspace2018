package com.mohit.poc.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.tuple.Pair;

public class FourNumberHavingSum {

	public static void main(String[] args) {
		FourNumberHavingSumSol obj = new FourNumberHavingSumSol();
		obj.execute();
	}

}

class FourNumberHavingSumSol {

	public void execute() {

		int[] input = new int[] { 1, 5, 1, 0, 6, 0 };
		printElements(input, 7);
		printElements(input, 13);
		printElements(input, 70);

	}

	private void printElements(int[] input, int sum) {
		
		if (input == null || input.length < 4) {
			return;
		}

		Map<Integer, List<Pair<Integer, Integer>>> map = new HashMap<>();

		for (int i = 0; i < input.length - 1; i++) {
			for (int j = i + 1; j < input.length; j++) {

				int s = input[i] + input[j];
				int remaining = sum - s;

				List<Pair<Integer, Integer>> val = map.get(remaining);
				if (val == null) {
					val = new ArrayList<>();
					map.put(s, val);
				}

				for (Pair<Integer, Integer> aPair : val) {
					if ((int) aPair.getLeft() == input[i] || (int) aPair.getLeft() == input[j]
							|| (int) aPair.getRight() == input[i] || (int) aPair.getRight() == input[j]) {
						continue;
					} else {
						System.out.println("Values are " + input[i] + ", " + input[j] + ", " + aPair.getLeft() + ", "
								+ aPair.getRight());
						return;
					}
				}
				val.add(Pair.of(input[i], input[j]));
			}
		}
		System.out.println("No numbers found");
	}
}
