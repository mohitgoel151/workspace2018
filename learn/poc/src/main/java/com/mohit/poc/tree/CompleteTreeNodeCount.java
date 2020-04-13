package com.mohit.poc.tree;

/**
 * 
 * https://leetcode.com/problems/count-complete-tree-nodes/
 * In a complete binary tree every level, except possibly the last, is completely filled, 
 * and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes 
 * inclusive at the last level h.
 * 
 * Sol :: 
 * Instead of traversing each node we can leverage the advantage of having complete tree
 * 
 * At each step we calculate left nodes height of left and right sub tree from that node.
 * 
 * If height of both are same that means left subTree is complete tree and we can calculate node count by Math.pow(2, h) = N
 * This value also covers parent node as well.
 * 
 * if (lh != rh) that means right subtree is complete with height "rh" and left sub tree is incomplete
 * so for this case calculate height of right Tree and and do recursion on left sub tree. 
 *
 *	
 *	Another Approach : 
 *  https://leetcode.com/problems/count-complete-tree-nodes/discuss/564764/log(n)*log(n)-with-Huffman-coding-technique.-Java-100-faster.
 *  
 *  Try to make a string as huffman coding. If we move left add "0" to string and if we move right we add "1" to the string.
 *  
 *  At each step we calculate height of left subtree and right subtree. 
 *  if (lh == rh)
 *  	means we have scope to move right and in-completeness lies within right subtree.
 *  	node = node.right;
 *  	result += 1;
 *  else
 *  	in-completeness lies in left subtree and we can't move right side.
 *  	node = node.left;
 *  	result += 0;
 *  
 *  After doing this iteration we will get binary representation of last number which is present in this complete binary tree.
 *  Decoding this binary representation to int will give us required count value.  (Integer.parseInt(result, 2))
 *  
 *
 */
public class CompleteTreeNodeCount {

	public static void main(String[] args) {
		

	}

}

class ComoleteTreeNodeCountSol {

	public int countNodes(TreeNode root) {

		if (root == null) {
			return 0;
		}

		int leftSubTreeHeight = getLeftHeight(root.left);
		int rightSubTreeHeight = getLeftHeight(root.right);

		if (leftSubTreeHeight == rightSubTreeHeight) {
			// some portion of right subtree is incomplete ...
			int leftSubTreeNodeCount = (int) Math.pow(2, leftSubTreeHeight);
			return leftSubTreeNodeCount + countNodes(root.right);
		} else {
			// some portion of right subtree
			int rightSubTreeNodeCount = (int) Math.pow(2, rightSubTreeHeight);
			return rightSubTreeNodeCount + countNodes(root.left);
		}

	}

	private int getLeftHeight(TreeNode node) {
		if (node == null) {
			return 0;
		}

		return 1 + getLeftHeight(node.left);
	}
}

class TreeNode {
	
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}