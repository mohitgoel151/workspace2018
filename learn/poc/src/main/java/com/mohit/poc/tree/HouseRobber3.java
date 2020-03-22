package com.mohit.poc.tree;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * https://leetcode.com/problems/house-robber-iii
 * 
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." 
 * Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in 
 * this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.
 * 
 *   10
    / \
   5   15
    \    
     7   

Output: 22
Explanation: Maximum amount of money the thief can rob = 7 + 15 = 22.
 *
 */
public class HouseRobber3 {

	public static void main(String[] args) {
		HouseRobber3Sol sol = new HouseRobber3Sol();
		sol.execute();
		System.out.println("All test cases passed " + sol.getClass().getSimpleName());
	}

}

class HouseRobber3Sol {
	
	public void execute() {
		TNode root = TreeHelper.createBST(Arrays.asList(10,5,15,7));
		assertEquals(22, rob(root));
		
		TreeHelper.addNodeInBST(root, 20);
		assertEquals(37, rob(root));
	}
	
	public int rob(TNode root) {
	    
        Map<TNode, Integer> cache = new HashMap<>();
        return rob(root, cache);
    }
    
    private int rob(TNode node, Map<TNode, Integer> cache) {
        
        if(node == null) {
            return 0;
        }
        
        Integer cacheValue = cache.get(node);
        if(cacheValue != null) {
            return cacheValue;
        }
        
        //don't consider this node
        int withOutThis = rob(node.leftNode, cache) + rob(node.rightNode, cache);
        
        //consider this node
        int leftNodeTree = 0;
        int rightNodeTree = 0;
        if(node.leftNode != null) {
            leftNodeTree = rob(node.leftNode.leftNode, cache) + rob(node.leftNode.rightNode, cache);
        }
        if(node.rightNode != null) {
            rightNodeTree = rob(node.rightNode.leftNode, cache) + rob(node.rightNode.rightNode, cache);
        }
        
        int withThis = node.value + leftNodeTree + rightNodeTree;
        
        int max = Math.max(withThis, withOutThis);
        cache.put(node, max);
        return max;
    }
	
	
}
