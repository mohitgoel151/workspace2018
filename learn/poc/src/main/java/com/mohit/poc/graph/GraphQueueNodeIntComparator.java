package com.mohit.poc.graph;

import java.util.Comparator;

public class GraphQueueNodeIntComparator implements Comparator<GraphQueueNode<Integer>> {

	/**
	 * 
	 */
	@Override
	public int compare(GraphQueueNode<Integer> o1, GraphQueueNode<Integer> o2) {
		if(o1.getValue() > o2.getValue()) {
			return 1;
		} else if (o1.getValue() < o2.getValue()) {
			return -1;
		}
		return 0;
	}

}
