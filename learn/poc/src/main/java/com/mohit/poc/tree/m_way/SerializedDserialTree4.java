package com.mohit.poc.tree.m_way;

import static org.junit.Assert.assertTrue;

/**
 * 
 * Can be another way of serail-deserial tree 
 * https://www.geeksforgeeks.org/construct-binary-tree-string-bracket-representation/
 * 
 * 
 * Looks like taking more chars than approach 3.
 *
 */
public class SerializedDserialTree4 {

	public static void main(String[] args) {
		SerializedDserialTree4Sol sol = new SerializedDserialTree4Sol();
		sol.execute();
	}
}

class SerializedDserialTree4Sol {
	
	@SuppressWarnings("unused")
	public void execute() {
//	     1
//	    / \
//	   2   3
//	      / \
//	     4   5

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);

		

		String serailized = serialize(root);
		assertTrue(serailized.contentEquals("1(2##)(3(4##)(5##))"));

		TreeNode newRoot = deserialize(serailized);

	}
	
	/**
	 *	Can we return tree as preOrder =>>  node.val(leftSubTreeString)(rightSubTreeString)
	 *	Can denote null child as #
	 */
	public String serialize(TreeNode root) {
		if (root == null) {
			return null;
		}

		return "1(2##)(3(4##)(5##))";
	}

	/**
	 * Will always get subtree with first char as root value
	 * break remaining String in 2 parts as leftSubTreeString & rightSubTreeString
	 */
	public TreeNode deserialize(String data) {

		if (data == null || data.length() == 0) {
			return null;
		}
		TreeNode root = new TreeNode(1);
		return root;
	}
}
