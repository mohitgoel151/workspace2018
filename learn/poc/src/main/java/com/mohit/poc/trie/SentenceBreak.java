package com.mohit.poc.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://www.geeksforgeeks.org/word-break-problem-using-backtracking/
 * 
 * Given a valid sentence without any spaces between the words and a dictionary of valid English words, find
 * all possible ways to break the sentence in individual dictionary words.
 *
 */
public class SentenceBreak {

    TrieNode rootNode = null;
    List<String> trieWords = Arrays.asList("mobile", "samsung", "sam", "sung", "man", "mango", "icecream", "and", "go", "i", "love", "ice", "cream");

    public void execute() {

        rootNode = TrieHelper.generateTrie(trieWords);
        String input = "iloveicecreamandmango";

        wordbreak(input);
    }

    private void wordbreak(String input) {
        if (input == null || input.length() < 1) {
            return;
        }
        
        List<String> op = new ArrayList<>();
        wordBreakUtil(input.toLowerCase(), 1, op);
    }

    private void wordBreakUtil(String sentence, int start, List<String> op) {

        for (int i = start; i <= sentence.length(); i++) {
            String subString = sentence.substring(0, i);
            boolean isValid = isValidWord(subString);

            if (isValid) {
                op.add(subString);

                if (i >= sentence.length() - 1) {
                    System.out.println(op);
                } else {
                    wordBreakUtil(sentence.substring(i), 1, op);
                }

                op.remove(subString);
            }
        }
    }

    private boolean isValidWord(String substring) {
        return TrieHelper.isPresentInDict(substring, rootNode);
    }

}
