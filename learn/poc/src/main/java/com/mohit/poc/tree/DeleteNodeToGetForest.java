package com.mohit.poc.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * https://leetcode.com/problems/delete-nodes-and-return-forest/
 *
 */
public class DeleteNodeToGetForest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class DeleteNodeToGetForestSol {
    
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if(root == null) {
            return null;
        }

        List<TreeNode> result = new ArrayList<>();
        Set<Integer> toRemove = new HashSet<>();
        for(int a : to_delete) {
            toRemove.add(a);
        }

        TreeNode node = helper(root, toRemove, result);
        if(node != null) {
            result.add(node);
        }
        return result;

    }
    
    private TreeNode helper(TreeNode node, Set<Integer> toRemove, List<TreeNode> result) {
        if(node == null) {
            return null;
        }
    
        TreeNode lChild = helper(node.left, toRemove, result);
        TreeNode rChild = helper(node.right, toRemove, result);

        if(toRemove.contains(node.val)) {
            node.left = null;
            node.right = null;
            
            if(lChild != null) {
                result.add(lChild);
            }
            if(rChild != null) {
                result.add(rChild);
            }
            node = null;
        } else {
            node.left = lChild;
            node.right = rChild;
        }
        return node;

    }
}