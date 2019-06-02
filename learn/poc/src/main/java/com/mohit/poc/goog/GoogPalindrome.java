package com.mohit.poc.goog;

import static org.junit.Assert.assertEquals;

/**
 * 
Check if a string is palindrome  or not (ignore any special charters) e.g.   "  s9,!g)9s" is a palindrom
 *
 */
public class GoogPalindrome {
	
	
	public void execute() {
		
		assertEquals(true, isPalindrome("  s9,!g)9s"));
		
		assertEquals(true, isPalindrome("  s"));
		
		assertEquals(false, isPalindrome("  s9 "));
		assertEquals(false, isPalindrome("  s!9 "));
		assertEquals(false, isPalindrome("  s!9 "));
		
		assertEquals(true, isPalindrome("  s!9s)))"));
		
	}

	private boolean isPalindrome(String input) {
		boolean result = true;
		
		int start = getNextFwd(input, 0);
		int end = getNextBackward(input, input.length() - 1);
		
		while(start < end) {
			
			if(input.charAt(start) != input.charAt(end)) {
				return false;
			}
			
			start = getNextFwd(input, start+1);
			end = getNextBackward(input, end-1);
			
		}
		
		return result;
	}

	private int getNextBackward(String input, int i) {
		while(!Character.isLetterOrDigit(input.charAt(i))) {
			i--;
		}
		return i;
	}

	private int getNextFwd(String input, int i) {
		while(!Character.isLetterOrDigit(input.charAt(i))) {
			i++;
		}
		return i;
	}
	
	

}
