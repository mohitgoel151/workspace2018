package com.mohit.poc.dp.tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 * https://leetcode.com/problems/sum-of-distances-in-tree/
 * 
 * Some what similar ==> https://www.youtube.com/watch?v=Xng1Od_v6Ug
 *
 * An undirected, connected tree with N nodes labelled 0...N-1 and N-1 edges are given.
 * The ith edge connects nodes edges[i][0] and edges[i][1] together.
 * Return a list ans, where ans[i] is the sum of the distances between node i and all other nodes.
 * 
 * 	Input: N = 6, edges = [[0,1],[0,2],[2,3],[2,4],[2,5]]
	Output: [8,12,6,10,10,10]
	Explanation: 
	Here is a diagram of the given tree:
  		0
 	   / \
	  1   2
   		 /|\
  		3 4 5
	We can see that dist(0,1) + dist(0,2) + dist(0,3) + dist(0,4) + dist(0,5)
	equals 1 + 1 + 2 + 2 + 2 = 8.  Hence, answer[0] = 8, and so on.
 *
 *	Time Complexity:  O(N), where NN is the number of nodes in the graph.
	Space Complexity: O(N).
 */
public class DistanceSum {

	public static void main(String[] args) {

		DistanceSumSol sol = new DistanceSumSol();

		sol.sumOfDistancesInTree(6, new int[][] { { 0, 1 }, { 0, 2 }, { 2, 3 }, { 2, 4 }, { 2, 5 } });// [8,12,6,10,10,10]
		sol.sumOfDistancesInTree(6, new int[][] { { 0, 1 }, { 0, 2 }, { 2, 3 }, { 5, 4 }, { 2, 5 } });// [9,13,7,11,13,9]
		sol.sumOfDistancesInTree(6, new int[][] { { 0, 1 }, { 0, 2 }, { 5, 3 }, { 2, 4 }, { 2, 5 } }); // [10,14,8,12,12,8]
		
		System.out.println("All cases passed " + sol.getClass().getSimpleName());
	}

}

/**
 * 1. Build graph for given edges and nodes. {#getConnections} (assuming all nodes are connected and no case of forest)
 * 2. Start with a post-order dfs approach where main aim is to obtain details of child subTrees
 * 2.1 set values in childCount array. (count of nodes in child sub trees including itself)
 * 2.2 While doing this also compute the distance sum for its subTrees.
 * 
 * 3. Start pre-order DFS where aim is to compute distance sum for each node considering its parent node values.
 *	  dSum[adj] = dSum[node] + (N-childCount[adj]) - childCount[adj];  // subtract last child sum because it is already considered in "dSum[node]"
 */
class DistanceSumSol {

	int N = 0;

	public int[] sumOfDistancesInTree(int N, int[][] edges) {
		if (N < 1 || edges == null || edges.length == 0)
			return new int[] { 0 };

		this.N = N;
		Map<Integer, Set<Integer>> connections = getConnections(edges);
		int[] childCount = new int[N];
		int[] sumDistance = new int[N];
		Arrays.fill(childCount, 1);  //childCount will also count itself as child

		doDFS(0, -1, childCount, sumDistance, connections);
		doDFS2(0, -1, childCount, sumDistance, connections);
		return sumDistance;
	}

	/**
	 *	Traverse as post-order DFS and compute node count in subtrees and well as distance sum for its subtrees 
	 */
	private void doDFS(int node, int parent, int[] cc, int[] sd, Map<Integer, Set<Integer>> conns) {

		for (int adjacent : conns.get(node)) {
			if (adjacent != parent) {
				doDFS(adjacent, node, cc, sd, conns);
				cc[node] += cc[adjacent];
				sd[node] += cc[adjacent] + sd[adjacent];
			}
		}
	}

	/**
	 *	Update distance sum of all nodes by considering there parent node distance sum and its child node sum.
	 */
	private void doDFS2(int node, int parent, int[] cc, int[] sd, Map<Integer, Set<Integer>> conns) {
		for (int adjacent : conns.get(node)) {
			if (adjacent != parent) {
				sd[adjacent] = sd[node] + (N - cc[adjacent]) - cc[adjacent];
				doDFS2(adjacent, node, cc, sd, conns);
			}
		}
	}

	private Map<Integer, Set<Integer>> getConnections(int[][] edges) {
		Map<Integer, Set<Integer>> connections = new HashMap<>();

		for (int[] edge : edges) {
			int parent = edge[0];
			int child = edge[1];

			Set<Integer> children = connections.get(parent);
			if (children == null) {
				children = new HashSet<>();
				connections.put(parent, children);
			}
			children.add(child);

			children = connections.get(child);
			if (children == null) {
				children = new HashSet<>();
				connections.put(child, children);
			}
			children.add(parent);
		}
		return connections;
	}
}