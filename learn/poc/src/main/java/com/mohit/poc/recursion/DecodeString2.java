package com.mohit.poc.recursion;

import static org.junit.Assert.assertEquals;

import org.apache.commons.lang3.StringUtils;

public class DecodeString2 {
	
    public void execute() {
        
        assertEquals("aaabcbc", decodedString("3[a]2[bc]"));
        assertEquals("accaccacc", decodedString("3[a2[c]]"));
        assertEquals("abccabccabcc", decodedString("3[ab2[c]]"));
        assertEquals("abcabccdcdcdef", decodedString("2[abc]3[cd]ef"));
        
        assertEquals("ababababababababababababc", decodedString("12[ab]c"));
        assertEquals("abababababababababababab", decodedString("12[ab]"));
        
        assertEquals("cababababababababababababc", decodedString("c12[ab]c"));
        assertEquals("cabababababababababababab", decodedString("c12[ab]"));
        
        System.out.println(" :) All test cases passed");
        
    }

	private String decodedString(String inputStr) {
		
		if(StringUtils.isBlank(inputStr)) {
			throw new IllegalArgumentException();
		}
		
		StringBuilder builder = new StringBuilder();
		
		for(int i = 0; i <  inputStr.length(); i++) {
			
			Character aChar = inputStr.charAt(i);
			
			if(Character.isLetter(aChar)) {
				builder.append(aChar);
			} else if (Character.isDigit(aChar)) {
				int multiFactorIndex = getMultiplicationFactorIndex(inputStr, i+1); //Index of '['
				int factor = Integer.parseInt(inputStr.substring(i, multiFactorIndex));
				
				i = multiFactorIndex + 1; //Index of next char after '['
				
				int matchingClosingBrace = getMatchingClosingBrace(inputStr, i);
				String internalStr = decodedString(inputStr.substring(i, matchingClosingBrace));
				
				
				for(int count = 0; count<factor; count++) {
					builder.append(internalStr);
				}
				i = matchingClosingBrace;
			}
		}
		return builder.toString();
	}

	private int getMatchingClosingBrace(String inputStr, int i) {
		int openBrace = 1;
		
		for(int index = i; index < inputStr.length(); index++) {
			
			if(inputStr.charAt(index) == '[') {
				openBrace++;
			} else  if (inputStr.charAt(index) == ']') {
				openBrace--;
				if(openBrace == 0) {
					return index;
				}
			}
		}
		throw new IllegalArgumentException();
	}

	private int getMultiplicationFactorIndex(String inputStr, int i) {
		
		while(Character.isDigit(inputStr.charAt(i))) {
			i++;
		}
		
		return i;
	}
    
    
    

}
