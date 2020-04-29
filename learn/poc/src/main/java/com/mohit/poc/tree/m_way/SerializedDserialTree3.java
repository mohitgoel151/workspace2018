package com.mohit.poc.tree.m_way;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 * 
 * Assign # value to null nodes while making String
 * 
 * Looks like smallest String can be achieved via this approach.
 * 
 * Another extension of this problem can be when node can have any number of children. (Refer approach 2)
 *
 */
public class SerializedDserialTree3 {

	public static void main(String[] args) {
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
		
		SerializedDserialTree3Sol sol = new SerializedDserialTree3Sol();
		
		String serailized = sol.serialize(root);
		assertTrue(serailized.contentEquals("1_2_3_#_#_4_5_"));
		
		TreeNode newRoot = sol.deserialize(serailized);
		
		assertEquals(newRoot.val, 1);
		assertEquals(newRoot.left.val, 2);
		assertEquals(newRoot.right.val, 3);
		assertEquals(newRoot.right.left.val, 4);
		assertEquals(newRoot.right.right.val, 5);
		System.out.println("All cases passed " + sol.getClass().getSimpleName());
	}

}

class SerializedDserialTree3Sol {
	
	/**
	 *	keep track of valid numbers within queue (this will help us to reduce string size)
	 *	For null nodes insert "#" in string
	 */
	public String serialize(TreeNode root) {
		if (root == null) {
			return null;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		StringBuilder builder = new StringBuilder();

		int count = 1;

		while (!queue.isEmpty() && count > 0) {
			TreeNode node = queue.poll();
			
			if (node != null) {
				count--;
				builder.append(node.val);
				queue.add(node.left);
				queue.add(node.right);

				if (node.left != null) {
					count++;
				}
				if (node.right != null) {
					count++;
				}

			} else {
				builder.append('#');
			}
			builder.append('_');
		}
		
		return builder.toString();
	}

	/**
	 *	 
	 */
	public TreeNode deserialize(String data) {

		if (data == null || data.length() == 0) {
			return null;
		}

		String[] numbers = data.split("_");
		int index = 0;

		TreeNode head = new TreeNode(Integer.parseInt(numbers[index++]));
		TreeNode node = head;

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(node);

		//Iterate till number of valid sections in input string
		while (index < numbers.length) {
			
			TreeNode tNode = queue.poll();
			if (tNode == null) {
				continue;
			}

			TreeNode lNode = null, rNode = null;

			String leftNodeValue = numbers[index++];
			if (!leftNodeValue.equals("#")) {
				lNode = new TreeNode(Integer.parseInt(leftNodeValue));
			}
			tNode.left = lNode;
			queue.add(lNode);

			if (index >= numbers.length) {
				break;
			}
			String rightNodeValue = numbers[index++];
			if (!rightNodeValue.equals("#")) {
				rNode = new TreeNode(Integer.parseInt(rightNodeValue));
			}
			tNode.right = rNode;
			queue.add(rNode);
		}
		return head;
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