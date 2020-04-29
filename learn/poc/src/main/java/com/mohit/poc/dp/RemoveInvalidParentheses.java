package com.mohit.poc.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * https://leetcode.com/problems/remove-invalid-parentheses
 * Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results. 
 * Note: The input string may contain letters other than the parentheses ( and ).
 *
 * Important Concepts :
 * 1. How to find min no of parenthesis to remove to make it balance
 * 2. DFS approach
 */
public class RemoveInvalidParentheses {

	public static void main(String[] args) {

		RemoveInvalidParenthesesSol sol = new RemoveInvalidParenthesesSol();
		System.out.println(sol.removeInvalidParentheses("((()("));
		System.out.println(sol.removeInvalidParentheses("()())()"));
		System.out.println(sol.removeInvalidParentheses("(a)())()"));
		System.out.println(sol.removeInvalidParentheses(")("));

		System.out.println("All passed " + sol.getClass().getSimpleName());
	}

}

class RemoveInvalidParenthesesSol {

	public List<String> removeInvalidParentheses(String s) {

		if (s == null || s.length() == 0) {
			return Arrays.asList("");
		}

		int left = 0;
		int right = 0;

		Set<String> resultSet = new HashSet<>();

		/*
		 * This loop find out how many left and right paranthesis are to be removed.
		 * Right will never be decremented
		 */
		for (char aChar : s.toCharArray()) {

			if (aChar == '(') {
				left++;
			} else if (aChar == ')') {

				if (left == 0) {
					/*
					 * unbalanced closing brace which has to be removed
					 */
					right++;
				} else { // Have some open brace to balance current closing brace
					// So decrement pending open braces
					left--;
				}
			}
		}

		helper(s, 0, 0, 0, left, right, new StringBuilder(), resultSet);
		return new ArrayList<>(resultSet);
	}

	private void helper(String s, int index, int open, int close, int left, int right, StringBuilder builder,
			Set<String> resultSet) {

		if (left == 0 && right == 0 && index == s.length()) {
			resultSet.add(builder.toString());
			return;
		}
		if (left < 0 || right < 0 || close > open || index >= s.length()) {
			return;
		}

		char currentChar = s.charAt(index);

		if (currentChar != '(' && currentChar != ')') {
			builder.append(currentChar);
			helper(s, index + 1, open, close, left, right, builder, resultSet);
			builder.deleteCharAt(builder.length() - 1);

		} else if (currentChar == '(') {

			// don't consider currentChar (left-1)
			helper(s, index + 1, open, close, left - 1, right, builder, resultSet);

			// consider (open+1)
			builder.append(currentChar);
			helper(s, index + 1, open + 1, close, left, right, builder, resultSet);
			builder.deleteCharAt(builder.length() - 1);

		} else {

			// don't consider currentchar (right-1)
			helper(s, index + 1, open, close, left, right - 1, builder, resultSet);

			// consider (close+1)
			builder.append(currentChar);
			helper(s, index + 1, open, close + 1, left, right, builder, resultSet);
			builder.deleteCharAt(builder.length() - 1);
		}

	}
}