package com.mohit.poc.tree;

import static org.junit.Assert.assertEquals;

import org.apache.commons.lang3.mutable.MutableBoolean;
import org.junit.Assert;

/**
 * Least common ancestor of tree
 */
public class LCAOfTree {

    public void execute() {
        
        TNode root = TreeHelper.createBalanceBinarySearchree();
        
        TreeHelper.printLevelOrder(root);
        
        assertEquals(50, getLCA(root, 3, 87).value);
        assertEquals(12, getLCA(root, 3, 21).value);
        assertEquals(67, getLCA(root, 67, 67).value);
        assertEquals(18, getLCA(root, 18, 21).value);
        
        //Unhappy cases
        assertEquals(null, getLCA(root, 93, 87));
        assertEquals(null, getLCA(root, -1, 87));
        
        try {
            assertEquals(null, getLCA(null, -1, 87).value);
            Assert.fail("Should have thrown an exception");
        } catch (Exception e) {
            String expectedMessage = "invalid";
            Assert.assertEquals("Exception message must be correct", expectedMessage, e.getMessage());
        }
        
    }

    /**
     * Validate if root is not null and return if both elements are present else return null
     * @param root
     * @param i first node value
     * @param j second node value
     * @return LCA
     */
    private TNode getLCA(TNode root, int i, int j) {
        if(root == null) {
            throw new IllegalArgumentException("invalid");
        }
        
        MutableBoolean is1stPresent = new MutableBoolean();
        MutableBoolean is2ndPresent = new MutableBoolean();
        
        TNode lca = calculateLCA(root, i, j, is1stPresent, is2ndPresent);
        
        if(is1stPresent.isTrue() && is2ndPresent.isTrue()) {
            return lca;
        } else {
            return null;
        }
    }

    private TNode calculateLCA(TNode node, int i, int j, MutableBoolean is1stPresent, MutableBoolean is2ndPresent) {
        
        if(node == null) {
            return null;
        }
        
        if(node.value == i) {
            is1stPresent.setTrue();
            checkIfAnotherNodePresentInSubTree(node, j, is2ndPresent);
            return node;
        } 
        if(node.value == j) {
            is2ndPresent.setTrue();
            checkIfAnotherNodePresentInSubTree(node, i, is1stPresent);
            return node;
        }
        TNode lNode = calculateLCA(node.leftNode, i, j, is1stPresent, is2ndPresent);
        
        //Why traverse right subTree if we have already found both elements in lest subTree
        if(is1stPresent.isTrue() && is2ndPresent.isTrue()) {
            return lNode;
        }
        
        TNode rNode = calculateLCA(node.rightNode, i, j, is1stPresent, is2ndPresent);
        
        if(lNode!= null && rNode != null) {
            return node;
        }
        
        return (lNode != null) ? lNode : rNode;
    }
    
    /**
     * Check if given value is present in given tree and update boolean if present
     * @param node
     * @param val
     * @param sBool
     */
    private void checkIfAnotherNodePresentInSubTree(TNode node, int val, MutableBoolean sBool) {
        if(node == null) {
            return;
        }
        if(node.value == val) {
            sBool.setTrue();
            return;
        }
        checkIfAnotherNodePresentInSubTree(node.leftNode, val, sBool);
        if(sBool.isFalse()) {
            checkIfAnotherNodePresentInSubTree(node.rightNode, val, sBool);
        }
    }

}
