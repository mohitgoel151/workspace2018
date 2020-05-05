package com.mohit.poc.dp;


/*
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/EggDropping.java
 * 
 * https://leetcode.com/problems/super-egg-drop/submissions/
 * 
 * You are given K eggs, and you have access to a building with N floors from 1 to N. 

Each egg is identical in function, and if an egg breaks, you cannot drop it again.

You know that there exists a floor F with 0 <= F <= N such that any egg dropped at a floor higher than F will break, and any egg dropped at or below floor F will not break.

Each move, you may take an egg (if you have an unbroken one) and drop it from any floor X (with 1 <= X <= N). 

Your goal is to know with certainty what the value of F is.

What is the minimum number of moves that you need to know with certainty what F is, regardless of the initial value of F?
 */
public class EggDroping {

	public static void main(String[] args) {
		
		EggDropingSol ed = new EggDropingSol();
		
		System.out.println(ed.calculate(3,100));
		System.out.println(ed.calculate(20,50));
		
		/*
		 * Recursive sol is talking helllot of time
		 */
		//ed.calculateRecursive(3,10)
		//ed.calculateRecursive(5,50)
		
		System.out.println("All passed " + ed.getClass().getSimpleName());
	}

}

class EggDropingSol {

	/*
	 * Getting Time limit exceed with this sol on leet code
	 */
	public int calculate(int eggs, int floors) {

		int T[][] = new int[eggs + 1][floors + 1];
		int c = 0;
		
		for (int i = 0; i <= floors; i++) {
			//With single egg count will be equal to floor
			T[1][i] = i;
		}

		for (int egg = 2; egg <= eggs; egg++) {
			for (int floor = 1; floor <= floors; floor++) {
				
				T[egg][floor] = Integer.MAX_VALUE;
				for (int temp = 1; temp <= floor; temp++) {
					
					/*
					 * 2 Cases here
					 * 1. If edd breaks k floor then ... we will be left with e-1 eggs and k-1 floors to check
					 * 2. If it doesn't break then we will be left with all e eggs and floors-f floors to check
					 * Max of this will be the answer for this T[e][f]
					 */
					c = 1 + Math.max(T[egg - 1][temp - 1], T[egg][floor - temp]);
					
					T[egg][floor] = Math.min(T[egg][floor], c); 

				}
			}
		}
		return T[eggs][floors];
	}

	public int calculateRecursive(int eggs, int floors) {
		if (eggs == 1) {
			return floors;
		}
		if (floors == 0) {
			return 0;
		}
		int min = 1000;
		for (int i = 1; i <= floors; i++) {
			int val = 1 + Math.max(calculateRecursive(eggs - 1, i - 1), calculateRecursive(eggs, floors - i));
			if (val < min) {
				min = val;
			}
		}
		return min;
	}

}