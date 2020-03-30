package com.mohit.poc.misc;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/gas-station/
 */
public class GasStation {

	public static void main(String[] args) {
		GasStationSol obj = new GasStationSol();
		obj.execute();
		System.out.println("All tc passed " + obj.getClass().getSimpleName());
	}
}

class GasStationSol {

	public void execute() {
		assertEquals(3, canCompleteCircuit(new int[] {1,2,3,4,5}, new int[] {3,4,5,1,2}));
		assertEquals(3, canCompleteCircuit(new int[] {2,3,4}, new int[] {3,4,3}));
	}

	/**
	 *	Start from first station.
	 *	At each station check if we can move to next with (existing gas + gas at stn - gas required for next station) => "left"
	 *	
	 *	if left < 0, we can not use previous station to start and has to try from next station (i+1).
	 *	All keep track of how much deficit we were during this move, and when we reach last station we should have atleast for which we were deficit earlier 
	 *		
	 *
	 */
	public int canCompleteCircuit(int[] gas, int[] cost) {

		int start = 0, deficit = 0, left = 0;
		
		for (int i = 0; i < gas.length; i++) {
			
			left += gas[i] - cost[i];
			
			if (left < 0) {
				start = i + 1;
				deficit += left;
				left = 0;
			}
		}
		return left + deficit >= 0 ? start : -1;
	}
}
