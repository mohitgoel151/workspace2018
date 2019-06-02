package com.mohit.poc.graph;

public class GraphEdge<T> {

	private int weight;
	private GraphNode<T> node;

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public GraphNode<T> getNode() {
		return node;
	}

	public void setNode(GraphNode<T> node) {
		this.node = node;
	}

	public GraphEdge(int weight, GraphNode<T> node) {
		super();
		this.weight = weight;
		this.node = node;
	}

	@Override
	public String toString() {
		return "GraphEdge [weight=" + weight + ", node=" + node + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((node == null) ? 0 : node.hashCode());
		result = prime * result + weight;
		return result;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GraphEdge other = (GraphEdge) obj;
		if (node == null) {
			if (other.node != null)
				return false;
		} else if (!node.equals(other.node))
			return false;
		if (weight != other.weight)
			return false;
		return true;
	}

}
