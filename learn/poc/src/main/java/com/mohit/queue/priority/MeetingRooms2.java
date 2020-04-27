package com.mohit.queue.priority;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * https://leetcode.com/problems/meeting-rooms-ii/
 * 
 * https://www.programcreek.com/2014/05/leetcode-meeting-rooms-ii-java/
 */
public class MeetingRooms2 {

	public static void main(String[] args) {
		MeetingRooms2Sol sol = new MeetingRooms2Sol();
		assertEquals(2, sol.minMeetingRooms(new int[][] { { 0, 30 }, { 5, 10 }, { 15, 20 } }));
		System.out.println("All passed " + sol.getClass().getSimpleName());
	}

}

/**
 * Sort all intervals in ascending order of start time.
 * 
 * Also maintain priority queue which will hold meeting which is going to be finished earliest
 * 
 * whenever we get new interval in iterator... 
 * we check if heap has any meeting which is finished before starting this.
 * if so..... remove top entry from heap and add this.
 *
 */
class MeetingRooms2Sol {

	public int minMeetingRooms(int[][] intervals) {
		
		if(intervals == null || intervals.length < 2) {
			return 1;
		}
		
		Arrays.sort(intervals, new IntervalSorted());
		Queue<Integer> endTimeQueue = new PriorityQueue<>(); //Ascending order by default
		
		int result = 0;
		int runningCount = 0;
		
		for(int[] interval : intervals) {
			if(result == 0) {
				result++;
				runningCount++;
				endTimeQueue.add(interval[1]);
				continue;
			}
			
			int newStart = interval[0];
			int earliestFinished = endTimeQueue.peek();
			
			/*
			 * If new start	is earlier than earliestFinished
			 * we need one more room
			 */
			if(newStart < earliestFinished) {
				runningCount++;
				result = Math.max(runningCount, result);
			} else {
				endTimeQueue.poll();
			}
			endTimeQueue.add(interval[1]);
			
		}
		return result;
	}

}

/*
 * Ascending order on start time
 */
class IntervalSorted implements Comparator<int[]> {
	
	public int compare(int[] a, int[] b) {
		return a[0] - b[0];
	}
	
}
