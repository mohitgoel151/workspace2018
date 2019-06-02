package com.mohit.poc.goog;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * 
Organiser(P0) of party has a bread loaf of length "l" and total members in party are x (lets take X=4)
P0 cut the bread in 2 halfs L1 & L2.  Gives L1 to P1 and keeps L2 with himself.

Now P1 make 2 equal portions of L1 says (L11, L12). Gives L11 to P2 and keeps L12 with himself.
P0 also mahe 2 equals portions of L2 say (L21, L22). Gives L21 to P3 and keeps L22 with himself.

Now
P0 has L22
P1 has L12
P2 has L11
P3 has L21

but the order will looks like    P2, P1, P3, P0 (think as left to right order of tree leaf nodes). We need to print this order/

 *
 */
public class GoogBreadPartition {

	public void execute() {
		
		System.out.println("5 3 6 2 7 4 8 1 ************");
		printInOrder(8);
		
		System.out.println();
		System.out.println("3 2 4 1  ************");
		printInOrder(4);
		
		System.out.println();
		System.out.println("5 3 6 2 4 1  **************");
		printInOrder(6);
		
		
	}

	private void printInOrder(int count) {
		
		int num = 0;
		
		Queue<Node> queue = new LinkedList<Node>();
		
		Node root = new Node(++num);
		queue.add(root);
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			
			node.setLeft(new Node(++num));
			node.setRight(new Node(node.getValue()));
			
			queue.add(node.getLeft());
			queue.add(node.getRight());
			
			if(num == count) {
				break;
			}
			
		}
		
		printTree(root);
		
		
	}
	
	private void printTree(Node root) {
		
		if(root == null) {
			return;
		}
		
		if(root.getLeft() == null && root.getRight() == null) {
			System.out.print(root.getValue() + " ");
			return;
		}
		printTree(root.getLeft());
		printTree(root.getRight());
		
	}

	private class Node {
		
		private int value;
		private Node left;
		private Node right;
		public int getValue() {
			return value;
		}
		public Node getLeft() {
			return left;
		}
		public void setLeft(Node left) {
			this.left = left;
		}
		public Node getRight() {
			return right;
		}
		public void setRight(Node right) {
			this.right = right;
		}
		
		public Node(int val) {
			value = val;
		}
	}

}
