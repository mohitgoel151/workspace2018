package com.mohit.poc.tree;

import static org.junit.Assert.assertEquals;

/**
 * 
 * https://www.geeksforgeeks.org/check-if-value-exists-in-level-order-sorted-complete-binary-tree/
 * 
                          5 
                       /    \  
                      8      10  
                    /  \    /  \ 
                  13    23 25   30 
                 / \   / 
                32 40 50 
 * 
 * Given a level-order sorted
 * complete binary tree, the task is to check whether a key exists in it or not.
 * A complete binary tree has every level except possibly the last, completely
 * filled, with all nodes as far left as possible.
 * 
 * Complexity : 
 * Assume height of tree is h (root being at 1 height and node 32 at level 4)
 * 
 * in worst case we would be finding element at last level.
 * element count at last level
 * count = Math.pow(2, height-1);  (8)   //node in last level  8 (Math.pow(2, 4-1)
 * 
 * We will be doing binary search on these 8 nodes.  So {log(count)}
 * On each middle point we traverse nodes of h height.
 * 
 * Over all time complexity = h * log(count)  ///  as count is 2 power h... and log is for base 2 .... so we can deduce it as
 * h * h
 * 
 * or if N is total nodes in tree and  N = Math.pow(2, h) ===> h = log N
 * 
 * Time complexity = h*h   or  logN * logN
 * 
 */
public class SortedLevelOrderTree {

	public static void main(String[] args) {

		Node root = new Node(5);
		root.left = new Node(8);
		root.right = new Node(10);
		root.left.left = new Node(13);
		root.left.right = new Node(23);
		root.right.left = new Node(25);
		root.right.right = new Node(30);
		root.left.left.left = new Node(32);
		root.left.left.right = new Node(40);
		root.left.right.left = new Node(50);

		SortedLevelOrderTreeSol sol = new SortedLevelOrderTreeSol();

		assertEquals(true, sol.findKey(root, 5));
		assertEquals(true, sol.findKey(root, 8));
		assertEquals(false, sol.findKey(root, 9));
		assertEquals(true, sol.findKey(root, 25));
		assertEquals(true, sol.findKey(root, 30));
		assertEquals(false, sol.findKey(root, 31));
		assertEquals(false, sol.findKey(root, 33));
		assertEquals(false, sol.findKey(root, 90));

		System.out.println("All passed " + sol.getClass().getSimpleName());
	}

}

class SortedLevelOrderTreeSol {

	/**
	 * 1. Find level at which required data node can be present (root being 0)
	 * 2. Find max count of nodes which can be there in complete tree 
	 *    Search data  can be present any where from 0 -> count-1 (if present) and we can apply binary search on these bounds
	 * 3. Get the middle node index (low + high)/2
	 * 4. Convert this middle number to binary String and now this  binary string can be used to traverse to this middle element.
	 * 5. for value 0 move  to left child and for 1 move to right child.
	 * 6. 
	 */
	public boolean findKey(Node root, int data) {

		if (root == null || data < root.val) {
			return false;
		}
		
		if(data == root.val) {
			return true;
		}

		int level = getLevelForData(root, data);
		int high = (int) Math.pow(2, level) - 1;

		return isPresent(root, data, 0, high);
	}

	/**
	 *	Do binary search on low and high range values
	 *	On each mid ... convert it to binary and then traverse it 
	 *	basis return value check if we can move  low or high indexes
	 */
	boolean isPresent(Node root, int data, int low, int high) {
		int mid = 0;
		char[] binaryChars = null;
		
		while (low <= high) {
			mid = (low + high) / 2;
			binaryChars = Integer.toBinaryString(mid).toCharArray();

			int check = traverse(binaryChars, root, data, -1);
			if (check == 0) {
				return true;
			} else if (check == -1) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return false;
	}

	int traverse(char[] binaryChars, Node node, int data, int index) {
		//It might be a case where this middle element does not exist... in this case we would like to make  high = mid-1
		if (node == null) {
			return -1;
		}
		
		//If last char of binary char ... make the final decision
		if (index + 1 == binaryChars.length) {
			if (node.val == data) {
				return 0; // Hurayy!!!!!!
			} else if (node.val < data)
				return 1; // if relevant node is present and its value is less then we would like to make  low = mid + 1;
			else
				return -1; // else   high = mid - 1;
		}
		
		char path = binaryChars[index+1];
		
		if (path == '0') {
			return traverse(binaryChars, node.left, data, index + 1);
		} else {
			return traverse(binaryChars, node.right, data, index + 1);
		}

	}

	//Return the level number at which searched data can be present (root being 0) 
	private int getLevelForData(Node node, int data) {
		int level = 0;
		while (node != null) {
			if (node.left != null && node.left.val > data) {
				break;
			} else {
				level++;
				node = node.left;
			}
		}
		return level;
	}

}

class Node {

	int val;
	Node left, right;

	public Node(int item) {
		val = item;
		left = right = null;
	}
}
