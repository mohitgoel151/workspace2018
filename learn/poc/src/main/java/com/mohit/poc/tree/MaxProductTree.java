package com.mohit.poc.tree;

/**
 * https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/
 * 
 * Given a binary tree root. Split the binary tree into two subtrees by removing
 * 1 edge such that the product of the sums of the subtrees are maximized.
 * 
 * Since the answer may be too large, return it modulo 10^9 + 7.
 * 
 * Solution : 
 * 1. Calculate sum of complete tree 
 * 2. Start post order sort of traversal and return sum of subTree
 * 	  Substract it from total sum and then compare with already created sum
 *
 */
public class MaxProductTree {

	public static void main(String[] args) {
		Code code = new Code();
		code.execute();
	}

}

class Code {

	public void execute() {

	}

	long result = 0;
	int modulo = 1000000007;

	public int maxProduct(TNode root) {

		if (root == null) {
			return 0;
		}

		long treeSum = getCompleteTreeSum(root);
		subTreeSum(root, treeSum);
		return (int) (result % modulo);
	}

	private long subTreeSum(TNode node, long treeSum) {

		if (node == null) {
			return 0;
		}

		long leftSubTreeSum = subTreeSum(node.leftNode, treeSum);
		result = Math.max(result, leftSubTreeSum * (treeSum - leftSubTreeSum));

		long rightSubTreeSum = subTreeSum(node.rightNode, treeSum);
		result = Math.max(result, rightSubTreeSum * (treeSum - rightSubTreeSum));

		return leftSubTreeSum + rightSubTreeSum + node.value;
	}

	private long getCompleteTreeSum(TNode node) {
		if (node == null) {
			return (long) 0;
		}

		return (long) (node.value + getCompleteTreeSum(node.leftNode) + getCompleteTreeSum(node.rightNode));
	}
}