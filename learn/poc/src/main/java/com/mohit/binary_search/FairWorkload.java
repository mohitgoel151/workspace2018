package com.mohit.binary_search;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * https://community.topcoder.com/stat?c=problem_statement&pm=1901&rd=4650
 * 
 * Fabian is in charge of a law firm working on an important case. For a case coming up, he needs a specific
 * folder which is stored in one of the filing cabinets arranged in a line against the wall of the records
 * room. He has assigned a number of workers to find the folder from the filing cabinets. He doesn't want the
 * workers to get in each other's way, nor does he want folders from different filing cabinets getting mixed
 * up, so he has decided to partition the cabinets, and assign a specific section to each worker. Each worker
 * will have at least 1 cabinet to search through.
 * 
 * More specifically, Fabian wants to divide the line of filing cabinets into N sections (where N is the
 * number of workers) so that every cabinet that the ith worker looks through is earlier in the line than
 * every cabinet that the jth worker has to look through, for i < j.
 * 
 * His initial thought was to make all the sections equal, giving each worker the same number of filing
 * cabinets to look through, but then he realized that the filing cabinets differed in the number of folders
 * they contained. He now has decided to partition the filing cabinets so as to minimize the maximum number of
 * folders that a worker would have to look through. For example, suppose there were three workers and nine
 * filing cabinets with the following number of folders:
 * 
 *
 */
public class FairWorkload {
	
	public static void main(String[] ar) {
		FairWorkloadSol sol = new FairWorkloadSol();
		sol.execute();
	}
	
}

class FairWorkloadSol {

    public void execute() {

        assertEquals(170, getMostWork(new int[] { 10, 20, 30, 40, 50, 60, 70, 80, 90 }, 3));
        assertEquals(110, getMostWork(new int[] { 10, 20, 30, 40, 50, 60, 70, 80, 90 }, 5));

        assertEquals(1785, getMostWork(new int[] { 568, 712, 412, 231, 241, 393, 865, 287, 128, 457, 238, 98, 980, 23, 782 }, 4));
        assertEquals(1000, getMostWork(new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1000 }, 2));
        assertEquals(200, getMostWork(new int[] { 50, 50, 50, 50, 50, 50, 50 }, 2));

        assertEquals(100, getMostWork(new int[] { 1, 1, 1, 1, 100 }, 5));
        assertEquals(950, getMostWork(new int[] { 950, 650, 250, 250, 350, 100, 650, 150, 150, 700 }, 6));
        
        try {
            assertEquals(100, getMostWork(new int[] { 1, 1, 1, 1, 100 }, 25));
        } catch (Exception e) {
            assertTrue(e.getClass().equals(IllegalArgumentException.class));
        }

        System.out.println("All test cases passed " + this.getClass().getSimpleName());

    }

    public int getMostWork(int[] folders, int workers) {

        if (folders == null || workers < 1 || folders.length < workers) {
            throw new IllegalArgumentException("");
        }

        int totalWork = 0;
        int maxWork = 0;
        for (int index = 0; index < folders.length; index++) {
            totalWork += folders[index];
            maxWork = Math.max(maxWork, folders[index]);
        }

        if (folders.length == workers) {
            return maxWork;
        }
        
        maxWork = Math.max(maxWork, totalWork/workers);
        
        return getBestWork(folders, maxWork, totalWork - workers + 1, workers);
    }

    private int getBestWork(int[] folders, int start, int end, int workers) {

        int result = end;

        while (start <= end) {

            int mid = (end + start) / 2;

            int canWork = optimumWork(folders, mid, workers);

            if (canWork >= 0) { // workers are remaining
                end = mid - 1;
                result = Math.min(result, mid);
            } else if (canWork < 0) { // increase limit
                start = mid + 1;
            } 

        }
        return result;
    }
    
    private int optimumWork(int[] folders, int workLimit, int workers) {
        int work = 0;
        int remainingWorkers = workers - 1;

        for (int i = 0; i < folders.length; i++) {
            work += folders[i];
            if (work > workLimit) {
                work = folders[i];
                remainingWorkers--;
            }
        }
        return remainingWorkers;
    }

}
