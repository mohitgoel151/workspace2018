package com.mohit.poc.tree;

import static org.junit.Assert.assertEquals;

/**
 * 
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 * 
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. 
 * The path must contain at least one node and does not need to go through the root.
 * 
 * 
 * This problem is extension of diameter of tree problem but here we need to take care of some extra conditions
 *
 */
public class MaxSumPath {
	
	public static void main(String[] args) {
		MaxSumPathSol sol = new MaxSumPathSol();
		
		TNode root = new TNode(-3);
		root.leftNode = new TNode(9);
		
		//TC 1
		assertEquals(9, sol.maxPathSum(root));
		
		root.rightNode = new TNode(9);
		//TC 2
		assertEquals(15, sol.maxPathSum(root));
		
		System.out.println("All test cases passed " + sol.getClass().getSimpleName());
	}

}

class MaxSumPathSol {

	public int maxPathSum(TNode root) {

		if (root == null) {
			return 0;
		}

		return helper(root, new MutableInt());

	}

	private int helper(TNode node, MutableInt treeMaxPath) {

		if (node == null) {
			//We can not return 0 because 0 is greater than -ve value and that can give wrong result for case like (single node tree having -ve value)
			//If we return 0, then result will come as 0 but it should be the -ve value present in root node
			return Integer.MIN_VALUE;
		}

		MutableInt leftTreeMaxPath = new MutableInt();
		MutableInt rightTreeMaxPath = new MutableInt();

		int left = helper(node.leftNode, leftTreeMaxPath);
		int right = helper(node.rightNode, rightTreeMaxPath);

		int self = node.value;

		//Check all possible cases 
		//1. With self node only
		//2  Self + left
		//3. Self + right
		//4. Self + left + right
		int withNode = leftTreeMaxPath.value + rightTreeMaxPath.value + node.value;
		withNode = Math.max(withNode, leftTreeMaxPath.value + node.value);
		withNode = Math.max(withNode, rightTreeMaxPath.value + node.value);
		withNode = Math.max(withNode, node.value);

		int withoutNode = Math.max(left, right);

		//Similarly here as well
		treeMaxPath.value = Math.max(leftTreeMaxPath.value, rightTreeMaxPath.value) + node.value;
		treeMaxPath.value = Math.max(treeMaxPath.value, self);

		return Math.max(withNode, withoutNode);

	}

}

class MutableInt {
	public int value;

	public MutableInt() {
		value = 0;
	}

}