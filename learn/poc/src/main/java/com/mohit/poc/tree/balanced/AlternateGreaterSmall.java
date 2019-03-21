package com.mohit.poc.tree.balanced;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

/**
 * x = [8, 4, 9, 8, 7, 3, 7, 1, 2, 6]
one possible valid output would be:
x = [7, 8, 1, 6, 3, 4, 2, 9, 7, 8]
     1, 9, 2, 8, 3, 8, 4, 7, 6, 7 
 * 
 * x0 <= x1, x1 >= x2, x2 <= x3, x3 >= x4
 *
 */
public class AlternateGreaterSmall {

    public static void main(String[] args) {
        
        List<Integer> input = Arrays.asList(8, 4, 9, 8, 7, 3, 7, 1, 2, 6);
        TreeSet balancedSet = getBalancedTree(input);
        System.out.println(balancedSet);
        
    }
    
    private static TreeSet getBalancedTree(List<Integer> input) {
        
        TreeSet root = new TreeSet<>(input);
        
        
        
        return root;
    }

}
