package com.mohit.poc.tree;

import java.util.Arrays;
import java.util.List;

/**
 * Prob : Given a partially sorted array and we need to find out the count of elements which doesn't follow
 * the order. 
 * Soln : Make a BST of those elements. If all elements are sorted in asc order then there will be
 * no left child for any node (count is 0) Else count is aggregated node count of all left subtrees
 * 
 */
public class GetInvertedCount {

    public void execute() {

        List<Integer> list = Arrays.asList(2, 5, 6, 7, 1, 3, 10, 4, 30);

        TNode root = TreeHelper.createBST(list);
        System.out.println("count = " + getInvertedCountValues(root));

    }

    private int getInvertedCountValues(TNode node) {
        if (node == null) {
            return 0;
        }
        int count = 0;
        if (node.getLeftNode() != null) {
            count += TreeHelper.getSizeOfTree(node.getLeftNode());
        }
        if (node.getRightNode() != null) {
            count += getInvertedCountValues(node.getRightNode());
        }
        return count;
    }

}
