package com.mohit.combinations;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class AllCombinationsOfSet {

    public void execute() {

        assertEquals(4, combinations(Arrays.asList(1, 2)));
        assertEquals(8, combinations(Arrays.asList(1, 2, 3)));
        assertEquals(16, combinations(Arrays.asList(1, 2, 3, 4)));
    }

    private int combinations(List<Integer> input) {

        if (input == null || input.size() == 0) {
            return 0;
        }

        Set<Set<Integer>> tempCombinations = new HashSet<>();
        Set<Set<Integer>> finalCombinations = new HashSet<>();

        tempCombinations.add(new HashSet<Integer>());
    
        for (Integer aNumber : input) {
            Iterator<Set<Integer>> it = tempCombinations.iterator();
            finalCombinations.addAll(tempCombinations);
            
            while (it.hasNext()) {
                Set<Integer> newSet = new HashSet<Integer>(it.next());
                newSet.add(aNumber);
                finalCombinations.add(newSet);
            }
            
            tempCombinations.clear();
            tempCombinations.addAll(finalCombinations);
            finalCombinations.clear();

        }
        
        System.out.println(tempCombinations);
        return tempCombinations.size();
    }

}
