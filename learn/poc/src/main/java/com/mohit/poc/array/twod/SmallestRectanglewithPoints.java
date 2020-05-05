package com.mohit.poc.array.twod;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 
 * https://leetcode.com/problems/minimum-area-rectangle/
 *
 * Given a set of points in the xy-plane, determine the minimum area of a rectangle formed from these points, with sides parallel to the x and y axes. 
 * If there isn't any rectangle, return 0.
 */
public class SmallestRectanglewithPoints {

	public static void main(String[] args) {
		

	}

}

class SmallestRectanglewithPointsSol {
	
	public int minAreaRect(int[][] points) {
		if (points == null || points.length == 0) {
			return 0;
		}
		Arrays.sort(points, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				if (a[0] != b[0]) {
					return Integer.compare(a[0], b[0]);
				} else {
					return Integer.compare(a[1], b[1]);
				}
			}
		});
		HashMap<Integer, HashSet<Integer>> xMap = new HashMap<>();
		HashMap<Integer, HashSet<Integer>> yMap = new HashMap<>();
		
		for (int i = 0; i < points.length; i++) {
			int x = points[i][0];
			int y = points[i][1];
			// x map
			HashSet<Integer> setX = xMap.get(x);
			if (setX == null) {
				setX = new HashSet<Integer>();
				xMap.put(x, setX);
			}
			setX.add(y);
			// y map
			HashSet<Integer> setY = yMap.get(y);
			if (setY == null) {
				setY = new HashSet<Integer>();
				yMap.put(y, setY);
			}
			setY.add(x);
		}
		
		int result = Integer.MAX_VALUE;
		for (int i = 0; i < points.length - 1; i++) {
			for (int j = i + 1; j < points.length; j++) {
				int x1 = points[i][0];
				int y1 = points[i][1];
				int x2 = points[j][0];
				int y2 = points[j][1];
				if (xMap.get(x1).contains(y2) && yMap.get(y1).contains(x2)) {
					int area = Math.abs((x1 - x2) * (y1 - y2));
					if (area > 0) {
						result = Math.min(result, area);
					}
				}
			}
		}
		if (result == Integer.MAX_VALUE) {
			return 0;
		}
		return result;
	}
}