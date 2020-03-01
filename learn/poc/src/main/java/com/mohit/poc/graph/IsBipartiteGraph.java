package com.mohit.poc.graph;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * https://leetcode.com/problems/is-graph-bipartite/
 * 
 * Given an undirected graph, return true if and only if it is bipartite.

Recall that a graph is bipartite if we can split it's set of nodes into two independent subsets A and B such that every edge in the graph has one node in A and another node in B.

The graph is given in the following form: graph[i] is a list of indexes j for which the edge between nodes i and j exists.  Each node is an integer between 0 and graph.length - 1.  
There are no self edges or parallel edges: graph[i] does not contain i, and it doesn't contain any element twice.
 *
 */
public class IsBipartiteGraph {

    public void execute() {
        
        assertEquals(true, isBipartite(new int[][]{{1,3}, {0,2}, {1,3}, {0,2}}));
        
        assertEquals(false, isBipartite(new int[][]{{1,2,3}, {0,2}, {0,1,3}, {0,2}}));
        
        assertEquals(true, isBipartite(new int[][]{{4}, {}, {4}, {4}, {0,2,3}}));
        
        assertEquals(false, isBipartite(new int[][]{{}, {2,4,6}, {1,4,8,9}, {7,8}, {1,2,8,9}, {6,9}, {1,5,7,8,9}, {3,6,9}, {2,3,4,6,9}, {2,4,5,6,7,8}}));
        
        System.out.println("All test cases passes : " + this.getClass().getSimpleName());
    }

    public boolean isBipartite(int[][] graph) {

        if (graph == null || graph.length == 0) {
            return false;
        }

        Map<Integer, Set<Integer>> linkMap = new HashMap<>();

        for (int vertex = 0; vertex < graph.length; vertex++) {
            linkMap.put(vertex, new HashSet<>());
        }

        for (int vertex = 0; vertex < graph.length; vertex++) {
            int[] links = graph[vertex];
            Set<Integer> linkSet = linkMap.get(vertex);

            for (int node : links) {
                linkSet.add(node);
            }
        }

        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();
        boolean isSetAActive = true;

        Queue<Integer> queue = new LinkedList<>();

        for (int vertex = 0; vertex < graph.length; vertex++) {

            if (linkMap.get(vertex).size() == 0) {
                continue;
            }

            if (setA.contains(vertex) || setB.contains(vertex)) {
                continue;
            }

            queue.add(vertex);
            queue.add(null);

            while (!queue.isEmpty()) {

                Integer val = queue.poll();
                if (val != null) {

                    if (isSetAActive) {
                        if (setB.contains(val)) {
                            return false;
                        }
                        setA.add(val);
                        for (int adjacent : linkMap.get(val)) {
                            if (!setB.contains(adjacent))
                                queue.add(adjacent);
                        }
                    } else {
                        if (setA.contains(val)) {
                            return false;
                        }
                        setB.add(val);
                        for (int adjacent : linkMap.get(val)) {
                            if (!setA.contains(adjacent))
                                queue.add(adjacent);
                        }
                    }

                } else {
                    if (!queue.isEmpty()) {
                        queue.add(null);
                    }
                    isSetAActive = !isSetAActive;

                }
            }
        }
        return true;
    }

}
