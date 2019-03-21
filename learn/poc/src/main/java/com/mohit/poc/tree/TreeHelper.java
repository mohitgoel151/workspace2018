package com.mohit.poc.tree;

import java.util.List;

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

}
