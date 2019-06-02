package com.mohit.poc.graph;

public class GraphQueueNode<T> {

	private int x;
	private int y;
	private T value;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public GraphQueueNode(int x, int y, T value) {
		super();
		this.x = x;
		this.y = y;
		this.value = value;
	}

	@Override
	public String toString() {
		return "GraphQueueNode [x=" + x + ", y=" + y + ", value=" + value + "]";
	}

}
