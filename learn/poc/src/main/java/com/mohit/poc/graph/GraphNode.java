package com.mohit.poc.graph;

import java.util.List;

public class GraphNode<T> {

	private T value;
	private List<GraphEdge<T>> edges;

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public List<GraphEdge<T>> getEdges() {
		return edges;
	}

	public void setEdges(List<GraphEdge<T>> edges) {
		this.edges = edges;
	}

	public GraphNode(T value) {
		super();
		this.value = value;
	}

	@Override
	public String toString() {
		return "GraphNode [value=" + value + ", edges=" + edges + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((edges == null) ? 0 : edges.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GraphNode<?> other = (GraphNode<?>) obj;
		if (edges == null) {
			if (other.edges != null)
				return false;
		} else if (!edges.equals(other.edges))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

}
