package com.mohit.poc.misc;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.mohit.poc.pojo.Interval;

/**
 * https://www.geeksforgeeks.org/merging-intervals/
 * 
 * 
 */
public class IntervalOverlap {
	public static void main(String[] args) {
		IntervalOverlapSol obj = new IntervalOverlapSol();
		obj.execute();
	}
}

class IntervalOverlapSol {

	public void execute() {

		Interval arr[] = new Interval[4];
		// arr[0]=new Interval(6,8);
		// arr[1]=new Interval(1,9);
		// arr[2]=new Interval(2,4);
		// arr[3]=new Interval(4,7);
		// output = 3

		arr[0] = new Interval(6, 8);
		arr[1] = new Interval(0, 2);
		arr[2] = new Interval(2, 4);
		arr[3] = new Interval(4, 7);
		// output = 2

		List<Interval> inputList = Arrays.asList(arr);

		System.out.println("max overlap =" + getMaxOverlappingIntervals(inputList));

		System.out.println("Merged List = " + getMergedOverlappedIntervals(inputList));

	}

	private int getMaxOverlappingIntervals(List<Interval> intervalList) {

		List<Integer> startList = intervalList.stream().map(a -> a.getStart()).collect(Collectors.toList());
		List<Integer> endList = intervalList.stream().map(a -> a.getEnd()).collect(Collectors.toList());

		startList.sort((a, b) -> a.compareTo(b));
		endList.sort((a, b) -> a.compareTo(b));

		int sIndex = 0, eIndex = 0;
		int overlap = 0;

		int temp = 0;

		while (sIndex < startList.size() || eIndex < endList.size()) {

			if (sIndex < startList.size()) {
				temp++;
				sIndex++;
			}

			if (overlap < temp) {
				overlap = temp;
			}

			if ((sIndex == startList.size()) || (startList.get(sIndex - 1) >= endList.get(eIndex))) {
				temp--;
				eIndex++;
			}

		}
		return overlap;
	}

	private List<Interval> getMergedOverlappedIntervals(List<Interval> inputList) {

		return null;
	}

}
