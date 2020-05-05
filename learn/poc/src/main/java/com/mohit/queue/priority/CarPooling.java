package com.mohit.queue.priority;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 
 * https://leetcode.com/problems/car-pooling
 * 
 * You are driving a vehicle that has capacity empty seats initially available for passengers.  The vehicle only drives east 
 * (ie. it cannot turn around and drive west.)

	Given a list of trips, trip[i] = [num_passengers, start_location, end_location] contains information about the i-th trip: 
	the number of passengers that must be picked up, and the locations to pick them up and drop them off.  
	The locations are given as the number of kilometers due east from your vehicle's initial location.
	
	Return true if and only if it is possible to pick up and drop off all passengers for all the given trips. 
 *
 */
public class CarPooling {

    public void execute() {
        assertEquals(false, carPooling(new int[][]{{7,5,6},{6,7,8},{10,1,6}}, 16));
        
        assertEquals(true, carPooling(new int[][]{{3,2,7},{3,7,9},{8,3,9}}, 11));
        
        assertEquals(true, carPooling(new int[][]{{9,3,4},{9,1,7},{4,2,4},{7,4,5}}, 23));
        
       System.out.println("All test cases passed " + this.getClass().getSimpleName());
    }

    public boolean carPooling(int[][] trips, int capacity) {

        int seatsOccupied = 0;

        Arrays.sort(trips, new TripComparator());
        Queue<int[]> queue = new PriorityQueue<>(new DropComparator());

        //Iterate over trips which start early (Trip comparator)
        for (int[] trip : trips) {

        	//While considering each trip check if there any trip in queue which are already ended and update capacity accordingly
            while (!queue.isEmpty() && queue.peek()[2] <= trip[1]) {
                seatsOccupied -= queue.poll()[0];
            }
            queue.add(trip);
            seatsOccupied += trip[0];

            if (seatsOccupied > capacity) {
                return false;
            }
        }
        return true;
    }
}

class DropComparator implements Comparator<int[]> {
    @Override
    public int compare(int[] a, int[] b) {
        return a[2] - b[2];
    }
}

//Sort on the basis of pickup and in case pickup is same than sort on the basis of earlier drop
class TripComparator implements Comparator<int[]> {

    @Override
    public int compare(int[] a, int[] b) {
        if (a[1] == b[1]) {
            return a[2] - b[2];
        } else {
            return a[1] - b[1];
        }
    }
}
