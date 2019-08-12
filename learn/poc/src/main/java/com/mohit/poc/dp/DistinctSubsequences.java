package com.mohit.poc.dp;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;

/**
 * https://xmruibi.gitbooks.io/interview-preparation-notes/content/Algorithm/DynamicProgram/DistinctSubsequence.html
 */
public class DistinctSubsequences {

    public void execute() {
        
        assertEquals(3, getDistincySubsequenceCountRecursion("rabbbit", "rabbit"));
        assertEquals(1, getDistincySubsequenceCountRecursion("ABCDE", "ACE"));
        
        assertEquals(3, getDistincySubsequenceCountDPTable("rabbbit", "rabbit"));
        assertEquals(1, getDistincySubsequenceCountDPTable("ABCDE", "ACE"));
        
        System.out.println("Hurray all test cases passed .. " + this.getClass().getSimpleName());
        
    }
    
    private int getDistincySubsequenceCountDPTable(String s1, String s2) {
        
        if(StringUtils.isBlank(s1) || StringUtils.isBlank(s2)) {
            throw new IllegalArgumentException("");
        }
        
        return getCountByDPTable(s1, s2);
    }
    
    /**
     * Make 2 D matrix of 1,1 extra row and column
     * 
     * s1 is represented in columns and s2 as rows
     * mark first row as 1 (for empty pattern string)
     * mark first column as 0 (for empty major string)
     * as row and column are 1 index ahead so always compare charAt index of string as (i/j-1) position
     * 
     * if char are same then add [r][c-1] + [r-1][c-1]
     * else [r][c-1]
     * 
     * @param s1
     * @param s2
     * @return
     */
    private int getCountByDPTable(String s1, String s2) {
        
        int table[][] = new int[s2.length() + 1][s1.length() + 1];
        
        for(int row = 0; row <= s2.length(); row++) {
            for(int col = 0; col <= s1.length(); col++) {
                
                if(row == 0) {
                    table[row][col] = 1;
                } else if (col == 0) {
                    table[row][col] = 0;
                } else if(col < row) {
                    table[row][col] = 0;
                } else if (s2.charAt(row-1) == s1.charAt(col-1)) {
                    table[row][col] = getValueAt(table, row, col - 1) + getValueAt(table, row - 1, col - 1);
                } else {
                    table[row][col] = getValueAt(table, row, col - 1);
                }
            }
        }
        
        return table[s2.length()][s1.length()];
    }
    
    private int getValueAt(int[][] table, int row, int col) {
        if(row < 0 || col < 0) {
            return 0;
        }
        return table[row][col];
    }

    private int getDistincySubsequenceCountRecursion(String s1, String s2) {
        
        if(StringUtils.isBlank(s1) || StringUtils.isBlank(s2)) {
            throw new IllegalArgumentException("");
        }
        
        return getCountByRecursion(s1, s2, new HashMap<String, Integer>());
    }

    private int getCountByRecursion(String s1, String s2, HashMap<String, Integer> hashMap) {
        
        if(s1.length() < s2.length()) {
            return 0;
        } else if (s2.length() == 0) {
            return 1;
        }
        
        Integer cachedValue = hashMap.get(s1.length() + "_" + s2.length());
        if(cachedValue != null) {
            return cachedValue;
        }
        
        int temp = 0;
        
        if(s1.charAt(0) == s2.charAt(0)) {
            temp = getCountByRecursion(s1.substring(1), s2.substring(1), hashMap);
        }
        
        temp += getCountByRecursion(s1.substring(1), s2, hashMap);
        hashMap.put(s1.length() + "_" + s2.length(), temp);
        
        return temp;
        
    }

}
