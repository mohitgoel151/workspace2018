package com.mohit.poc.array;

/**
 * 
 * Find range of given number (left and right bounds) in sorted array
 *
 */
public class RangeOfInt {

	public static void main(String[] args) {
		RangeOfIntInSorted obj = new RangeOfIntInSorted();
		obj.execute();
	}

}

class RangeOfIntInSorted {

	public void execute() { 
		System.out.println(getRangeFor(new int[] {0,1,2,3,4,5,6,7,8,9}, 7));                      //  7,  7
		System.out.println(getRangeFor(new int[] {0,1,2,3,4,5,6,7,7,7,7,7,7,7,7,7,7,7,8,9}, 7));  //  7, 17
		System.out.println(getRangeFor(new int[] {0,1,2,3,4,5,6,7,7,7,7,7,7,7,7,7,7,7,8,9}, 17)); // -1, -1
		System.out.println(getRangeFor(new int[] {0,1,2,3,4,5,6,7,7,7,7,7,7,7,7,7,7,7,8,9}, 0));  //  0,  0
		System.out.println(getRangeFor(new int[] {0,1,2,3,4,5,6,7,7,7,7,7,7,7,7,7,7,7,8,9}, 9));  //  19, 19
	}

	private Range getRangeFor(int[] input, int no) {

		if (input == null) {
			return null;
		}

		if (input.length == 0) {
			return new Range(0, 0);
		}

		int low = 0;
		int high = input.length;

		int left = getLeftRangeFor(input, no, low, high);
		int right = getRightRangeFor(input, no, low, high);

		return new Range(left, right);
	}

	private int getLeftRangeFor(int[] input, int no, int low, int high) {

		if (low > high || low >= input.length) {
			return -1;
		}

		int mid = (low + high) / 2;

		if (input[mid] > no) {
			return getLeftRangeFor(input, no, low, mid - 1);
		} else if (input[mid] < no) {
			return getLeftRangeFor(input, no, mid + 1, high);
		}

		// mid has this value
		int left = getLeftRangeFor(input, no, low, mid - 1);
		return (left == -1) ? mid : left;

	}

	private int getRightRangeFor(int[] input, int no, int low, int high) {

		if (low > high || low >= input.length) {
			return -1;
		}

		int mid = (low + high) / 2;

		if (input[mid] > no) {
			return getRightRangeFor(input, no, low, mid - 1);
		} else if (input[mid] < no) {
			return getRightRangeFor(input, no, mid + 1, high);
		}

		// mid has this value
		int right = getRightRangeFor(input, no, mid + 1, high);
		return (right == -1) ? mid : right;

	}

}

class Range {
	int start;
	int end;

	public Range(int s, int e) {
		start = s;
		end = e;
	}

	@Override
	public String toString() {
		return "Range [start=" + start + ", end=" + end + "]";
	}

}