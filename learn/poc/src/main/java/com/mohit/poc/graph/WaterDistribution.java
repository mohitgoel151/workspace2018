package com.mohit.poc.graph;

import static org.junit.Assert.assertEquals;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://github.com/azl397985856/leetcode/blob/master/problems/1168.optimize-water-distribution-in-a-village-en.md
 * 
 * There are n houses in a village. We want to supply water for all the houses
 * by building wells and laying pipes.
 * 
 * For each house i, we can either build a well inside it directly with cost
 * wells[i], or pipe in water from another well to it. The costs to lay pipes
 * between houses are given by the array pipes, where each pipes[i] = [house1,
 * house2, cost] represents the cost to connect house1 and house2 together using
 * a pipe. Connections are bidirectional.
 * 
 * Find the minimum total cost to supply water to all houses.
 *
 */
public class WaterDistribution {

	public static void main(String[] args) {

		WaterDistributionSolution sol = new WaterDistributionSolution();
		sol.execute();

		System.out.println("All test cassed passed " + sol.getClass().getSimpleName());

	}

}

class WaterDistributionSolution {

	public void execute() {

		assertEquals(3, minCostToSupplyWater(3, new int[] { 1, 2, 2 }, new int[][] { { 1, 2, 1 }, { 2, 3, 1 } }));

		assertEquals(8, minCostToSupplyWater(5, new int[] { 1,2,2,3,2 }, new int[][] { { 1,2,1}, {2,3,1}, {4,5,7 } }));
		
		assertEquals(10, minCostToSupplyWater(5, new int[] { 1,2,2,3,2 }, new int[][] { }));

	}

	public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
		
		int result  = 0;
		int edgesRemaining = n;
		
		
		int[] parent = new int[n+1];
		for(int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}
		
		Queue<Edge> queue = new PriorityQueue<>(new EdgeComparator());
		
		for(int well = 0; well < wells.length; well++) {
			queue.add(new Edge(0, well+1, wells[well]));
		}
		
		for(int pipe = 0; pipe < pipes.length; pipe++) {
			queue.add(new Edge(pipes[pipe][0], pipes[pipe][1], pipes[pipe][2]));
		}
		
		while(!queue.isEmpty()) {
			
			Edge edge = queue.poll();
			int fromParent = getParent(parent, edge.from);
			int toParent = getParent(parent, edge.to);
			
			if(fromParent == toParent) {
				continue;
			}
			
			result += edge.weight;
			parent[fromParent] = toParent;
			edgesRemaining--;
			
			if(edgesRemaining == 0) {
				break;
			}
			
		}
		
		return result;
	}
	
	private int getParent(int[] parent, int node) {
		if(parent[node] == node) {
			return node;
		}
		parent[node] = getParent(parent, parent[node]);
		return parent[node];
	}
	
}

class Edge {
	int from;
	int to;
	int weight;
	
	public Edge(int f, int t, int w) {
		from = f;
		to = t;
		weight = w;
	}
	
}

class EdgeComparator implements Comparator<Edge> {
	
	@Override
	public int compare(Edge e1, Edge e2) {
		return e1.weight - e2.weight;
	}
}