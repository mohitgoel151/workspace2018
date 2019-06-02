package com.mohit.poc.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph<T> {

	private List<GraphNode<T>> adjList;

	public List<GraphNode<T>> getAdjList() {
		return adjList;
	}

	public Graph() {
		adjList = new ArrayList<GraphNode<T>>();
	}

	public void addDirectedEdge(int weight, GraphNode<T> source, GraphNode<T> dest) {
		addEdge(weight, dest, source);
	}

	public void addUndirectedEdge(int weight, GraphNode<T> node1, GraphNode<T> node2) {
		addEdge(weight, node1, node2);
		addEdge(weight, node2, node1);
	}

	protected void addEdge(int weight, GraphNode<T> source, GraphNode<T> dest) {

		addNode(dest);
		addNode(source);

		GraphEdge<T> edge = new GraphEdge<T>(weight, dest);

		List<GraphEdge<T>> edges = source.getEdges();
		if (edges == null) {
			edges = new LinkedList<GraphEdge<T>>();
			source.setEdges(edges);
		}
		
		for (GraphEdge<T> graphEdge : edges) {
			if(graphEdge.getNode().getValue().equals(dest.getValue())) {
				//edge already present between nodes
				return;
			}
		}
		edges.add(edge);

	}

	public void addNode(GraphNode<T> newNode) {
		
		if(newNode == null) {
			throw new IllegalArgumentException("null node");
		}
		
		for (GraphNode<T> graphNode : adjList) {
			if (graphNode.equals(newNode)) {
				return;
			}
		}
		adjList.add(newNode);
	}
}
