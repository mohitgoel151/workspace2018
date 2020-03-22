package com.mohit.poc.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public final class TreeHelper {

    public static int getSizeOfTree(TNode node) {
        if (node == null) {
            return 0;
        }

        return 1 + getSizeOfTree(node.getLeftNode()) + getSizeOfTree(node.getRightNode());
    }

    public static int getDepthOfTree(TNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(getDepthOfTree(node.getLeftNode()), getDepthOfTree(node.getRightNode()));
    }
    
    public static TNode createBalanceBinarySearchree() {
        List<Integer> values = Arrays.asList(50,25,75,12,37,67,87,6,18,3,21);
        return TreeHelper.createBST(values);
    }

    public static TNode createBST(List<Integer> values) {
        if (values == null || values.size() == 0) {
            throw new RuntimeException("Invalid list provided");
        }
        TNode root = null;
        for (int i = 0; i < values.size(); i++) {
            if (i != 0) {
                addNodeInBST(root, new TNode(values.get(i)));
            } else {
                root = new TNode(values.get(i));
            }
        }
        return root;

    }
    
    public static void addNodeInBST(TNode treeNode, int val) {
    	addNodeInBST(treeNode, new TNode(val));
	}

    public static void addNodeInBST(TNode treeNode, TNode node) {
        if (treeNode == null) {
            throw new RuntimeException("node can not be added as tree is null");
        }

        if (node.getValue() <= treeNode.getValue()) {
            if (treeNode.getLeftNode() == null) {
                treeNode.setLeftNode(node);
            } else {
                addNodeInBST(treeNode.getLeftNode(), node);
            }
        } else {
            if (treeNode.getRightNode() == null) {
                treeNode.setRightNode(node);
            } else {
                addNodeInBST(treeNode.getRightNode(), node);
            }
        }
    }
    
    public static void printLevelOrder(TNode root) 
    { 
        // Base Case 
        if(root==null) 
            return ; 
          
        // Create an empty queue for level order traversal  
        Queue<TNode> q=new LinkedList<>(); 
        // Enqueue Root and initialize height  
        q.add(root); 
        while(true) 
        { 
            // nodeCount (queue size) indicates number  
            // of nodes at current level.  
            int nodeCount = q.size();  
            if (nodeCount == 0)  
                break; 
              
            // Dequeue all nodes of current level and  
            // Enqueue all nodes of next level  
            while (nodeCount > 0)  
            {  
                TNode node = q.remove();  
                System.out.print(node.value+" "); 
                if (node.leftNode != null)  
                    q.add(node.leftNode);  
                if (node.rightNode != null)  
                    q.add(node.rightNode);  
                nodeCount--;  
            }  
            System.out.println(); 
        } 
    } 
  

}
