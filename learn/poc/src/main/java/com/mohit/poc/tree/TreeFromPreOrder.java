package com.mohit.poc.tree;

/*
 * https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal
 * 
 * Return the root node of a binary search tree that matches the given preorder traversal.

	(Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, 
	and any descendant of node.right has a value > node.val.  
	Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)
	
 */
public class TreeFromPreOrder {

	public static void main(String[] args) {
		TreeFromPreOrderSol sol = new TreeFromPreOrderSol();
		sol.bstFromPreorder(new int[] { 8, 5, 1, 7, 10, 12 });
		sol.bstFromPreorder(new int[] { 8, 15, 11, 17, 18, 19 });
	}
}

class TreeFromPreOrderSol {

	public TreeNode bstFromPreorder(int[] preorder) {

		if (preorder == null || preorder.length == 0) {
			return null;
		}

		if (preorder.length == 1) {
			return new TreeNode(preorder[0]);
		}

		return helper(preorder, 0, preorder.length - 1);
	}

	/*
	 * Create node with value at start and divide remain portion of string for left and right subtree
	 * return this node.
	 */
	private TreeNode helper(int[] preorder, int start, int end) {

		if (start > end) {
			return null;
		}

		TreeNode node = new TreeNode(preorder[start]);
		if (start == end) {
			return node;
		}

		int leftSubTreeEnd = getEndForLeftSubTree(preorder, preorder[start], start + 1, end);

		/*
		 * In case value at index -> leftSubTreeEnd is greater than value at start that means there is no left sub tree and go else part
		 * otherwise recursively call for left and right subtree
		 */
		if (preorder[leftSubTreeEnd] < preorder[start]) {
			node.left = helper(preorder, start + 1, leftSubTreeEnd);
			node.right = helper(preorder, leftSubTreeEnd + 1, end);
		} else {
			node.right = helper(preorder, start + 1, end);
		}

		return node;
	}

	/*
	 * Try to do binary search approach where returning index has value less then current value.
	 * In case all values are larger, start index will be returned and need to cheked on caller side
	 */
	private int getEndForLeftSubTree(int[] preorder, int currentValue, int start, int end) {

		int mid = 0;

		while (start <= end) {

			mid = (start + end) / 2;

			/*
			 * check if current value is greater than mid and less then mid+1.
			 * For checking mid+1, we need to ensure than mid+1 doesn't overshoot the length of input and also less then end index
			 */
			if (currentValue > preorder[mid] && (mid + 1 >= preorder.length || ((mid + 1) <= end && currentValue < preorder[mid + 1]))) {
				return mid;
			} else if (currentValue < preorder[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return mid;
	}
}