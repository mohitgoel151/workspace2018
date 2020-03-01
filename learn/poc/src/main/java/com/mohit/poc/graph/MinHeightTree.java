package com.mohit.poc.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * https://leetcode.com/problems/minimum-height-trees/
 * 
 * For an undirected graph with tree characteristics, we can choose any node as the root. The result graph is
 * then a rooted tree. Among all possible rooted trees, those with minimum height are called minimum height
 * trees (MHTs). Given such a graph, write a function to find all the MHTs and return a list of their root
 * labels.
 * 
 * Format The graph contains n nodes which are labeled from 0 to n - 1. You will be given the number n and a
 * list of undirected edges (each edge is a pair of labels).
 * 
 * You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the
 * same as [1, 0] and thus will not appear together in edges.
 * 
 * Input: n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
 * 
 *   0  1  2
      \ | /
        3
        |
        4
        |
        5 
 * 
 * Output: [3, 4]
 *
 * 
 */
public class MinHeightTree {
    
    public void execute() {
        System.out.println(findMinHeightTrees(1, new int[][] {}));  //[0]
        
        System.out.println(findMinHeightTrees(2, new int[][] {{0,1}})); //[0,1]
        System.out.println(findMinHeightTrees(6, new int[][] {{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}})); // [3,4]
        System.out.println(findMinHeightTrees(6, new int[][] {{0,1}, {0,2}, {0,3}, {3,4}, {4,5}})); //[3]
        System.out.println(findMinHeightTrees(6, new int[][] {{3,0}, {3,1}, {3,2}, {3,4}, {5,4}})); //[3,4]
        
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        // validation

        if (edges.length == 0 || n == 2) {
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                result.add(i);
            }
            return result;
        }

        Map<Integer, Set<Integer>> freqCount = new HashMap<>();

        for (int[] edge : edges) {

            Set<Integer> a = freqCount.get(edge[0]);
            if (a == null) {
                a = new HashSet<>();
                freqCount.put(edge[0], a);
            }
            a.add(edge[1]);

            Set<Integer> b = freqCount.get(edge[1]);
            if (b == null) {
                b = new HashSet<>();
                freqCount.put(edge[1], b);
            }
            b.add(edge[0]);
        }

        int maxDepth = 0;
        List<Integer> result = new ArrayList<>();
        Queue<QueueNode> queue = new LinkedList<>();

        for (Map.Entry<Integer, Set<Integer>> entry : freqCount.entrySet()) {
            if (entry.getValue().size() == 1) {
                queue.add(new QueueNode(0, entry.getKey()));
            }
        }

        while (!queue.isEmpty()) {
            QueueNode node = queue.poll();

            for (Integer child : freqCount.get(node.value)) {
                freqCount.get(child).remove(node.value);

                if (freqCount.get(child).size() == 1) {
                    if ((node.depth + 1) > maxDepth) {
                        maxDepth = node.depth + 1;
                        result = new ArrayList<>();
                        result.add(child);
                    } else if ((node.depth + 1) == maxDepth) {
                        result.add(child);
                    }
                    queue.add(new QueueNode(node.depth + 1, child));
                }

            }
        }

        return result;
    }
}

class QueueNode {
    int depth;
    int value;

    public QueueNode(int d, int v) {
        depth = d;
        value = v;
    }
}
