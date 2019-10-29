package com.mohit.poc.graph;

import java.util.Comparator;

public class GraphQueueNodeCharComparator implements Comparator<GraphQueueNode<Character>> {

    /**
     * 
     * this version of if else block should be used because if we have used 
     * return o1.getValue() - o2.getValue()
     * 
     * Then application can give wrong results in case one or both numbers are -ve
     * 
     */
	@Override
	public int compare(GraphQueueNode<Character> o1, GraphQueueNode<Character> o2) {
		if(o1.getValue() > o2.getValue()) {
			return 1;
		} else if (o1.getValue() < o2.getValue()) {
			return -1;
		}
		return 0;
	}

}
