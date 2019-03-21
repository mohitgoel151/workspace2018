package com.mohit.poc.trie;

public class TrieNode {

    private char value;
    private TrieNode[] children = new TrieNode[26];
    private boolean isWord;
    
    public TrieNode() {
        this(' ');
    }
    
    public TrieNode(char nodeValue) {
        this.value = nodeValue;
    }

    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }

    public TrieNode[] getChildren() {
        return children;
    }

    public boolean isWord() {
        return isWord;
    }

    public void setWord(boolean isWord) {
        this.isWord = isWord;
    }

}
