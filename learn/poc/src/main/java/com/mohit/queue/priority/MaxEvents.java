package com.mohit.queue.priority;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class MaxEvents {

	public static void main(String[] args) {

		MaxEventsSolution sol = new MaxEventsSolution();

		assertEquals(7, sol.maxEvents(new int[][] { { 1, 1 }, { 1, 2 }, { 1, 3 }, { 1, 4 }, { 1, 5 }, { 1, 6 }, { 1, 7 } }));
		assertEquals(4, sol.maxEvents(new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 2 } }));
		assertEquals(4, sol.maxEvents(new int[][] { { 1, 4 }, { 4, 4 }, { 2, 2 }, { 3, 4 }, { 1, 1 } }));

		assertEquals(27, sol.maxEvents(new int[][] { { 6, 6 }, { 3, 4 }, { 22, 26 }, { 29, 32 }, { 8, 10 }, { 8, 9 }, { 30, 30 },
						{ 19, 21 }, { 30, 34 }, { 20, 20 }, { 29, 32 }, { 4, 5 }, { 16, 17 }, { 3, 3 }, { 14, 16 },
						{ 9, 10 }, { 2, 5 }, { 7, 11 }, { 3, 3 }, { 18, 20 }, { 26, 28 }, { 15, 19 }, { 26, 27 },
						{ 22, 22 }, { 2, 3 }, { 16, 20 }, { 2, 3 }, { 23, 27 }, { 25, 28 }, { 17, 20 } }));
		
		System.out.println("All test casses passed " + sol.getClass().getSimpleName());

	}

}

class MaxEventsSolution {
	
	public int maxEvents(int[][] events) {

		if (events == null || events.length == 0) {
			return 0;
		}

		Map<Integer, List<Integer>> eventMap = new TreeMap<>();

		for (int[] event : events) {
			List<Integer> endDates = eventMap.get(event[0]);
			if (endDates == null) {
				endDates = new ArrayList<>();
				eventMap.put(event[0], endDates);
			}
			endDates.add(event[1]);
		}
		eventMap.put(100001, new ArrayList<>());

		int day = 0;
		int result = 0;
		Queue<Integer> pending = new PriorityQueue<>();

		for (Map.Entry<Integer, List<Integer>> entry : eventMap.entrySet()) {
			//remove expired events
			while (!pending.isEmpty()) {
				int endDay = pending.peek();
				if(endDay < day) {
					pending.poll();
				} else {
					break;
				}
			}
			
			int startDay = entry.getKey();
			
			while (day < startDay && !pending.isEmpty()) {
				int endDay = pending.poll();
				if (endDay >= day) {
					result++;
					day++;
				} 
			}
			day = startDay;
			pending.addAll(entry.getValue());

			if (!pending.isEmpty()) {
				pending.poll();
				result++;
				day++;
			}

		}
		return result;
	}
}