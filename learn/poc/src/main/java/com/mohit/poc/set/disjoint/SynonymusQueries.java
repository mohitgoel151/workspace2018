package com.mohit.poc.set.disjoint;

import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * https://medium.com/@alexgolec/google-interview-problems-synonymous-queries-36425145387c
 */
public class SynonymusQueries {

    public void execute() {
        
    }
    
    private boolean isSynonymus(Map<String, String> synonyms, String str1, String str2) {
        
        if(synonyms == null || synonyms.size() < 1 || str1 == null || str1.length() == 0 || str1 == null || str1.length() == 0) {
            throw new IllegalArgumentException("");
        }
        
        
        
        return false;
    }
    
    
    private Set<DSetNode<String>> makeDisjointSet(Map<String, String> synonyms) {
        
        Set<DSetNode<String>> dSet = new HashSet<>();
        
        for(Entry<String, String> entry : synonyms.entrySet()) {
            
            
            
        }
        
        
        return null;
    }
    
}
