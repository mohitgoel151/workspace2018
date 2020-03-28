package com.mohit.poc.dp;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class RussianDoll {

	public static void main(String[] args) {
		RussianDollSol sol = new RussianDollSol();
		sol.execute();
		System.out.println("All test casses passed " + sol.getClass().getSimpleName());
	}

}

class RussianDollSol {

	public void execute() {
		assertEquals(3, maxEnvelopes(new int[][] {{5,4},{6,4},{6,7},{2,3}}));
		assertEquals(5, maxEnvelopes(new int[][] {{15,8},{2,20},{2,14},{4,17},{8,19},{8,9},{5,7},{11,19},{8,11},{13,11},{2,13},{11,19},{8,11},{13,11},{2,13},{11,19},{16,1},{18,13},{14,17},{18,19}}));
	}

	public int maxEnvelopes(int[][] envelopes) {

		if (envelopes == null || envelopes.length == 0) {
			return 0;
		}

		Arrays.sort(envelopes, new EnvelopeComparator());
		Map<Integer, Integer> cache = new HashMap<>();

		//[[18, 19], [14, 17], [13, 11], [8, 9], [5, 7]]
		int maxCount = 0;
		for (int index = 0; index < envelopes.length; index++) {
			int count = getMax(index, cache, envelopes, 0);
			maxCount = Math.max(maxCount, count);
		}

		return maxCount;

	}

	private int getMax(int index, Map<Integer, Integer> cache, int[][] envelopes, int adjusted) {

		if (index == envelopes.length) {
			return 0;
		}

		Integer value = cache.get(index);
		if (value != null) {
			return value + 1;
		}
		int maxCount = 0;

		int[] currentEnvelope = envelopes[index];

		for (int i = index + 1; i < envelopes.length; i++) {
			int[] nextEnvelope = envelopes[i];
			if (canAdjust(currentEnvelope, nextEnvelope)) {
				int count = getMax(i, cache, envelopes, adjusted + 1);
				maxCount = Math.max(maxCount, count);
			}
		}

		cache.put(index, maxCount);
		return maxCount + 1;
	}

	private boolean canAdjust(int[] a, int[] b) {
		if (b[0] < a[0] && b[1] < a[1]) {
			return true;
		}
		return false;
	}

}

class EnvelopeComparator implements Comparator<int[]> {

	// decreasing order
	@Override
	public int compare(int[] a, int[] b) {
		if (a[0] == b[0]) {
			return b[1] - a[1];
		}
		return b[0] - a[0];
	}
}