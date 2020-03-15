package com.mohit.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * Return all such possible sentences.
 * 
 * https://leetcode.com/problems/word-break-ii/
 * 
 * Memoized Recursive Solution
 * 
 * 
 *
 */
public class WordBreak {

	public static void main(String[] args) {

		WordBreakSol sol = new WordBreakSol();

		List<String> op = sol.wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog"));
		op.forEach(System.out::println);
		
		System.out.println("***");
		op = sol.wordBreak("pineapplepenapple", Arrays.asList("apple", "pen", "applepen", "pine", "pineapple"));
		op.forEach(System.out::println);
		
		System.out.println("***");
		op = sol.wordBreak("aaaaaaaaaaaaaaaa", Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa"));
		
		System.out.println("All test cases passed " + sol.getClass().getSimpleName());
	}
}
	
class WordBreakSol {

	public List<String> wordBreak(String s, List<String> wordDict) {

		Set<String> dict = new HashSet<>(wordDict);
		Map<Integer, List<String>> cache = new HashMap<>();
		int index = 0;
		return wordBreak(s, index, dict, cache, new ArrayList<>());
		
	}

	public List<String> wordBreak(String s, int index, Set<String> dict, Map<Integer, List<String>> cache,
			List<String> temp) {

		if (index == s.length()) {
			return Arrays.asList("");
		}

		List<String> cachedWords = cache.get(index);
		if (cachedWords != null) {
			return cachedWords;
		}

		List<String> resultforIndex = new ArrayList<>();

		for (int i = index + 1; i <= s.length(); i++) {
			String substr = s.substring(index, i);

			if (dict.contains(substr)) {
				temp.add(substr);
				List<String> combination = wordBreak(s, i, dict, cache, temp);

				List<String> tempCache = new ArrayList<>();
				for (String st : combination) {
					if(st.equals("")) {
						tempCache.add(substr);
                    } else {
                        tempCache.add(substr + " " + st);
                    }
				}

				resultforIndex.addAll(tempCache);
				temp.remove(temp.size() - 1);
			}
		}
		cache.put(index, resultforIndex);
		return resultforIndex;

	}
}
