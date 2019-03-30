package com.mohit.poc.tree;

public class FlipTree {
    
    public void execute() {
        
        TNode root=new TNode(1); 
        root.leftNode=new TNode(2); 
        root.rightNode=new TNode(3); 
        root.leftNode.leftNode = new TNode(4);  
        root.leftNode.rightNode = new TNode(5);  
        
        root.rightNode.leftNode = new TNode(6);  
        root.rightNode.rightNode = new TNode(7); 
        
        System.out.println("Level order traversal of given tree"); 
        TreeHelper.printLevelOrder(root);  
        
        root = getFlippedTree(root);  
        System.out.println("Level order traversal of flipped tree"); 
        TreeHelper.printLevelOrder(root); 
    }
    
    private TNode getFlippedTree(TNode root) {
        
        if(root == null) {
            //throw IAE
        }
        return flipTree(root, null);
    }

    private TNode flipTree(TNode node, TNode parent) {
        
        if(node == null) {
            return null;
        }
        
        if (node.leftNode != null) {
            TNode newNode = flipTree(node.leftNode, node);
            TNode rightMostNode = getRightMostNode(newNode);
            
            rightMostNode.rightNode = parent;
            if(parent != null) {
                rightMostNode.leftNode = parent.rightNode;
                parent.leftNode = parent.rightNode = null;
            }
            return newNode;
        } else {
            node.rightNode = parent;
            node.leftNode = parent.rightNode;
            parent.leftNode = parent.rightNode = null;
            return node;
        }
    }

    private TNode getRightMostNode(TNode newNode) {
        if(newNode.rightNode != null) {
            return getRightMostNode(newNode.rightNode);
        }
        return newNode;
    }

}
