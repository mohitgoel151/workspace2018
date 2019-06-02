package com.mohit.poc.graph;

import java.util.List;

/**
 * https://java2blog.com/dijkstra-java/
 * https://www.geeksforgeeks.org/minimum-edges-reverse-make-path-source-destination/
 * https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-greedy-algo-7/
 * @author mohgoel
 *
 */
public class ShortestPath2 {

	public void execute() {
		
		Graph<String> graph = new Graph<String>();
		graph.addDirectedEdge(0, new GraphNode<String>("0"), new GraphNode<String>("1"));
		
		graph.addDirectedEdge(0, new GraphNode<String>("2"), new GraphNode<String>("1"));
		graph.addDirectedEdge(0, new GraphNode<String>("2"), new GraphNode<String>("3"));
		graph.addDirectedEdge(0, new GraphNode<String>("6"), new GraphNode<String>("3"));
		graph.addDirectedEdge(0, new GraphNode<String>("5"), new GraphNode<String>("1"));
		
		graph.addDirectedEdge(0, new GraphNode<String>("4"), new GraphNode<String>("5"));
		graph.addDirectedEdge(0, new GraphNode<String>("6"), new GraphNode<String>("4"));
		
		
		
		addReverseEdges(graph);
		
		
	}
	
	private void addReverseEdges(Graph<String> graph) {
		
		//This node will act as source
		for (GraphNode<String> aNode : graph.getAdjList()) {
			for(GraphEdge<String> edge : aNode.getEdges()) {
				graph.addDirectedEdge(1, edge.getNode(), aNode);
			}
		}
	}
	
	
	private int getMinEdgeReversal(Graph<String> graph) {
		
		boolean[] traversedNodes = new boolean[graph.getAdjList().size()];
		
		
		
		
		
		
		
		
		return 0;
	}
	
	private int getIndexOfNode(Graph<String> graph, GraphNode<String>  node) {
		for (int i = 0; i < graph.getAdjList().size(); i++) {
			if(graph.getAdjList().get(i).getValue().equals(node.getValue())) {
				return i;
			}
		}
		throw new RuntimeException("Node not present");
	}
	
	

}
