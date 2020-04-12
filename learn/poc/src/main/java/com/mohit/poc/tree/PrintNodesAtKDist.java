package com.mohit.poc.tree;

/**
 * 
 *
 */
public class PrintNodesAtKDist {

    public void execute() {
        
        TNode root = TreeHelper.createBalanceBinarySearchree();
        
        System.out.println("*********************************");
        System.out.println("6 25");
        System.out.println();
        printNodesAt(root, 18, 2);
        
        System.out.println();
        System.out.println("*********************************");
        System.out.println("6 25");
        System.out.println();
        printNodesAt(root, 18, 2);
        
        System.out.println();
        System.out.println("*********************************");
        System.out.println("3 37 50");
        System.out.println();
        printNodesAt(root, 18, 3);
        
        System.out.println();
        System.out.println("*********************************");
        System.out.println("6 18");
        System.out.println();
        printNodesAt(root, 50, 3);
        
        System.out.println();
        System.out.println("*********************************");
        System.out.println("6 18");
        System.out.println();
        printNodesAt(root, 87, 5);
        
        System.out.println();
        System.out.println("*********************************");
        System.out.println("37");
        System.out.println();
        printNodesAt(root, 37, 0);
    }

    /**
     * 
     * @param root
     * @param i searchNode
     * @param k distance
     */
    private void printNodesAt(TNode root, int i, int k) {
        if(root == null || k < 0) {
            throw new IllegalArgumentException("invalid");
        }
        
        printNodes(root, i, k);
    }

    private int printNodes(TNode node, int i, int k) {
        
        if(node == null) {
            return -1;
        }
        
        if(node.value == i) {
            printNodesInSubTree(node, k);
            return k-1;
        }
        
        int lDist = printNodes(node.leftNode, i, k);
        if(lDist == 0) {
            System.out.print(node.value + " ");
        } else if(lDist > 0) {
            printNodesInSubTree(node.rightNode, lDist-1);
            return lDist-1;
        }
        
        int rDist = printNodes(node.rightNode, i, k);
        if(rDist == 0) {
            System.out.print(node.value + " ");
        } else if(rDist > 0) {
            printNodesInSubTree(node.leftNode, rDist-1);
            return rDist-1;
        }
        
        return -1;
    }

    private void printNodesInSubTree(TNode node, int k) {
        
        if(node == null) {
            return;
        }
        if(k == 0) {
            System.out.print(node.value + " ");
        }
        printNodesInSubTree(node.leftNode, k-1);
        printNodesInSubTree(node.rightNode, k-1);
    }

}
