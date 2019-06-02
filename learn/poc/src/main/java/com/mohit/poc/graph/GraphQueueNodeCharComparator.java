package com.mohit.poc.graph;

import java.util.Comparator;

public class GraphQueueNodeCharComparator implements Comparator<GraphQueueNode<Character>> {

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
