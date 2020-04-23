package com.mohit.poc.unionfind;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * https://leetcode.com/problems/friend-circles/
 * 
 * There are N students in a class. Some of them are friends, while some are not. Their friendship is transitive in nature. For example, if A is a direct friend of B, and B is a direct friend of C, then A is an indirect friend of C. And we defined a friend circle is a group of students who are direct or indirect friends.

Given a N*N matrix M representing the friend relationship between students in the class. If M[i][j] = 1, then the ith and jth students are direct friends with each other, otherwise not. And you have to output the total number of friend circles among all the students.

Summary : need to find clusters of friends relation

Input: 
[[1,1,0],
 [1,1,0],
 [0,0,1]]
Output: 2
Explanation:The 0th and 1st students are direct friends, so they are in a friend circle. 
The 2nd student himself is in a friend circle. So return 2.

 */
public class FriendCircle {

	public static void main(String[] args) {
		FriendCircleGraphSol graphSol = new FriendCircleGraphSol();
		FriendCircleUnionSol unionSol = new FriendCircleUnionSol();

		int[][] input = new int[][] { { 1, 0, 0, 1 }, { 0, 1, 1, 0 }, { 0, 1, 1, 1 }, { 1, 0, 1, 1 } };
		assertEquals(graphSol.findCircleNum(input), unionSol.findCircleNum(input));

	}

}

class FriendCircleUnionSol {

	/*
	 * took 1 ms (5* faster)
	 */
	public int findCircleNum(int[][] M) {

		if (M == null || M.length == 0 || M.length != M[0].length) {
			return 0;
		}

		int count = M.length;
		int[] aux = new int[count];

		for (int i = 0; i < count; i++) {
			aux[i] = i;
		}

		for (int row = 0; row < count; row++) {
			for (int col = row + 1; col < count; col++) {

				if (M[row][col] == 1) {

					int rowParent = getParent(aux, row);
					int colParent = getParent(aux, col);

					/*
					 * Update root node pointers
					 */
					if (rowParent != colParent) {
						aux[colParent] = rowParent;
					}
				}
			}
		}

		int result = 0;
		for (int i = 0; i < count; i++) {
			/*
			 * Get count of root nodes
			 */
			if (i == getParent(aux, i)) {
				result++;
			}
		}
		return result;
	}

	private int getParent(int[] aux, int index) {
		if (index == aux[index]) {
			return index;
		}
		aux[index] = getParent(aux, aux[index]);
		return aux[index];
	}
}

class FriendCircleGraphSol {

	/*
	 * Took 5 ms
	 */
	public int findCircleNum(int[][] M) {

		if (M == null || M.length == 0 || M.length != M[0].length) {
			return 0;
		}

		Map<Integer, Set<Integer>> friendshipMap = new HashMap<>();

		int students = M.length;

		for (int row = 0; row < students; row++) {
			for (int col = row; col < students; col++) {

				if (M[row][col] == 1) {
					Set<Integer> fr = friendshipMap.get(row);

					if (fr == null) {
						fr = new HashSet<>();
						friendshipMap.put(row, fr);
					}
					fr.add(col);

					fr = friendshipMap.get(col);

					if (fr == null) {
						fr = new HashSet<>();
						friendshipMap.put(col, fr);
					}
					fr.add(row);
				}
			}
		}

		boolean[] traversed = new boolean[students];
		int result = 0;

		for (int i = 0; i < students; i++) {

			if (traversed[i]) {
				continue;
			}
			result++;
			traversed[i] = true;
			markAllFriends(i, friendshipMap, traversed);

		}

		return result;
	}

	private void markAllFriends(int i, Map<Integer, Set<Integer>> friendshipMap, boolean[] traversed) {

		for (Integer relation : friendshipMap.get(i)) {
			if (traversed[relation] == false) {
				traversed[relation] = true;
				markAllFriends(relation, friendshipMap, traversed);
			}
		}
	}
}
