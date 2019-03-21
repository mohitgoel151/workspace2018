package com.mohit.poc.trie;

import java.util.List;

public final class TrieHelper {

    public static final TrieNode generateTrie(List<String> words) {

        TrieNode rootNode = new TrieNode();
        for (String word : words) {
            addWordToTrie(word, rootNode);
        }
        return rootNode;
    }
    
    public static final void addWordToTrie(String word, TrieNode node) {
        addWordToTrieInLowerCase(word.toLowerCase(), 0, node);
    }
    
    private static final void addWordToTrieInLowerCase(String word, int index, TrieNode node) {
        
        if(word.length() == 0) {
            return;
        }
        
        char charValue = word.charAt(index);
        TrieNode childNode = node.getChildren()[charValue - 97];
        if(childNode == null) {
            childNode = new TrieNode(charValue);
            node.getChildren()[charValue - 97] = childNode;
        }
        
        if(index == word.length() - 1) {
            childNode.setWord(true);
        } else {
            addWordToTrieInLowerCase(word, index + 1, childNode);
        }
        
    }
    
    public static boolean isPresentInDict(String word, TrieNode node) {
        
        if(word == null || word.length() == 0 || node == null) {
            return false;
        }
        
        TrieNode branchFork = node.getChildren()[word.toLowerCase().charAt(0) - 97];
        return isPresent(word.toLowerCase(), 0, branchFork);
        
    }
    
    private static boolean isPresent(String word, int index, TrieNode node) {

        if (node == null) {
            return false;
        }

        if (index == word.length() - 1) {
            return node.isWord();
        } else {
            return isPresent(word, index + 1, node.getChildren()[word.charAt(index + 1) - 97]);
        }

    }
    
    

//    public static int searchInTrie(String sentence, TrieNode rootNode) {
//        if(sentence == null || sentence.length() < 1) {
//            return -1;
//        }
//        
//        if(rootNode.getChildren()[sentence.charAt(0) - 97] != null) {
//            return isWord(sentence, 0, rootNode.getChildren()[sentence.charAt(0) - 97]);
//        }
//        
//        return -1;
//    }
//    
//    public static int isWord(String word, int index, TrieNode node) {
//        
//        if(word.length() -1 == index && node.isWord() == false) {
//            return -1;
//        } else if (node.isWord()) {
//            return index + 1;
//        }
//        
//        if(node.getChildren()[word.charAt(index + 1) - 97] != null) {
//            return isWord(word, index + 1, node.getChildren()[word.charAt(index + 1) - 97]);
//        } else {
//            return -1;
//        }
//        
//    }
//    
//    public static boolean isCompleteWord(String word, int index, TrieNode node) {
//        
//        if(node == null) {
//            return false;
//        } 
//        
//        char charValue = word.charAt(index);
//        if(index == word.length() - 1) {
//            return node.isWord();
//        } else {
//            return isCompleteWord(word, index + 1, node.getChildren()[word.charAt(index + 1) - 97]);
//        }
//        
//    }

}
