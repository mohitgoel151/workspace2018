package com.mohit.poc.tree;

public class TreeMirror {

    public void execute() {
        
        TNode originalTree = TreeHelper.createBalanceBinarySearchree();
        TreeHelper.printLevelOrder(originalTree);
        
        System.out.println("*****************");
        
        TNode mirror = createMirror(originalTree);
        TreeHelper.printLevelOrder(mirror);
        
    }

    private TNode createMirror(TNode node) {
        if(node == null) {
           return null; 
        }
        
        TNode aNode = new TNode(node.value);
        aNode.leftNode = createMirror(node.rightNode);
        aNode.rightNode = createMirror(node.leftNode);
        
        return aNode;
    }

}
