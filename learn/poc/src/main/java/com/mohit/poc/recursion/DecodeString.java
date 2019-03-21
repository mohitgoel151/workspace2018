package com.mohit.poc.recursion;

import static org.junit.Assert.assertEquals;

/**
 * 
 * https://leetcode.com/problems/decode-string/
 *
 */
public class DecodeString {

    public void execute() {
        
        assertEquals("aaabcbc", decodedString("3[a]2[bc]"));
        assertEquals("accaccacc", decodedString("3[a2[c]]"));
        assertEquals("abccabccabcc", decodedString("3[ab2[c]]"));
        assertEquals("abcabccdcdcdef", decodedString("2[abc]3[cd]ef"));
        System.out.println(" :) All test cases passed");
        
    }
    
    private String decodedString(String input) {
        
         if(input == null || input.length() == 0) {
             return "";
         }
        return decode(input);
    }
    
    private String decode(String input) {
        
        StringBuffer tempBuffer = new StringBuffer("");
        StringBuffer multiplyingFac = new StringBuffer("");
        for(int index = 0; index< input.length(); index++) {
            
            if(Character.isLetter(input.charAt(index))) {
                tempBuffer.append(input.charAt(index));
            } else if(Character.isDigit(input.charAt(index))) {
                multiplyingFac.append(input.charAt(index));
            } else if(input.charAt(index) == '[') {
                //find closing brace
                int multiplyingFactor = Integer.parseInt(multiplyingFac.toString());
                multiplyingFac.delete(0, multiplyingFac.length());
                
                String remainingString = input.substring(index + 1); //zb2[c]]ab
                int matchClosingIndex = closingIndex(remainingString);
                String enclosingSubString = input.substring(index + 1, matchClosingIndex + index + 1);
                
                String aa = decode(enclosingSubString);
                for(int fac = 0; fac < multiplyingFactor; fac++) {
                    tempBuffer.append(aa);
                }
                index += matchClosingIndex + 1;
            } 
        }
        return tempBuffer.toString();
    }
    
    private int closingIndex(String str) {
        int openBrace = 1;
        int index = 0;
        int closing = str.length() - 1;
        while(true) {
            if(str.charAt(index) == '[') {
                openBrace++;
            } else if (str.charAt(index) == ']') {
                openBrace--;
                if(openBrace == 0) {
                    closing = index;
                    break;
                }
            } 
            index++;
        }
        return closing;
    }

}
