package com.mohit.poc.string;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 
 * https://leetcode.com/problems/task-scheduler/ 
 * https://leetcode.com/problems/reorganize-string/
 * 
 * This problem can be extended to configurable gaps
 * And in some variations, filling empty slots can be asked.
 *
 * Given a string S, check if the letters can be rearranged so that two characters 
 * that are adjacent to each other are not the same.If possible, output any possible 
 * result.  If not possible, return the empty string.
 */
public class Reorganize {
    public void execute() {
        assertEquals("aba", reorganizeString("aab", 1));
        assertEquals("", reorganizeString("aaab", 1));
    }

    public String reorganizeString(String str, int minGap) {

        if (str == null || str.length() == 1) {
            return str;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        int maxFreq = 0;
        for (char ch : str.toCharArray()) {
            int count = map.getOrDefault(ch, 0);
            maxFreq = Math.max(maxFreq, count + 1);
            map.put(ch, count + 1);
        }

        Queue<Node> pq = new PriorityQueue<>(new NodeComparator());
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.add(new Node(entry.getValue(), entry.getKey()));
        }

        List<Node> list = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        int tempGap = minGap;
        while (!pq.isEmpty()) {

            Node n = pq.poll();
            tempGap--;
            builder.append(String.valueOf(n.value));
            n.count -= 1;
            if (n.count > 0) {
                list.add(n);
            }

            if (tempGap == -1) {
                pq.addAll(list);
                list = new ArrayList<>();

                tempGap = minGap;
            }

        }
        if (pq.isEmpty() && !list.isEmpty()) {
            return "";
        }
        return builder.toString();
    }

    class Node {
        int count;
        char value;

        public Node() {
            value = ' ';
        }

        public Node(int c, char v) {
            count = c;
            value = v;
        }
    }

    class NodeComparator implements Comparator<Node> {
        public int compare(Node n1, Node n2) {
            return n2.count - n1.count;
        }
    }

}
