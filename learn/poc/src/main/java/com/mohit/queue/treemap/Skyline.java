package com.mohit.queue.treemap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

/*
 * https://leetcode.com/problems/the-skyline-problem/
 * 
 * Given skyline of a city merge the buildings
 * Time complexity is O(nlogn)
 * Space complexity is O(n)
 *
 * References
 * https://leetcode.com/discuss/67091/once-for-all-explanation-with-clean-java-code-nlog-time-space\
 * 
 * Imp points for this problem
 * 
 * 1. For same start ... higher height will come first in array
 * 2. For same end   ... lower height will come first
 * 3. If one is end and other is start .... start will always come first
 */
public class Skyline {

	public static void main(String[] args) {
		int[][] buildings = new int[][] { 
			{ 1, 3, 4 }, 
			{ 3, 4, 4 }, 
			{ 2, 6, 2 }, 
			{ 8, 11, 4 }, 
			{ 8, 11, 5 }, 
			{ 7, 9, 3 }, 
			{ 10, 11, 2 } 
		};
		
		SkylineSol sd = new SkylineSol();
		List<int[]> criticalPoints = sd.getSkyline(buildings);
		
		criticalPoints.forEach(cp -> System.out.println(cp[0] + " " + cp[1]));
	}

}

class SkylineSol {
	public List<int[]> getSkyline(int[][] buildings) {

		// for all start and end of building put them into List of BuildingPoint
		BuildingPoint[] buildingPoints = new BuildingPoint[buildings.length * 2];
		int index = 0;
		
		for (int building[] : buildings) {
			buildingPoints[index] = new BuildingPoint();
			buildingPoints[index].x = building[0];
			buildingPoints[index].isStart = true;
			buildingPoints[index].height = -building[2];  //Make sure that start always come first when one point is start and other is end

			buildingPoints[index + 1] = new BuildingPoint();
			buildingPoints[index + 1].x = building[1];
			buildingPoints[index + 1].isStart = false;
			buildingPoints[index + 1].height = building[2];
			index += 2;
		}
		
		Arrays.sort(buildingPoints, new BuildingPointComparator());

		// using TreeMap because it gives log time performance.
		// PriorityQueue in java does not support remove(object) operation in log time.
		TreeMap<Integer, Integer> queue = new TreeMap<>();
		queue.put(0, 1);
		
		int prevMaxHeight = 0;
		List<int[]> result = new ArrayList<>();
		
		for (BuildingPoint buildingPoint : buildingPoints) {
			// if it is start of building then add the height to map. If height already exists then increment the value
			if (buildingPoint.isStart) {
				int buildingHeight = -buildingPoint.height;
				Integer count = queue.getOrDefault(buildingHeight, 0);
				queue.put(buildingHeight, count+1);
				
			} else { // if it is end of building then decrement or remove the height from map.
				Integer count = queue.get(buildingPoint.height);
				count--;
				if(count > 0) {
					queue.put(buildingPoint.height, count);
				} else {
					queue.remove(buildingPoint.height);
				}
			}
			
			// peek the current height after addition or removal of building x.
			int currentMaxHeight = queue.lastKey();
			
			// if height changes from previous height then this building x becomes critical x.
			// So add it to the result.
			if (prevMaxHeight != currentMaxHeight) {
				result.add(new int[] { buildingPoint.x, currentMaxHeight });
				prevMaxHeight = currentMaxHeight;
			}
		}
		return result;
	}
}

class BuildingPoint {
	int x;
	boolean isStart;
	int height;

	@Override
	public String toString() {
		return "BuildingPoint [x=" + x + ", isStart=" + isStart + ", height=" + height + "]";
	}
	
}

class BuildingPointComparator implements Comparator<BuildingPoint> {

	@Override
	public int compare(BuildingPoint o1, BuildingPoint o2) {
		
		/*
		 * pick which has lower x
		 */
		if(o1.x != o2.x) {
			return o1.x - o2.x;
		} else { //x are same
			return o1.height - o2.height;  //Ascending order
		}
	}
	
}