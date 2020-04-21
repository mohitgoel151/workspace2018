package com.mohit.poc.greedy;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/*
 * https://leetcode.com/problems/valid-parenthesis-string
 * 
 * Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. 
 * We define the validity of a string by these rules:

	Any left parenthesis '(' must have a corresponding right parenthesis ')'.
	Any right parenthesis ')' must have a corresponding left parenthesis '('.
	Left parenthesis '(' must go before the corresponding right parenthesis ')'.
	'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
	An empty string is also valid.
 */
public class ValidParenthesis {

	public static void main(String[] args) {
		ValidParenthesisSol sol = new ValidParenthesisSol();
		sol.execute();
	}
}

class ValidParenthesisSol {

	public void execute() {
		assertTrue(checkValidString("()"));
		assertTrue(checkValidString("(*)"));
		assertTrue(checkValidString("(*))"));
		assertFalse(checkValidString("(*)))"));
		
		assertTrue(helper("()", 0, 0));
		assertTrue(helper("(*)", 0, 0));
		assertTrue(helper("(*))", 0, 0));
		assertFalse(helper("(*)))", 0, 0));
		System.out.println("All passed " + this.getClass().getSimpleName());
	}

	/*
	 * When checking whether the string is valid, we only cared about the "balance": the number of extra, open left brackets as we parsed through the string. For example, when checking whether '(()())' is valid, we had a balance of 1, 2, 1, 2, 1, 0 as we parse through the string: '(' has 1 left bracket, '((' has 2, '(()' has 1, and so on. This means that after parsing the first i symbols, (which may include asterisks,) we only need to keep track of what the balance could be.

		For example, if we have string '(***)', then as we parse each symbol, the set of possible values for the balance is [1] for '('; [0, 1, 2] for '(*'; [0, 1, 2, 3] for '(**'; [0, 1, 2, 3, 4] for '(***', and [0, 1, 2, 3] for '(***)'.

		Furthermore, we can prove these states always form a contiguous interval. Thus, we only need to know the left and right bounds of this interval. That is, we would keep those intermediate states described above as [lo, hi] = [1, 1], [0, 2], [0, 3], [0, 4], [0, 3]
	 */
	private boolean checkValidString(String s) {
		int lo = 0, hi = 0;
		for (char c : s.toCharArray()) {
			lo += c == '(' ? 1 : -1;
			hi += c != ')' ? 1 : -1;
			if (hi < 0)
				break;
			lo = Math.max(lo, 0);
		}
		return lo == 0;
	}
	
	
	/*
	 * Recursion approach
	 */
	private boolean helper(String s, int index, int open) {
        
        if(s.length() == index) {
            return open == 0 ? true : false;
        } else if (open < 0) {
            return false;
        }
        
        char currentChar = s.charAt(index);
        
        if(currentChar == '(') {
            return helper(s, index+1, open+1);
        } else if (currentChar == ')') {
            return helper(s, index+1, open-1);
        } else {
            return helper(s, index+1, open+1) || helper(s, index+1, open-1) || helper(s, index+1, open);
        }
        
    }
}
