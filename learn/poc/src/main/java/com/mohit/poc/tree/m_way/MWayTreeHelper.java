package com.mohit.poc.tree.m_way;

import java.util.Arrays;

public final class MWayTreeHelper {
    
    /**
     * 
     *                          A
     *                         / \
     *                        B   C
     *                          / / \ \
     *                         D E  F  G
     *                         | |    /|\
     *                         H I   J K L
     *                                 |
     *                                 M
     */
    public static MWayTreeNode getSampleTree() {
        
        MWayTreeNode n1 = new MWayTreeNode('a');
        MWayTreeNode n2 = new MWayTreeNode('b');
        MWayTreeNode n3 = new MWayTreeNode('c');
        MWayTreeNode n4 = new MWayTreeNode('d');        
        MWayTreeNode n5 = new MWayTreeNode('e');
        MWayTreeNode n6 = new MWayTreeNode('f');
        MWayTreeNode n7 = new MWayTreeNode('g');
        
        MWayTreeNode n8 = new MWayTreeNode('h');
        MWayTreeNode n9 = new MWayTreeNode('i');
        MWayTreeNode n10 = new MWayTreeNode('j');
        MWayTreeNode n11 = new MWayTreeNode('k');
        MWayTreeNode n12 = new MWayTreeNode('l');
        MWayTreeNode n13 = new MWayTreeNode('m');
        
        n1.setChildren(Arrays.asList(n2, n3));
        
        n3.setChildren(Arrays.asList(n4, n5, n6, n7));
        
        n4.setChildren(Arrays.asList(n8));
        n5.setChildren(Arrays.asList(n9));
        n7.setChildren(Arrays.asList(n10, n11, n12));
        n11.setChildren(Arrays.asList(n13));
        
        return n1;
    }
    
    public void printPreOrder(MWayTreeNode root) {
        //validation
        if(root == null) {
            return;
        }
        
        System.out.print(root.getValue());
        for (MWayTreeNode node : root.getChildren()) {
            printPreOrder(node);
        }

    }

}
