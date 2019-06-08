package com.mohit.poc.tree;

import static org.junit.Assert.assertEquals;

import org.apache.commons.lang3.mutable.MutableInt;

public class DiaOfTree {

    public void execute() {
        
        TNode root = TreeHelper.createBalanceBinarySearchree();
        assertEquals(7, getDia(root));
        
        System.out.println("All test cases passed   :)");
        
    }

    private int getDia(TNode node) {
        MutableInt height = new MutableInt(0);
        return calculateDia(node, height);
    }
    
    /**
     * 
     * @param node
     * @param height
     * @return
     */
    private int calculateDia(TNode node, MutableInt height) {
        
        if(node == null) {
            return 0;
        }
        
        MutableInt lh = new MutableInt();
        MutableInt rh = new MutableInt();
        
        int lDia = calculateDia(node.leftNode, lh);
        int rDia = calculateDia(node.rightNode, rh);
        
        int tempDia = 1 + lh.intValue() + rh.intValue();
        int tempHeight = 1 + Math.max(lh.intValue(), rh.intValue());
        height.setValue(tempHeight);
        
        return Math.max(tempDia, Math.max(lDia, rDia));
    }

}
