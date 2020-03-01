package com.mohit.poc.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 * https://zhuhan0.blogspot.com/2017/07/leetcode-261-graph-valid-tree.html
 * 
 * Time complexity: O(V + E)
 *
 */
public class ValidGraphTree {
    
    public boolean validTree(int n, int[][] edges) {
        
        if (edges.length == 0) {
            return n == 1;
        }
        if (n != edges.length + 1) {
            return false;
        }
        
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        Set<Integer> visited = new HashSet<>();
        
        if (hasCycle(0, -1, graph, visited)) {
            return false;
        }
        return visited.size() == n;
    }
    
    private boolean hasCycle(int node, int parent, Map<Integer, Set<Integer>> graph, Set<Integer> visited) {
        visited.add(node);
        for (int neighbor : graph.get(node)) {
            if (neighbor != parent && visited.contains(neighbor)) {
                return true;
            }
            if (!visited.contains(neighbor) && hasCycle(neighbor, node, graph, visited)) {
                return true;
            }
        }
        return false;
    }

}
